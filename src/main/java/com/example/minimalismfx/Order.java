package com.example.minimalismfx;

import java.time.LocalDateTime;

public class Order {
        String userName;
        Item item;
        int quantity;
        LocalDateTime orderDateTime;

        public Order(String userName, Item item, int quantity, LocalDateTime orderDateTime) {
                this.userName = userName;
                this.item = item;
                this.quantity = quantity;
                this.orderDateTime = orderDateTime;
        }

        public String toString(){
                return userName + ": " + item.toString() + quantity + orderDateTime;
        }





}
