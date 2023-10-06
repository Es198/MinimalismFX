package com.example.minimalismfx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.MenuBar;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import com.example.minimalismfx.CartController;


public class MinimalismController {


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
    private TextArea showSummaryTshirt;

    @FXML
    private ChoiceBox<String> sizeChoiceTshirt;
    @FXML
    public ChoiceBox<String> sizeChoiceJumper;
    @FXML
    public ChoiceBox<String> sizeChoiceTrouser;
    @FXML
    private Text jumperCounter;

    @FXML
    private Text trouserCounter;

    @FXML
    private Text tshirtCounter;

    @FXML
    private Text exceededJumperQuantity;

    @FXML
    private Text exceededQuantityTShirt;

    @FXML
    private Text exceededTrouserQuantity;

    @FXML
    private Button logoutButton;


    private Stage stage;
    private Scene scene;
    private Parent root;



    ArrayList<Item> itemStockList;

//    HashMap<Item, Integer> items;

    @FXML
    void AddItemJumper(ActionEvent event) {
        updateCounter("Jumper", jumperCounter,1);
    }

    @FXML
    void DecreaseItemJumper(ActionEvent event) {
        updateCounter("Jumper", jumperCounter, -1);
    }

    @FXML
    void DecreaseItemTrousers(ActionEvent event) {
        updateCounter("Trousers", trouserCounter, -1);
    }

    @FXML
    void DecreaseItemTshirt(ActionEvent event) {
        updateCounter("T-shirt", tshirtCounter, -1);
    }

    @FXML
    void IncreaseItemTshirt(ActionEvent event) {
        updateCounter("T-shirt", tshirtCounter,1);
    }

    @FXML
    void IncreaseitemTrousers(ActionEvent event) {
        updateCounter("Trousers", trouserCounter,1);
    }

    private Admin admin = Admin.getInstance();
    private ShoppingCart cart = ShoppingCart.getInstance();

    public void initializeElements() throws FileNotFoundException {
        itemStockList = cart.readingCSVFile("src/main/resources/com/example/minimalismfx/itemFile.csv");

        sizeChoiceTshirt.getItems().add("Small");
        sizeChoiceTshirt.getItems().add("Medium");
        sizeChoiceTshirt.getItems().add("Large");

        sizeChoiceJumper.getItems().add("Small");
        sizeChoiceJumper.getItems().add("Medium");
        sizeChoiceJumper.getItems().add("Large");

        sizeChoiceTrouser.getItems().add("Small");
        sizeChoiceTrouser.getItems().add("Medium");
        sizeChoiceTrouser.getItems().add("Large");

    }



    @FXML
    void SetUpAddToCartJumper(ActionEvent event) throws FileNotFoundException {
        confirmAvailability(event);
        String jumperSize = sizeChoiceJumper.getSelectionModel().getSelectedItem();
        if (jumperSize != null) {
            Item selectedJumper = getSelectedItem("Jumper"); // Get the selected jumper item

            // Check if a valid jumper item was found
            if (selectedJumper != null) {
                exceededJumperQuantity.setText("Jumper added to cart");
                cart.addItemToCart(selectedJumper, count);

                // Create a string for the selected item and add it to the list
                String itemDetails = "Item: " + selectedJumper.getItemName() +
                        "\nSize: " + selectedJumper.getItemSize() +
                        "\nPrice: " + selectedJumper.getItemPrice() +
                        "\nQuantity: " + count + "\n";

                cart.addSelectedItem(itemDetails);
            }
        }
    }

    @FXML
    public void SetUpAddToCartTrousers(ActionEvent event) throws FileNotFoundException {
        confirmAvailability(event);
        String trouserSize = sizeChoiceTrouser.getSelectionModel().getSelectedItem();
        if (trouserSize != null) {
            Item selectedTrouser= getSelectedItem("Trousers"); // Get the selected trouser item

            // Check if a valid trouser item was found
            if (selectedTrouser != null) {
                exceededTrouserQuantity.setText("Trouser added to cart");
                cart.addItemToCart(selectedTrouser, count);

                // Create a string for the selected item and add it to the list
                String itemDetails = "Item: " + selectedTrouser.getItemName() +
                        "\nSize: " + selectedTrouser.getItemSize() +
                        "\nPrice: " + selectedTrouser.getItemPrice() +
                        "\nQuantity: " + count + "\n";

                cart.addSelectedItem(itemDetails);
            }
        }

    }

