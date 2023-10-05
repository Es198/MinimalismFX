package com.example.minimalismfx;

import java.time.LocalDateTime;

public class Order {
        private final String userName;
        private final String item;
        private final LocalDateTime orderDateTime;

        public Order(String userName, String item, LocalDateTime orderDateTime) {
                this.userName = userName;
                this.item = item;
                this.orderDateTime = orderDateTime;
        }

        public String toString(){
                return userName + " at " + orderDateTime + " ordered:\n" + item;
        }


}
