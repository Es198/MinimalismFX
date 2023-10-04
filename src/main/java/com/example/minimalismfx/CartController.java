package com.example.minimalismfx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;

import java.net.URL;
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

    @FXML
    private Text summaryOrderText;

    @FXML
    private Label orderDetailsLabel;

    @FXML
    private TextArea orderTextArea;




    ShoppingCart cart;

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
        orderDetailsLabel.setText(itemDetails);
        summaryOrderText.setText(itemDetails);
        orderTextArea.setText(itemDetails);

    }

    @FXML
    void setUpCheckoutHandler(ActionEvent event) {

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
        double totalPrice = cart.calculateTotalValueOfShoppingCart();
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

        String orderDetails = orderDetailsBuilder.toString();

        summaryOrderText.setText(String.valueOf(orderDetails));
        System.out.println(orderDetails);

    }


}
