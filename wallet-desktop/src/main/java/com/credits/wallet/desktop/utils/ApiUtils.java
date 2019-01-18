package com.credits.wallet.desktop.utils;

import com.credits.client.node.exception.NodeClientException;
import com.credits.client.node.pojo.SmartContractData;
import com.credits.client.node.pojo.SmartContractInvocationData;
import com.credits.client.node.pojo.SmartContractTransactionFlowData;
import com.credits.client.node.pojo.TransactionFlowData;
import com.credits.client.node.pojo.TransactionFlowResultData;
import com.credits.client.node.util.NodePojoConverter;
import com.credits.client.node.util.SignUtils;
import com.credits.general.pojo.TransactionRoundData;
import com.credits.general.util.exception.ConverterException;
import com.credits.wallet.desktop.AppState;
import com.credits.wallet.desktop.Session;
import org.apache.commons.lang3.tuple.Pair;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigDecimal;
import java.nio.charset.StandardCharsets;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import static com.credits.client.node.util.NodeClientUtils.serializeByThrift;
import static com.credits.client.node.util.TransactionIdCalculateUtils.CalcTransactionIdSourceTargetResult;
import static com.credits.wallet.desktop.AppState.OFFERED_MAX_FEE;
import static com.credits.wallet.desktop.AppState.nodeApiService;
import static com.credits.wallet.desktop.utils.SmartContractsUtils.generateSmartContractAddress;
import static java.math.BigDecimal.ZERO;

/**
 * Created by Rustem Saidaliyev on 20-Mar-18.
 */
public class ApiUtils {

    private final static Logger LOGGER = LoggerFactory.getLogger(ApiUtils.class);

    public static Pair<Long, TransactionFlowResultData> createTransaction(
        CalcTransactionIdSourceTargetResult transactionData, BigDecimal amount, String text, Session session
    ) throws NodeClientException, ConverterException {
        return Pair.of(transactionData.getTransactionId(), nodeApiService.transactionFlow(getTransactionFlowData(transactionData, amount, null, text, session)));
    }

    public static Pair<Long, TransactionFlowResultData> createSmartContractTransaction(
        CalcTransactionIdSourceTargetResult transactionData,
        SmartContractData smartContractData, Session session) throws NodeClientException, ConverterException {

        smartContractData.setAddress(
                generateSmartContractAddress(
                        transactionData.getByteSource(),
                        transactionData.getTransactionId(),
                        smartContractData.getSmartContractDeployData().getByteCodeObjects()));

        SmartContractInvocationData smartContractInvocationData =
            new SmartContractInvocationData(smartContractData.getSmartContractDeployData(),
                    smartContractData.getMethod(), smartContractData.getParams(), false);

        SmartContractTransactionFlowData scData = new SmartContractTransactionFlowData(
            getTransactionFlowData(transactionData, ZERO, serializeByThrift(smartContractInvocationData), null,session),
            smartContractInvocationData);

        return Pair.of(transactionData.getTransactionId(), nodeApiService.smartContractTransactionFlow(scData));
    }

    private static TransactionFlowData getTransactionFlowData(
        CalcTransactionIdSourceTargetResult transactionData,
        BigDecimal amount,
        byte[] smartContractBytes,
        String text, Session session
    ) {
        long id = transactionData.getTransactionId();
        byte[] source = transactionData.getByteSource();
        byte[] target = transactionData.getByteTarget();
        short offeredMaxFee = OFFERED_MAX_FEE;
        byte currency = 1;
        byte[] textBytes = null;
        if (text != null) {
            textBytes = text.getBytes(StandardCharsets.UTF_8);
        }

        saveTransactionIntoMap(transactionData, amount.toString(), String.valueOf(currency),session);

        TransactionFlowData transactionFlowData =
            new TransactionFlowData(id, source, target, amount, offeredMaxFee, smartContractBytes, textBytes);
        SignUtils.signTransaction(transactionFlowData, AppState.privateKey);
        return transactionFlowData;
    }


    private static void saveTransactionIntoMap(
        CalcTransactionIdSourceTargetResult transactionData, String amount,
        String currency, Session session) {
        session.sourceMap.computeIfAbsent(session.account, key -> new ConcurrentHashMap<>());
        Map<Long, TransactionRoundData> sourceMap = session.sourceMap.get(session.account);
        long shortTransactionId = NodePojoConverter.getShortTransactionId(transactionData.getTransactionId());
        TransactionRoundData transactionRoundData =
            new TransactionRoundData(String.valueOf(shortTransactionId), transactionData.getWideSource(),
                transactionData.getWideTarget(), amount, currency);
        sourceMap.put(shortTransactionId, transactionRoundData);
    }

    public static void saveTransactionRoundNumberIntoMap(int roundNumber, long transactionId, Session session) {
        ConcurrentHashMap<Long, TransactionRoundData> tempTransactionsData =
            session.sourceMap.get(session.account);
        TransactionRoundData transactionRoundData =
            tempTransactionsData.get(NodePojoConverter.getShortTransactionId(transactionId));
        transactionRoundData.setRoundNumber(roundNumber);
    }

}