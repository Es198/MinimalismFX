package com.example.minimalismfx;

import javafx.beans.value.ObservableStringValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.*;
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
    private Button logoutButton;
    @FXML
    private TextArea textAreaID;



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



    public void initialize() throws FileNotFoundException {
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
        textAreaID.appendText(admin.displayAllOrders());
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
        items = cart.readingCSVFile("src/main/resources/com/example/minimalismfx/itemFile.csv");
        if (size == null){
            countText.setFill(Color.RED);
            return;
        }

        for(Item item: items){
            if(itemName.equals(item.getItemName()) && size.equals(item.getItemSize())) {
                int availableStock = item.getItemStock();
                int quantity = Integer.parseInt(countText.getText());
                int newStock = availableStock + quantity;

                //Kadri's code to try to update csv file when updatestcok is called!
                try {
                    updateStockCSV(item.getItemName(), item.getItemSize(), item.getItemStock());
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }

                if((newStock) < 0) {
                    countText.setFill(Color.RED);
                } else {
                    item.setItemStock(newStock);
                    countText.setText("0");
                    countText.setFill(Color.BLACK);
                    stockTable.refresh();
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
        String itemTextPath = "src/main/resources/com/example/minimalismfx/itemFile.csv";

        // Read the existing CSV data and update it
        try (BufferedReader reader = new BufferedReader(new FileReader(itemTextPath))) {
            ArrayList<String> updatedCSVStock = new ArrayList<>();

            while (reader.ready()) {
                String line = reader.readLine();
                String[] fields = line.split(", ");

                // Checking that name matches the specified item object and size
                if (fields.length >= 4 && fields[0].equals(itemName) && fields[1].equals(itemSize)) {
                    fields[3] = Integer.toString(itemStock);
                }

                // Add the updated or unchanged line to the temporary list
                updatedCSVStock.add(String.join(",", fields));
            }

            // Write the updated data to the original file
            FileWriter fileWriter = new FileWriter(itemTextPath);
            for (String line : updatedCSVStock) {
                fileWriter.write(line + "\n");
            }

            // Close the FileWriter
            fileWriter.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return; // Exit early if the file doesn't exist
        } catch (IOException e) {
            e.printStackTrace();
            return; // Exit early if there's an issue writing the file
        }
    }

    @FXML
    void setUpLogoutButton(ActionEvent event) throws IOException {
        FXMLLoader loader=new FXMLLoader();
        loader.setLocation(AdminController.class.getResource("LoginPageV2.fxml"));
        Parent rootParent =loader.load();
        Scene rootScene = new Scene(rootParent);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(rootScene);
        stage.show();

    }
}
