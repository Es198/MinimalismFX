package com.example.minimalismfx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.Scanner;

public class CartController {
    @FXML
    private TextField cartAddressTextField;

    @FXML
    private TextField cartCardDetailsTextField;

    @FXML
    private TextField cartNameTextField;

    @FXML
    private Label cartTotalPriceLabel;

    @FXML
    private Text cartTotalPriceText;

    @FXML
    private Button checkoutButton;

    @FXML
    private Text confirmationOfOrderText;
    private Parent root;
    private Scene scene;
    private Stage stage;

    @FXML
    private Text summaryOrderText;

    @FXML
    private Label orderDetailsLabel;

    @FXML
    private Button backButton;

    String orderDetails;

    ShoppingCart cart;
    Item itemClass;

    Admin admin = new Admin();

    double totalPrice;

    public CartController() {

    }
    public CartController(ShoppingCart cart) {
        this.cart = cart;
    }

    public void setCart(ShoppingCart cart) {
        this.cart = cart;
    }

    public Text getSummaryOrderText() {
        return summaryOrderText;
    }

    public void setSummaryOrderText(Item cartDetails) {
    }

    @FXML
    public void updateItemDetails (String itemDetails) {

        System.out.println(itemDetails);
        summaryOrderText.setText(itemDetails);

    }

    @FXML
    void setUpCheckoutHandler(ActionEvent event) throws IOException {
        // Update the CSV file with the new stock levels
        for (Item item : cart.items) {
            try {
                updateStockCSV(item.getItemName(), item.getItemSize(), item.getItemStock());
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
        // Clear the shopping cart
//        cart.clearItems();

        // Check if the text fields are populated
        String fullName = cartNameTextField.getText();
        String cardDetails = cartCardDetailsTextField.getText();
        String address = cartAddressTextField.getText();

        if (!fullName.isEmpty() && !cardDetails.isEmpty() && !address.isEmpty()) {
            // Create Order
            admin.recordOrder(fullName, orderDetails);
            // Log price of order
            admin.addToTotalSales(totalPrice);
            // Perform the checkout action
            root = FXMLLoader.load(CartController.class.getResource("checkoutFX.fxml"));
            stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            // You can add your checkout logic here
        } else {
            confirmationOfOrderText.setText("Please fill in all fields before checkout.");
        }

    }

    @FXML
    void backToHomeScreen(ActionEvent event) throws IOException {

        FXMLLoader loader=new FXMLLoader();
        loader.setLocation(MinimalismController.class.getResource("minimalismFX.fxml"));

        Parent rootParent =loader.load();
        Scene rootScene = new Scene(rootParent);
        MinimalismController controller=loader.getController();
//        controller.setCart(cart);
//        controller.initialize(null, null);

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(rootScene);
        stage.show();

    }

    @FXML
    void userAddressCartTextField(ActionEvent event) {

    }

    @FXML
    void userCardDetailsCartTextField(ActionEvent event) {

    }

    @FXML
    void userNameCartTextField(ActionEvent event) {

    }

    @FXML
    void totalPriceTextAction(MouseEvent event) {

    }
    @FXML
    void initialize(URL url, ResourceBundle resourceBundle) {
        totalPrice = cart.calculateTotalValueOfShoppingCart();
        cartTotalPriceText.setText("£" + totalPrice);

        // Get the selected items
        ArrayList<String> selectedItems = cart.getSelectedItems();

        // Create a StringBuilder to build the formatted order details
        StringBuilder orderDetailsBuilder = new StringBuilder();

        // Iterate over the selected items and append them to the StringBuilder with newline characters
        for (String item : selectedItems) {
            orderDetailsBuilder.append(item).append("\n");
        }

        // Remove the trailing newline character, if present
        if (orderDetailsBuilder.length() > 0) {
            orderDetailsBuilder.setLength(orderDetailsBuilder.length() - 1);
        }

        orderDetails = orderDetailsBuilder.toString();

        summaryOrderText.setText(String.valueOf(orderDetails));

    }

    public void updateStockCSV(String itemName, String itemSize, int itemStock) throws IOException {
        String itemTextPath = "src/main/resources/com/example/minimalismfx/itemFile.csv";
        File itemFile = new File(itemTextPath);

        // Create a temporary list to store the updated CSV data
        ArrayList<String> updatedCSVStock = new ArrayList<>();

        // Read the existing CSV data
        try (Scanner scanner = new Scanner(itemFile)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] fields = line.split(",");

                // Checking that name matches the specified item object and size
                if (fields.length >= 4 && fields[0].equals(itemName) && fields[1].equals(itemSize)) {
                    fields[3] = Integer.toString(itemStock);
                }

                // Add the updated or unchanged line to the temporary list
                updatedCSVStock.add(String.join(",", fields));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return; // Exit early if the file doesn't exist
        }

        // Create a FileWriter to write the updated CSV data to a temporary file
        File tempFile = new File("src/main/resources/com/example/minimalismfx/updateCSVStock.csv");
        try (FileWriter fileWriter = new FileWriter(tempFile)) {
            for (String line : updatedCSVStock) {
                fileWriter.write(line + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
            return; // Exit early if there's an issue writing the file
        }

        // Replace the original file with the temporary file
//        if (originalFile.delete()) {
//            if (!tempFile.renameTo(originalFile)) {
//                throw new IOException("Failed to rename the temporary file to the original file");
//            }
//        } else {
//            throw new IOException("Failed to delete the original file");
//        }
    }


}
