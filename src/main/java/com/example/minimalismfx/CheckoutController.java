package com.example.minimalismfx;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;

public class CheckoutController {
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Text DisplayTextDeliveryTime;

    @FXML
    private Text DisplayTextOrderShipped;

    @FXML
    private Text DisplayTextThankYou;

    @FXML
    private ImageView movingVanImage;

    @FXML
    void initialize() {
        assert DisplayTextDeliveryTime != null : "fx:id=\"DisplayTextDeliveryTime\" was not injected: check your FXML file 'checkoutFX.fxml'.";
        assert DisplayTextOrderShipped != null : "fx:id=\"DisplayTextOrderShipped\" was not injected: check your FXML file 'checkoutFX.fxml'.";
        assert DisplayTextThankYou != null : "fx:id=\"DisplayTextThankYou\" was not injected: check your FXML file 'checkoutFX.fxml'.";
        assert movingVanImage != null : "fx:id=\"movingVanImage\" was not injected: check your FXML file 'checkoutFX.fxml'.";

    }

}
