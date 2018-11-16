package com.credits.wallet.desktop.controller;

import com.credits.client.node.exception.NodeClientException;
import com.credits.client.node.pojo.TransactionData;
import com.credits.client.node.thrift.generated.TransactionState;
import com.credits.client.node.thrift.generated.TransactionsStateGetResult;
import com.credits.general.exception.CreditsException;
import com.credits.general.pojo.TransactionRoundData;
import com.credits.general.util.Callback;
import com.credits.general.util.Converter;
import com.credits.wallet.desktop.AppState;
import com.credits.wallet.desktop.VistaNavigator;
import com.credits.wallet.desktop.struct.TransactionTabRow;
import com.credits.wallet.desktop.utils.FormUtils;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.concurrent.ConcurrentHashMap;

import static com.credits.client.node.service.NodeApiServiceImpl.async;
import static com.credits.client.node.thrift.generated.TransactionState.INPROGRESS;
import static com.credits.client.node.thrift.generated.TransactionState.INVALID;
import static com.credits.client.node.thrift.generated.TransactionState.VALID;
import static com.credits.wallet.desktop.AppState.NODE_ERROR;
import static com.credits.wallet.desktop.AppState.account;
import static com.credits.wallet.desktop.AppState.detailFromHistory;
import static com.credits.wallet.desktop.AppState.nodeApiService;
import static com.credits.wallet.desktop.AppState.selectedTransactionRow;

/**
 * Created by goncharov-eg on 29.01.2018.
 */
public class HistoryController implements Initializable {
    private static final String ERR_GETTING_TRANSACTION_HISTORY = "Error getting transaction history";
    private static final int INIT_PAGE_SIZE = 100;
    private static final int FIRST_PAGE_NUMBER = 1;
    private final static Logger LOGGER = LoggerFactory.getLogger(HistoryController.class);
    public static final int COUNT_ROUNDS_LIFE = 50;

    @FXML
    BorderPane bp;
    @FXML
    private TableView<TransactionTabRow> approvedTableView;

    @FXML
    private TableView<TransactionTabRow> unapprovedTableView;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        FormUtils.resizeForm(bp);


        initTable(approvedTableView);
        initTable(unapprovedTableView);

        fillApprovedTable();
        fillUnapprovedTable();

    }

    private void initTable(TableView<TransactionTabRow> tableView) {
        tableView.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("innerId"));
        tableView.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("source"));
        tableView.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("target"));
        tableView.getColumns().get(3).setCellValueFactory(new PropertyValueFactory<>("amount"));
        tableView.getColumns().get(4).setCellValueFactory(new PropertyValueFactory<>("state"));
        tableView.setOnMousePressed(event -> {
            if (event.isPrimaryButtonDown() && event.getClickCount() == 2) {
                TransactionTabRow tabRow = tableView.getSelectionModel().getSelectedItem();
                if (tabRow != null) {
                    selectedTransactionRow = tabRow;
                    detailFromHistory = true;
                    VistaNavigator.loadVista(VistaNavigator.TRANSACTION);
                }
            }
        });
    }

    private void fillUnapprovedTable() {
        if (AppState.sourceMap !=null && AppState.sourceMap.get(account) != null) {
            ConcurrentHashMap<Long, TransactionRoundData> sourceTransactionMap = AppState.sourceMap.get(account);
            /*List<Long> validIds =
                transactionsList.stream().map(TransactionData::getId).collect(Collectors.toList());
            sourceTransactionMap.remove(validIds)*/
            List<Long> ids = new ArrayList<>(sourceTransactionMap.keySet());
            async(() -> nodeApiService.getTransactionsState(account, ids),
                handleGetTransactionsStateResult(sourceTransactionMap));
        }
    }

    private void fillApprovedTable() {
        async(() -> nodeApiService.getTransactions(account, FIRST_PAGE_NUMBER, INIT_PAGE_SIZE),
            handleGetTransactionsResult());
    }

    private Callback<List<TransactionData>> handleGetTransactionsResult() {
        return new Callback<List<TransactionData>>() {

            @Override
            public void onSuccess(List<TransactionData> transactionsList) throws CreditsException {

                List<TransactionTabRow> approvedList = new ArrayList<>();
                transactionsList.forEach(transactionData -> {
                    TransactionTabRow tableRow = new TransactionTabRow();
                    tableRow.setAmount(Converter.toString(transactionData.getAmount()));
                    tableRow.setSource(Converter.encodeToBASE58(transactionData.getSource()));
                    tableRow.setTarget(Converter.encodeToBASE58(transactionData.getTarget()));
                    tableRow.setInnerId(transactionData.getId());
                    tableRow.setState(VALID.name());
                    approvedList.add(tableRow);
                });
                refreshTableViewItems(approvedTableView, approvedList);
            }

            private void refreshTableViewItems(TableView<TransactionTabRow> tableView, List<TransactionTabRow> itemList) {
                Platform.runLater(() -> {
                    tableView.getItems().clear();
                    tableView.getItems().addAll(itemList);
                });
            }

            @Override
            public void onError(Throwable e) {
                LOGGER.error(e.getMessage());
                if (e instanceof NodeClientException) {
                    FormUtils.showError(NODE_ERROR);
                } else {
                    FormUtils.showError(ERR_GETTING_TRANSACTION_HISTORY);
                }
            }
        };
    }

    private Callback<TransactionsStateGetResult> handleGetTransactionsStateResult(
        ConcurrentHashMap<Long, TransactionRoundData> transactionMap) {
        return new Callback<TransactionsStateGetResult>() {
            @Override
            public void onSuccess(TransactionsStateGetResult transactionsStates) throws CreditsException {
                Map<Long, TransactionState> states = transactionsStates.getStates();
                states.forEach((k, v) -> {
                    if (v.getValue() == VALID.getValue()) {
                        transactionMap.remove(k);
                    }
                });

                int curRound = transactionsStates.getRoundNum();
                transactionMap.entrySet()
                    .removeIf(e -> e.getValue().getRoundNumber() != 0 &&
                        curRound >= e.getValue().getRoundNumber() + COUNT_ROUNDS_LIFE);

                List<TransactionTabRow> unapprovedList = new ArrayList<>();

                transactionMap.forEach((id, value) -> {
                    TransactionTabRow tableRow = new TransactionTabRow();
                    tableRow.setInnerId(id);
                    tableRow.setAmount(value.getAmount());
                    tableRow.setCurrency(value.getCurrency());
                    tableRow.setSource(value.getSource());
                    tableRow.setTarget(value.getTarget());
                    if (states.get(id) != null) {
                        if (states.get(id).getValue() == INVALID.getValue()) {
                            tableRow.setState(INVALID.name());
                        } else if (curRound == 0 || states.get(id).getValue() == INPROGRESS.getValue()) {
                            tableRow.setState(INPROGRESS.name());
                        }
                        unapprovedList.add(tableRow);
                    }
                });
                refreshTableViewItems(unapprovedTableView, unapprovedList);


            }

            @Override
            public void onError(Throwable e) {
                Platform.runLater(()->approvedTableView.getItems().clear());
            }
        };
    }

    private void refreshTableViewItems(TableView<TransactionTabRow> tableView, List<TransactionTabRow> itemList) {
        Platform.runLater(() -> {
            tableView.getItems().clear();
            tableView.getItems().addAll(itemList);
        });
    }

    @FXML
    private void handleBack() {
        VistaNavigator.loadVista(VistaNavigator.WALLET);
    }

    @FXML
    private void handleRefresh() {
        fillApprovedTable();
        fillUnapprovedTable();
    }
}

