package com.example.minimalismfx;

import java.time.LocalDateTime;

public class Order {
        private String userName;

        public String getUserName() {
                return userName;
        }

        public void setUserName(String userName) {
                this.userName = userName;
        }

        public Item getItem() {
                return item;
        }

        public void setItem(Item item) {
                this.item = item;
        }

        public int getQuantity() {
                return quantity;
        }

        public void setQuantity(int quantity) {
                this.quantity = quantity;
        }

        public LocalDateTime getOrderDateTime() {
                return orderDateTime;
        }

        public void setOrderDateTime(LocalDateTime orderDateTime) {
                this.orderDateTime = orderDateTime;
        }

        private Item item;
        private int quantity;
        private LocalDateTime orderDateTime;

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
