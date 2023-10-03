package com.example.minimalismfx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.chart.BarChart;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

public class AdminController {

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
    void confirmStockChange(ActionEvent event) {
    }

    @FXML
    void decrementCounter(ActionEvent event) {
        if(event.getSource() == item1MinusButton) {
            int count = Integer.parseInt(item1Count.getText()) - 1;
            item1Count.setText(String.valueOf(count));
        } else if (event.getSource() == item2MinusButton) {
            int count = Integer.parseInt(item2Count.getText()) - 1;
            item2Count.setText(String.valueOf(count));
        } else if (event.getSource() == item3MinusButton) {
            int count = Integer.parseInt(item3Count.getText()) - 1;
            item3Count.setText(String.valueOf(count));
        }
    }

    @FXML
    void incrementCounter(ActionEvent event) {
        if(event.getSource() == item1PlusButton) {
            int count = Integer.parseInt(item1Count.getText()) + 1;
            item1Count.setText(String.valueOf(count));
        } else if (event.getSource() == item2PlusButton) {
            int count = Integer.parseInt(item2Count.getText()) + 1;
            item2Count.setText(String.valueOf(count));
        } else if (event.getSource() == item3PlusButton) {
            int count = Integer.parseInt(item3Count.getText()) + 1;
            item3Count.setText(String.valueOf(count));
        }
    }

}
