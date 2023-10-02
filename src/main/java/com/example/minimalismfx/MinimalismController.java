package com.example.minimalismfx;


import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.MenuBar;
import javafx.scene.image.ImageView;

public class MinimalismController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button AddCartJumper;

    @FXML
    private Button AddCartTrousers;

    @FXML
    private Button AddCartTshirt;

    @FXML
    private Button CheckoutID;

    @FXML
    private ImageView ImageJumper;

    @FXML
    private ImageView ImageTrousers;

    @FXML
    private ImageView ImageTshirt;

    @FXML
    private MenuBar MenuID;

    @FXML
    private Button addQuantityJumper;

    @FXML
    private Button addQuantityTrousers;

    @FXML
    private Button addQuantityTshirt;

    @FXML
    private Button decreaseQuantityJumper;

    @FXML
    private Button decreaseQuantityTrousers;

    @FXML
    private Button decreaseQuantityTshirt;

    @FXML
    void AddItemJumper(ActionEvent event) {

    }

    @FXML
    void DecreaseItemJumper(ActionEvent event) {

    }

    @FXML
    void DecreaseItemTrousers(ActionEvent event) {

    }

    @FXML
    void DecreaseItemTshirt(ActionEvent event) {

    }

    @FXML
    void IncreaseItemTshirt(ActionEvent event) {

    }

    @FXML
    void IncreaseitemTrousers(ActionEvent event) {

    }

    @FXML
    void SetUpAddToCartJumper(ActionEvent event) {

    }

    @FXML
    void SetUpAddToCartTrousers(ActionEvent event) {

    }

    @FXML
    void SetUpAddToCartTshirt(ActionEvent event) {

    }

    @FXML
    void SetUpCheckout(ActionEvent event) {

    }

    @FXML
    void initialize() {
        assert AddCartJumper != null : "fx:id=\"AddCartJumper\" was not injected: check your FXML file 'minimalismFX.fxml'.";
        assert AddCartTrousers != null : "fx:id=\"AddCartTrousers\" was not injected: check your FXML file 'minimalismFX.fxml'.";
        assert AddCartTshirt != null : "fx:id=\"AddCartTshirt\" was not injected: check your FXML file 'minimalismFX.fxml'.";
        assert CheckoutID != null : "fx:id=\"CheckoutID\" was not injected: check your FXML file 'minimalismFX.fxml'.";
        assert ImageJumper != null : "fx:id=\"ImageJumper\" was not injected: check your FXML file 'minimalismFX.fxml'.";
        assert ImageTrousers != null : "fx:id=\"ImageTrousers\" was not injected: check your FXML file 'minimalismFX.fxml'.";
        assert ImageTshirt != null : "fx:id=\"ImageTshirt\" was not injected: check your FXML file 'minimalismFX.fxml'.";
        assert MenuID != null : "fx:id=\"MenuID\" was not injected: check your FXML file 'minimalismFX.fxml'.";
        assert addQuantityJumper != null : "fx:id=\"addQuantityJumper\" was not injected: check your FXML file 'minimalismFX.fxml'.";
        assert addQuantityTrousers != null : "fx:id=\"addQuantityTrousers\" was not injected: check your FXML file 'minimalismFX.fxml'.";
        assert addQuantityTshirt != null : "fx:id=\"addQuantityTshirt\" was not injected: check your FXML file 'minimalismFX.fxml'.";
        assert decreaseQuantityJumper != null : "fx:id=\"decreaseQuantityJumper\" was not injected: check your FXML file 'minimalismFX.fxml'.";
        assert decreaseQuantityTrousers != null : "fx:id=\"decreaseQuantityTrousers\" was not injected: check your FXML file 'minimalismFX.fxml'.";
        assert decreaseQuantityTshirt != null : "fx:id=\"decreaseQuantityTshirt\" was not injected: check your FXML file 'minimalismFX.fxml'.";

    }

}
