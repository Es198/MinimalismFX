package com.example.minimalismfx;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Item {

    private String itemName;
    private String itemSize;
    private double itemPrice;
    private int itemStock;
    String pathName = "src/main/resources/com/example/minimalismfx/itemFile.csv";
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





}
