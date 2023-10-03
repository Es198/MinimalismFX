package com.example.minimalismfx;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class Admin {

    ArrayList<Order> allOrders = new ArrayList<>();

    // To be called when items are purchased
    void recordOrder(String userName, Item item, int quantity) {
        Order order = new Order(userName, item, quantity, LocalDateTime.now());
        allOrders.add(order);
    }


    String displayAllOrders(){
        StringBuilder result = new StringBuilder();

        for (Order order: allOrders) {
            result.append(order.toString()).append("\n");
        }

        return result.toString();
    }




}
