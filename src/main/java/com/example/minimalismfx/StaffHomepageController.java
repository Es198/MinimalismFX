package com.example.minimalismfx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.chart.BarChart;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

public class StaffHomepageController {

    @FXML
    private Text allOrdersHeading;

    @FXML
    private Button item1ConfirmButton;

    @FXML
    private Text item1Count;

    @FXML
    private Button item1MinusButton;

    @FXML
    private Button item1PlusButton;

    @FXML
    private VBox item1VBox;

    @FXML
    private Button item2ConfirmButton;

    @FXML
    private Text item2Count;

    @FXML
    private Button item2MinusButton;

    @FXML
    private Button item2PlusButton;

    @FXML
    private VBox item2VBox;

    @FXML
    private Button item3ConfirmButton;

    @FXML
    private Text item3Count;

    @FXML
    private Button item3MinusButton;

    @FXML
    private Button item3PlusButton;

    @FXML
    private VBox item3VBox;

    @FXML
    private Text ordersList;

    @FXML
    private BarChart<?, ?> stockChart;

    @FXML
    private Text stockChartHeading;

    @FXML
    private Text totalSalesAmount;

    @FXML
    private Text totalSalesHeading;

    @FXML
    void confirmStockChange1(ActionEvent event) {

    }

    @FXML
    void confirmStockChange2(ActionEvent event) {

    }

    @FXML
    void confirmStockChange3(ActionEvent event) {

    }

    @FXML
    void decrementCounter1(ActionEvent event) {

    }

    @FXML
    void decrementCounter2(ActionEvent event) {

    }

    @FXML
    void decrementCounter3(ActionEvent event) {

    }

    @FXML
    void incrementCounter1(ActionEvent event) {

    }

    @FXML
    void incrementCounter2(ActionEvent event) {

    }

    @FXML
    void incrementCounter3(ActionEvent event) {

    }

}
