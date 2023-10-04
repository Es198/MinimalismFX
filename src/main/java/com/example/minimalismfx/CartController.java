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
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
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




    ShoppingCart cart;

    public CartController() {

    }
    public CartController(ShoppingCart cart) {
        this.cart = cart;
    }

    public void setCart(ShoppingCart cart) {
        this.cart = cart;
    }

    @FXML
    void setUpCheckoutHandler(ActionEvent event)throws IOException {

//        FXMLLoader loader=new FXMLLoader();
//        loader.setLocation(CartController.class.getResource("checkoutFX.fxml"));
//        Parent rootParent =loader.load();
//        Scene rootScene = new Scene(rootParent);
        //CartController controller=loader.getController();
        //controller.setCart(cart);
        //controller.initialize(null, null);

        root = FXMLLoader.load(CartController.class.getResource("checkoutFX.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();


//        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
//        stage.setScene(rootScene);
//        stage.show();
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
    }


}
