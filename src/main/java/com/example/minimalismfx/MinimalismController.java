package com.example.minimalismfx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.MenuBar;
import javafx.scene.control.TextArea;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;

import java.io.FileNotFoundException;
import java.net.URL;
import java.util.ResourceBundle;

public class MinimalismController implements Initializable {


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

    ShoppingCart cart = new ShoppingCart();
//    HashMap<Item, Integer> items;


    public int tshirtQuantity = 0;
    public int trouserQuantity = 0;
    public int jumperQuantity = 0;

    @FXML
    void AddItemJumper(ActionEvent event) {
        jumperQuantity++;
        if(event.getSource() == addQuantityJumper) {
            int count = Integer.parseInt(jumperCounter.getText()) + 1;
            jumperCounter.setText(String.valueOf(count));
        }

    }

    @FXML
    void DecreaseItemJumper(ActionEvent event) {
        jumperQuantity--;
    }

    @FXML
    void DecreaseItemTrousers(ActionEvent event) {
        trouserQuantity--;

    }

    @FXML
    void DecreaseItemTshirt(ActionEvent event) {
        tshirtQuantity--;

    }

    @FXML
    void IncreaseItemTshirt(ActionEvent event) {
        tshirtQuantity++;
    if (event.getSource() == addQuantityTshirt) {
        int count = Integer.parseInt(tshirtCounter.getText()) + 1;
        tshirtCounter.setText(String.valueOf(count));

    }
}


    @FXML
    void IncreaseitemTrousers(ActionEvent event) {
        trouserQuantity++;
    if (event.getSource() == addQuantityTrousers) {
        int count = Integer.parseInt(trouserCounter.getText()) + 1;
        trouserCounter.setText(String.valueOf(count));
    }

    }

    @FXML
    void SetUpAddToCartJumper(ActionEvent event) throws FileNotFoundException {

        String jumperSize = sizeChoiceJumper.getSelectionModel().getSelectedItem();
        if (jumperSize != null) {
            Item selectedJumper = getSelectedItem("Jumper"); // Get the selected jumper item

            // Check if a valid jumper item was found
            if (selectedJumper != null) {
                cart.addItemToCart(selectedJumper, jumperQuantity);

                // Append the item details to the showSummaryTshirt TextArea
                StringBuilder summaryText = new StringBuilder(showSummaryTshirt.getText());

                // Append a separator if there is existing text
                if (summaryText.length() > 0) {
                    summaryText.append("\n\n");
                }

                // Append the details of the added item
                String itemDetails = "Item: " + selectedJumper.getItemName() + "\nSize: " + selectedJumper.getItemSize() + "\nPrice: " + selectedJumper.getItemPrice() + "\nQuantity: " + jumperQuantity + "\n";
                summaryText.append(itemDetails);

                // Set the updated summaryText to the TextArea
                showSummaryTshirt.setText(summaryText.toString());
            } else {
                // Handle the case where the selected jumper item was not found
                showSummaryTshirt.setText("Selected jumper not found.");
            }
        }
    }

    @FXML
    public void SetUpAddToCartTrousers(ActionEvent event) throws FileNotFoundException {
        String trouserSize = sizeChoiceTrouser.getSelectionModel().getSelectedItem();
        if (trouserSize != null) {
            Item selectedTrouser= getSelectedItem("Trousers"); // Get the selected trouser item

            // Check if a valid trouser item was found
            if (selectedTrouser != null) {
                cart.addItemToCart(selectedTrouser, trouserQuantity);

                // Append the item details to the showSummaryTshirt TextArea
                StringBuilder summaryText = new StringBuilder(showSummaryTshirt.getText());

                // Append a separator if there is existing text
                if (summaryText.length() > 0) {
                    summaryText.append("\n\n");
                }

                // Append the details of the added item
                String itemDetails = "Item: " + selectedTrouser.getItemName() + "\nSize: " + selectedTrouser.getItemSize() + "\nPrice: " + selectedTrouser.getItemPrice() + "\nQuantity: " + trouserQuantity + "\n";
                summaryText.append(itemDetails);

                // Set the updated summaryText to the TextArea
                showSummaryTshirt.setText(summaryText.toString());
            } else {
                // Handle the case where the selected trouser item was not found
                showSummaryTshirt.setText("Selected Trouser not found.");
            }
        }

    }

    @FXML
    void SetUpAddToCartTshirt(ActionEvent event) throws FileNotFoundException {
        String trouserSize = sizeChoiceTshirt.getSelectionModel().getSelectedItem();
        if (trouserSize != null) {
            Item selectedTShirt= getSelectedItem("T-shirt"); // Get the selected tshirt item

            // Check if a valid tshirt item was found
            if (selectedTShirt != null) {
                cart.addItemToCart(selectedTShirt, tshirtQuantity);

                // Append the item details to the showSummaryTshirt TextArea
                StringBuilder summaryText = new StringBuilder(showSummaryTshirt.getText());

                // Append a separator if there is existing text
                if (summaryText.length() > 0) {
                    summaryText.append("\n\n");
                }

                // Append the details of the added item
                String itemDetails = "Item: " + selectedTShirt.getItemName() + "\nSize: " + selectedTShirt.getItemSize() + "\nPrice: " + selectedTShirt.getItemPrice() + "\nQuantity: " + tshirtQuantity + "\n";
                summaryText.append(itemDetails);

                // Set the updated summaryText to the TextArea
                showSummaryTshirt.setText(summaryText.toString());
            } else {
                // Handle the case where the selected tshirt item was not found
                showSummaryTshirt.setText("Selected TShirt not found.");
            }
        }
    }

    @FXML
    void SetUpCheckout(ActionEvent event) {
        // Calculate the total price of the items in the cart.
        double totalPrice = cart.calculateTotalValueOfShoppingCart();

        // Display the total price to the user.
        showSummaryTshirt.setText("Total price: £" + totalPrice);

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

    public void initialize(URL url, ResourceBundle resourceBundle) {
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

    private Item getSelectedItem(String itemType) throws FileNotFoundException {
        cart.readingCSVFile("src/main/resources/com/example/minimalismfx/itemFile.csv");
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

}