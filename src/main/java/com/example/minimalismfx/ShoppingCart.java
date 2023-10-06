package com.example.minimalismfx;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ShoppingCart {


    ArrayList<Item> items = new ArrayList<>();
    HashMap<Item, Integer> cartItems = new HashMap<>();
    ArrayList<String> selectedItems = new ArrayList<>();

    private static ShoppingCart instance;

    public static ShoppingCart getInstance(){
        if (instance == null) {
            instance = new ShoppingCart();
        }
        return instance;
    }


    public ArrayList<Item> readingCSVFile(String filePath) throws FileNotFoundException {

        try (Scanner txtScanner = new Scanner(new File(filePath))) {
            while (txtScanner.hasNextLine()) {
                String line = txtScanner.nextLine();
                String[] itemRow = line.split(",");
                if (itemRow.length == 4) {
                    String itemName = itemRow[0].trim();
                    String itemSize = itemRow[1].trim();
                    String itemPriceStr = itemRow[2].trim().replaceAll("[^0-9.]", ""); // Remove non-numeric characters
                    double itemPrice = Double.parseDouble(itemPriceStr);
                    int itemStock = java.lang.Integer.parseInt(itemRow[3].trim());
                    items.add(new Item(itemName, itemSize, itemPrice, itemStock));
                }
            }
            return items;
        } catch (FileNotFoundException e) {
            throw new FileNotFoundException("Hey, we couldn't find the item: " + e);
        }
    }

    //Checks if the item is available in the stock
    public boolean isItemAvailable(Item userItem, int quantity) {
        int availableStock = 0;
        for(Item item: items){
            if(userItem.getItemName().equals(item.getItemName()) && userItem.getItemSize().equals(item.getItemSize())) {
                availableStock = item.getItemStock();
            }
        }
        if(quantity <= availableStock && availableStock != 0) {
            return true;
        }
        return false;

    }

    public void addItemToCart(Item item, int quantity){
        cartItems.put(item,quantity);
    }

    //Shows total value of cart when user clicks on total price button
    public double calculateTotalValueOfShoppingCart() {
        double totalPrice = 0;
        for(Map.Entry<Item, Integer> entry : cartItems.entrySet()) {
            totalPrice += entry.getKey().getItemPrice() * entry.getValue();
        }
        // Round the total price to 2 decimal places
        totalPrice = Math.round(totalPrice * 100.0) / 100.0;
        return totalPrice;
    }

    public void addSelectedItem(String itemDetails) {
        selectedItems.add(String.valueOf(itemDetails));
    }

    public ArrayList<String> getSelectedItems() {
        return selectedItems;
    }



}
