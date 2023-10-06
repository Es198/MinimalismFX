package com.example.minimalismfx;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class Admin {

    ArrayList<Order> allOrders = new ArrayList<>();
    double sum = 0;

    private static Admin instance;

    public static Admin getInstance() {
        if (instance == null) {
            instance = new Admin();
        }
        return instance;
    }


    // To be called when items are purchased
    void recordOrder(String userName, String item) {
        Order order = new Order(userName, item, LocalDateTime.now());
        allOrders.add(order);
    }


    String displayAllOrders(){
        StringBuilder result = new StringBuilder();

        for (Order order: allOrders) {
            result.append(order.toString()).append("\n");
        }

        return result.toString();
    }

    void addToTotalSales(double totalPrice){
        sum += totalPrice;
    }




}
