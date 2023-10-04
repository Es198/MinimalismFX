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
            tshirtCount.setFill(Color.BLACK);
            int quantity = Integer.parseInt(tshirtCount.getText());
            String size = tshirtSizeBox.getValue();

            for(Item item: items){
                if("T-shirt".equals(item.getItemName()) && size.equals(item.getItemSize())) {
                    int availableStock = item.getItemStock();
                    int newStock = availableStock + quantity;

                    if((newStock) < 0) {
                        tshirtCount.setFill(Color.RED);
                    } else {
                        item.setItemStock(newStock);
                        tshirtCount.setText("0");
                    }
                    break;
                }
            }


        } else if (event.getSource() == jumperConfirmButton) {
            jumperCount.setFill(Color.BLACK);
            int quantity = Integer.parseInt(jumperCount.getText());
            String size = jumperSizeBox.getValue();

            for(Item item: items){
                if("Jumper".equals(item.getItemName()) && size.equals(item.getItemSize())) {
                    int availableStock = item.getItemStock();
                    int newStock = availableStock + quantity;

                    if((newStock) < 0) {
                        jumperCount.setFill(Color.RED);
                    } else {
                        item.setItemStock(newStock);
                        jumperCount.setText("0");
                    }
                    break;
                }
            }

        } else if (event.getSource() == trouserConfirmButton) {
            trouserCount.setFill(Color.BLACK);
            int quantity = Integer.parseInt(trouserCount.getText());
            String size = trouserSizeBox.getValue();

            for(Item item: items){
                if("Trouser".equals(item.getItemName()) && size.equals(item.getItemSize())) {
                    int availableStock = item.getItemStock();
                    int newStock = availableStock + quantity;

                    if((newStock) < 0) {
                        trouserCount.setFill(Color.RED);
                    } else {
                        item.setItemStock(newStock);
                        trouserCount.setText("0");
                    }
                    break;
                }
            }
        }

    }

    @FXML
    void decrementCounter(ActionEvent event) {
        if(event.getSource() == tshirtMinusButton) {
            int count = Integer.parseInt(tshirtCount.getText()) - 1;
            tshirtCount.setText(String.valueOf(count));
        } else if (event.getSource() == jumperMinusButton) {
            int count = Integer.parseInt(jumperCount.getText()) - 1;
            jumperCount.setText(String.valueOf(count));
        } else if (event.getSource() == trouserMinusButton) {
            int count = Integer.parseInt(trouserCount.getText()) - 1;
            trouserCount.setText(String.valueOf(count));
        }
    }

    @FXML
    void incrementCounter(ActionEvent event) {
        if(event.getSource() == tshirtPlusButton) {
            int count = Integer.parseInt(tshirtCount.getText()) + 1;
            tshirtCount.setText(String.valueOf(count));
        } else if (event.getSource() == jumperPlusButton) {
            int count = Integer.parseInt(jumperCount.getText()) + 1;
            jumperCount.setText(String.valueOf(count));
        } else if (event.getSource() == trouserPlusButton) {
            int count = Integer.parseInt(trouserCount.getText()) + 1;
            trouserCount.setText(String.valueOf(count));
        }
    }

}
