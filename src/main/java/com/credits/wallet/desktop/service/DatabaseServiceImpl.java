package com.credits.wallet.desktop.service;

import com.credits.client.node.pojo.TransactionData;
import com.credits.client.node.service.NodeApiService;
import com.credits.wallet.desktop.database.DatabaseHelper;
import com.credits.wallet.desktop.database.table.Transaction;
import com.credits.wallet.desktop.database.table.TransactionType;
import lombok.extern.slf4j.Slf4j;

import java.nio.charset.StandardCharsets;
import java.util.concurrent.locks.ReentrantLock;

import static com.credits.general.util.GeneralConverter.encodeToBASE58;
import static java.lang.Math.min;
import static java.util.concurrent.CompletableFuture.runAsync;
import static java.util.stream.Collectors.toList;

@Slf4j
public class DatabaseServiceImpl implements DatabaseService {
    final NodeApiService nodeApiService;
    final DatabaseHelper database;
    private final ReentrantLock lock;

    public DatabaseServiceImpl(NodeApiService nodeApiService, DatabaseHelper database) {
        this.nodeApiService = nodeApiService;
        this.database = database;
        database.connectAndInitialize();
        database.createTablesIfNotExist();
        lock = new ReentrantLock(true);
    }

    @Override
    public void keepLogin(String address) {
        runAsync(() -> {
            try {
                lock.lock();
                database.getOrCreateApplicationMetadata(address);
            } finally {
                lock.unlock();
            }
        });
    }

    @Override
    public void updateTransactionsOnAddress(String address) {
        runAsync(() -> {
            try {
                lock.lock();
                final var metadata = database.getOrCreateApplicationMetadata(address);
                var receivedTrx = metadata.getAmountTransactions();
                var totalTrx = metadata.getAmountTransactions();
                for (var diff = 10; diff > 0; diff = min(totalTrx - receivedTrx, 100)) {
                    final var response = nodeApiService.getTransactionsAndAmount(address, receivedTrx, diff);
                    receivedTrx += response.getTransactionsList().size();
                    totalTrx = response.getAmountTotalTransactions();
                    final var transactions = response.getTransactionsList();
                    final var entities = transactions.stream().map(this::createTransactionDBEntity).collect(toList());
                    database.keepTransactionsList(entities);
                }
                metadata.setAmountTransactions(receivedTrx);
                database.updateApplicationMetadata(metadata);
            } finally {
                lock.unlock();
            }
        }).exceptionally(exception -> {
            log.error("error occurred while update transactions table. Reason: {}", exception.getMessage());
            return null;
        });
    }

    private Transaction createTransactionDBEntity(TransactionData transactionData) {
        final var sender = database.getOrCreateWallet(encodeToBASE58(transactionData.getSource()));
        final var receiver = database.getOrCreateWallet(encodeToBASE58(transactionData.getTarget()));
        final var amount = transactionData.getAmount().toString();
        final var fee = "";
        final var timeCreation = 0L;
        final var transactionType = new TransactionType(transactionData.getType().toString());
        final var blockNumber = transactionData.getBlockNumber();
        final var trxIndex = transactionData.getIndexIntoBlock();
        final var userData = transactionData.getCommentBytes() != null
                             ? new String(transactionData.getCommentBytes(), StandardCharsets.UTF_8)
                             : "";

        return new Transaction(sender, receiver, amount, fee, timeCreation, userData, transactionType, blockNumber, trxIndex);
    }
}
