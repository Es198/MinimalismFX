package com.example.minimalismfx;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.chart.BarChart;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;

import java.io.FileNotFoundException;
import java.util.ArrayList;

public class AdminController {

    @FXML
    private Text allOrdersHeading;

    @FXML
    private Button tshirtConfirmButton;

    @FXML
    private Text tshirtCount;

    @FXML
    private Button tshirtMinusButton;

    @FXML
    private Button tshirtPlusButton;

    @FXML
    private ChoiceBox<String> tshirtSizeBox;

    @FXML
    private VBox tshirtVBox;

    @FXML
    private Button jumperConfirmButton;

    @FXML
    private Text jumperCount;

    @FXML
    private Button jumperMinusButton;

    @FXML
    private Button jumperPlusButton;

    @FXML
    private ChoiceBox<String> jumperSizeBox;

    @FXML
    private VBox jumperVBox;

    @FXML
    private Button trouserConfirmButton;

    @FXML
    private Text trouserCount;

    @FXML
    private Button trouserMinusButton;

    @FXML
    private Button trouserPlusButton;

    @FXML
    private ChoiceBox<String> trouserSizeBox;

    @FXML
    private VBox trouserVBox;

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

    public void initialize() {
        ObservableList<String> sizeOptions = FXCollections.observableArrayList("Small", "Medium", "Large");
        tshirtSizeBox.setItems(sizeOptions);
        jumperSizeBox.setItems(sizeOptions);
        trouserSizeBox.setItems(sizeOptions);
    }

    @FXML
    void confirmStockChange(ActionEvent event) throws FileNotFoundException {
        ShoppingCart cart = new ShoppingCart();
        ArrayList<Item> items = cart.readingCSVFile("src/main/resources/com/example/minimalismfx/itemFile.csv");

        if(event.getSource() == tshirtConfirmButton) {
           updateStock("T-shirt", tshirtSizeBox.getValue(), tshirtCount, items);
        } else if (event.getSource() == jumperConfirmButton) {
            updateStock("Jumper", tshirtSizeBox.getValue(), tshirtCount, items);
        } else if (event.getSource() == trouserConfirmButton) {
            updateStock("Trouser", tshirtSizeBox.getValue(), tshirtCount, items);
        }
    }

    private void updateStock(String itemName, String size, Text countText, ArrayList<Item> items){
        for(Item item: items){
            if(itemName.equals(item.getItemName()) && size.equals(item.getItemSize())) {
                int availableStock = item.getItemStock();
                int quantity = Integer.parseInt(trouserCount.getText());
                int newStock = availableStock + quantity;

                if((newStock) < 0) {
                    countText.setFill(Color.RED);
                } else {
                    item.setItemStock(newStock);
                    countText.setText("0");
                    countText.setFill(Color.BLACK);
                }
                break;
            }
        }
    }

    @FXML
    void decrementCounter(ActionEvent event) {
        if(event.getSource() == tshirtMinusButton) {
            updateCounter(tshirtCount, -1);
        } else if (event.getSource() == jumperMinusButton) {
            updateCounter(jumperCount, -1);
        } else if (event.getSource() == trouserMinusButton) {
            updateCounter(trouserCount, -1);
        }
    }

    @FXML
    void incrementCounter(ActionEvent event) {
        if(event.getSource() == tshirtPlusButton) {
            updateCounter(tshirtCount, 1);
        } else if (event.getSource() == jumperPlusButton) {
            updateCounter(jumperCount, 1);
        } else if (event.getSource() == trouserPlusButton) {
            updateCounter(trouserCount, 1);
        }
    }

    private void updateCounter(Text countText, int sign){
        int count = Integer.parseInt(countText.getText()) + sign;
        countText.setText(String.valueOf(count));
    }

}
