package com.example.minimalismfx;

import javafx.beans.value.ObservableStringValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

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
    private Text stockChartHeading;

    @FXML
    private Text totalSalesAmount;

    @FXML
    private Text totalSalesHeading;

    @FXML
    private TableView<Item> stockTable;

    @FXML
    private TableColumn<Item, String> itemNameCol;

    @FXML
    private TableColumn<Item, String> itemSizeCol;

    @FXML
    private TableColumn<Item, Double> itemPriceCol;

    @FXML
    private TableColumn<Item, Double> itemStockCol;

    ShoppingCart cart = ShoppingCart.getInstance();
    ArrayList<Item> items;
    private Admin admin = Admin.getInstance();



    public void initializeElements() throws FileNotFoundException {
        items = cart.readingCSVFile("src/main/resources/com/example/minimalismfx/itemFile.csv");
        populateSizeChoiceBoxes();
        populateStockTable();
        populateOrdersList();
        populateTotalSales();
    }

    private void populateTotalSales() {
        totalSalesAmount.setText("£ " + admin.sum);
    }

    private void populateOrdersList() {
        ordersList.setText(admin.displayAllOrders());
    }


    private void populateSizeChoiceBoxes() {
        ObservableList<String> sizeOptions = FXCollections.observableArrayList("Small", "Medium", "Large");
        tshirtSizeBox.setItems(sizeOptions);
        jumperSizeBox.setItems(sizeOptions);
        trouserSizeBox.setItems(sizeOptions);
    }

    private void populateStockTable(){
        ObservableList<Item> data = FXCollections.observableArrayList();
        itemNameCol.setCellValueFactory(new PropertyValueFactory<>("itemName"));
        itemSizeCol.setCellValueFactory(new PropertyValueFactory<>("itemSize"));
        itemPriceCol.setCellValueFactory(new PropertyValueFactory<>("itemPrice"));
        itemStockCol.setCellValueFactory(new PropertyValueFactory<>("itemStock"));
        data.addAll(items);
        stockTable.setItems(data);
    }

    @FXML
    void confirmStockChange(ActionEvent event) throws IOException {
        if(event.getSource() == tshirtConfirmButton) {
           updateStock("T-shirt", tshirtSizeBox.getValue(), tshirtCount, items);
        } else if (event.getSource() == jumperConfirmButton) {
            updateStock("Jumper", jumperSizeBox.getValue(), jumperCount, items);
        } else if (event.getSource() == trouserConfirmButton) {
            updateStock("Trousers", trouserSizeBox.getValue(), trouserCount, items);
        }
    }

    private void updateStock(String itemName, String size, Text countText, ArrayList<Item> items) throws IOException {
        if (size == null){
            countText.setFill(Color.RED);
            return;
        }

        for(Item item: items){
            if(itemName.equals(item.getItemName()) && size.equals(item.getItemSize())) {
                int availableStock = item.getItemStock();
                int quantity = Integer.parseInt(countText.getText());
                int newStock = availableStock + quantity;

                if((newStock) < 0) {
                    countText.setFill(Color.RED);
                } else {
                    item.setItemStock(newStock);
                    countText.setText("0");
                    countText.setFill(Color.BLACK);
                    stockTable.refresh();
//                    updateStockCSV(itemName, size, newStock);
                }
                return;
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

    public void updateStockCSV(String itemName, String itemSize, int itemStock) throws IOException {
        String itemText = "src/main/resources/com/example/minimalismfx/itemFile.csv";
        Scanner scanner = new Scanner(itemText);
        ArrayList<String> updatedCSVStock = new ArrayList<>();

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            String[] fields = line.split(",");

            //checking that name matches to specified item object
            if (fields[0].equals(itemName) && fields[1].equals(itemSize)) {
                fields[3] = Integer.toString(itemStock);
            }

            //Adding the updated stock to CSV stock arraylist
            updatedCSVStock.add(String.join(",", fields));
        }

        scanner.close();

        // Create a new FileWriter to write the updated CSV data to the file
        FileWriter fileWriter = new FileWriter(itemText);

        for (String line : updatedCSVStock) {
            fileWriter.write(line + "\n");
        }

        fileWriter.close();
    }

}
