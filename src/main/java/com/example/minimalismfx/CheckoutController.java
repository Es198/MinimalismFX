package com.example.minimalismfx;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class CheckoutController {
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Text DisplayTextDeliveryTime;

    @FXML
    private Text DisplayTextDeliveryTime1;

    @FXML
    private Text DisplayTextDeliveryTime2;

    @FXML
    private Text DisplayTextOrderShipped;

    @FXML
    private Text DisplayTextThankYou;

    @FXML
    private ImageView movingVanImage;

    @FXML
    private Button backToHomeButton;

    @FXML
    private Button logoutButton;


    @FXML
    void initialize() {
        assert DisplayTextDeliveryTime != null : "fx:id=\"DisplayTextDeliveryTime\" was not injected: check your FXML file 'checkoutFX.fxml'.";
        assert DisplayTextDeliveryTime1 != null : "fx:id=\"DisplayTextDeliveryTime1\" was not injected: check your FXML file 'checkoutFX.fxml'.";
        assert DisplayTextDeliveryTime2 != null : "fx:id=\"DisplayTextDeliveryTime2\" was not injected: check your FXML file 'checkoutFX.fxml'.";
        assert DisplayTextOrderShipped != null : "fx:id=\"DisplayTextOrderShipped\" was not injected: check your FXML file 'checkoutFX.fxml'.";
        assert DisplayTextThankYou != null : "fx:id=\"DisplayTextThankYou\" was not injected: check your FXML file 'checkoutFX.fxml'.";
        assert movingVanImage != null : "fx:id=\"movingVanImage\" was not injected: check your FXML file 'checkoutFX.fxml'.";

    }
    @FXML
    public void initialize(URL url,ResourceBundle rb){
        Image image=new Image(getClass().getResourceAsStream("src/main/resources/images/moving van.jpg"));
        movingVanImage.setImage(image);

    }

    @FXML
    void setUpBackToHome(ActionEvent event) throws IOException {
        FXMLLoader loader=new FXMLLoader();
        loader.setLocation(CheckoutController.class.getResource("minimalismFX.fxml"));

        Parent rootParent =loader.load();
        Scene rootScene = new Scene(rootParent);
        //LoginPageController controller=loader.getController();

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(rootScene);
        stage.show();

    }

    @FXML
    void setUpLogout(ActionEvent event) throws IOException {
        FXMLLoader loader=new FXMLLoader();
        loader.setLocation(CheckoutController.class.getResource("LoginPageV2.fxml"));

        Parent rootParent =loader.load();
        Scene rootScene = new Scene(rootParent);
        //LoginPageController controller=loader.getController();

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(rootScene);
        stage.show();

    }
}