    @FXML
    void SetUpAddToCartTshirt(ActionEvent event) throws IOException {
        confirmAvailability(event);
        String tshirtSize = sizeChoiceTshirt.getSelectionModel().getSelectedItem();
        if (tshirtSize != null) {
            Item selectedTShirt= getSelectedItem("T-shirt"); // Get the selected tshirt item

            // Check if a valid tshirt item was found
            if (selectedTShirt != null) {
                exceededQuantityTShirt.setText("T-Shirt added to cart");
                cart.addItemToCart(selectedTShirt, count);

                // Create a string for the selected item and add it to the list
                String itemDetails = "Item: " + selectedTShirt.getItemName() +
                        "\nSize: " + selectedTShirt.getItemSize() +
                        "\nPrice: " + selectedTShirt.getItemPrice() +
                        "\nQuantity: " + count + "\n";

                cart.addSelectedItem(itemDetails);

            }

        }
    }

    @FXML
    void SetUpCheckout(ActionEvent event) throws IOException {
        FXMLLoader loader=new FXMLLoader();
        loader.setLocation(MinimalismController.class.getResource("cartfx.fxml"));

        Parent rootParent =loader.load();
        Scene rootScene = new Scene(rootParent);
        CartController controller=loader.getController();
        controller.setAdminAndChart(admin, cart);
        controller.initializeElements();

        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setScene(rootScene);
        stage.show();
    }

    @FXML
    void setUpLogoutButton(ActionEvent event) throws IOException {

        FXMLLoader loader=new FXMLLoader();
        loader.setLocation(MinimalismController.class.getResource("LoginPageV2.fxml"));

        Parent rootParent =loader.load();
        Scene rootScene = new Scene(rootParent);
        LoginPageController controller=loader.getController();

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(rootScene);
        stage.show();

    }
    @FXML
    void countJumperSelection(MouseEvent event) {

    }
    @FXML
    void countTShirtSelection(MouseEvent event) {
    }
    @FXML
    void countTrouserSelection(MouseEvent event) {
    }



    private Item getSelectedItem(String itemType) {

        String selectedSize;

        if (itemType.equals("Jumper")) {
            selectedSize = sizeChoiceJumper.getSelectionModel().getSelectedItem();
        } else if (itemType.equals("Trousers")) {
            selectedSize = sizeChoiceTrouser.getSelectionModel().getSelectedItem();
        } else if (itemType.equals("T-shirt")) {
            selectedSize = sizeChoiceTshirt.getSelectionModel().getSelectedItem();
        } else {
            return null; // Handle invalid item type
        }

        // Find the selected item (jumper, trousers, or t-shirt) from the available items
        for (Item item : cart.items) {
            if (item.getItemName().equalsIgnoreCase(itemType) && item.getItemSize().equals(selectedSize)) {
                return item;
            }
        }
        return null; // Handle the case where the selected item is not found
    }

    @FXML
    public void confirmAvailability(ActionEvent event) {
        if(event.getSource() == AddCartTshirt) {
            updateStockLevel("T-shirt", sizeChoiceTshirt.getValue(), tshirtCounter, itemStockList);
        } else if (event.getSource() == AddCartJumper) {
            updateStockLevel("Jumper", sizeChoiceJumper.getValue(), jumperCounter, itemStockList);
        } else if (event.getSource() == AddCartTrousers) {
            updateStockLevel("Trousers", sizeChoiceTrouser.getValue(), trouserCounter, itemStockList);
        }
    }

    private void updateStockLevel(String itemName, String itemSize, Text countText, ArrayList<Item> itemStockList ) {
        exceededTrouserQuantity.setText("");
        exceededJumperQuantity.setText("");
        exceededQuantityTShirt.setText("");
        if(itemSize == null) {
            countText.setFill(Color.RED);
        }

        for (Item item:itemStockList) {
            if(itemName.equals(item.getItemName()) && itemSize.equals(item.getItemSize())) {
                int availableStock = item.getItemStock();
                int quantity = Integer.parseInt(countText.getText());
                int newStock = availableStock - quantity;
                if(newStock<0) {
                    if(itemName.equals("Trousers")) {
                        exceededTrouserQuantity.setText("Not enough trousers in stock");
                    } else if (itemName.equals("T-shirt")) {
                        exceededQuantityTShirt.setText("Not enough t-shirts in stock");
                    } else if (itemName.equals("Jumper")) {
                        exceededJumperQuantity.setText("Not enough jumpers in stock");
                    }
                    return;
                }
                item.setItemStock(newStock);

            }
        }
    }
    int count;

    private void updateCounter(String itemType, Text countText, int sign) {
        count = Integer.parseInt(countText.getText()) + sign;
        if(count>=0) {
            countText.setText(String.valueOf(count));
        }

        //return count;
    }



}