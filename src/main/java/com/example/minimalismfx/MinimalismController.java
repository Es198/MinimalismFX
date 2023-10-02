package com.example.minimalismfx;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class MinimalismController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    public void getTShirts() {
        System.out.println("T-shirts");
    }

}
