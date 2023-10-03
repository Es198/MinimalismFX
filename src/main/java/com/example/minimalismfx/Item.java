package com.example.minimalismfx;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Item {

    private String itemName;
    private String itemSize;
    private double itemPrice;
    private int itemStock;
    String pathName = "";
    File itemText = new File(pathName);

    public Item(String itemName, String itemSize, double itemPrice, int itemStock) {
        this.itemName = itemName;
        this.itemSize = itemSize;
        this.itemPrice = itemPrice;
        this.itemStock = itemStock;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getItemSize() {
        return itemSize;
    }

    public void setItemSize(String itemSize) {
        this.itemSize = itemSize;
    }

    public double getItemPrice() {
        return itemPrice;
    }

    public void setItemPrice(double itemPrice) {
        this.itemPrice = itemPrice;
    }

    public int getItemStock() {
        return itemStock;
    }

    public void setItemStock(int itemStock) {
        this.itemStock = itemStock;
    }

    public String toString() {
        return itemName + ", " + itemSize + ", " + itemPrice + ", " + itemStock;
    }

    public static ArrayList<Item> readingCSVFile(String filePath) throws FileNotFoundException {
        ArrayList<Item> items = new ArrayList<>();

        try (Scanner txtScanner = new Scanner(new File(filePath))) {
            while (txtScanner.hasNextLine()) {
                String line = txtScanner.nextLine();
                String[] itemRow = line.split(",");
                if (itemRow.length == 4) {
                    String itemName = itemRow[0].trim();
                    String itemSize = itemRow[1].trim();
                    double itemPrice = Double.parseDouble(itemRow[2].trim());
                    int itemStock = Integer.parseInt(itemRow[3].trim());
                    items.add(new Item(itemName, itemSize, itemPrice, itemStock));
                }
            }
        } catch (FileNotFoundException e) {
            throw new FileNotFoundException("Hey, we couldn't find the item: " + e);
        }

        return items;
    }



}
