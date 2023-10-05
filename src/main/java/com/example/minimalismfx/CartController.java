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

import java.io.IOException;
import java.net.URL;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.ResourceBundle;

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
    private Button backToHomeButton;

    @FXML
    private Button logoutButton;

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

//        String newItemName = itemClass.getItemName();
//        String newItemSize = itemClass.getItemSize() ;
//        int newItemStock = itemClass.getItemStock();
    }

    @FXML
    void setUpBackToHome(ActionEvent event) throws IOException {

        FXMLLoader loader=new FXMLLoader();
        loader.setLocation(CartController.class.getResource("minimalismFX.fxml"));
        Parent rootParent =loader.load();
        Scene rootScene = new Scene(rootParent);
        MinimalismController controller=loader.getController();
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(rootScene);
        stage.show();
    }

    @FXML

    void setUpLogoutButton(ActionEvent event)throws IOException {
        FXMLLoader loader=new FXMLLoader();
        loader.setLocation(CartController.class.getResource("LoginPageV2.fxml"));

        Parent rootParent =loader.load();
        Scene rootScene = new Scene(rootParent);
        //LoginPageController controller=loader.getController();

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


}
