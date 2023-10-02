package com.example.minimalismfx;

import java.io.File;
import java.io.FileNotFoundException;
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

    public void readingCSVFile() {
        try (Scanner txtScanner = new Scanner(new File(""))) {
            while(txtScanner.hasNextLine()) {
                String line = txtScanner.nextLine();
                String[] itemRow = line.split(",");
                System.out.println(itemRow);
            }
        } catch (FileNotFoundException e) {
            System.err.println("Hey, we couldn't find the file: " + e);
        }
    }



}
