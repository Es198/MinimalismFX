package com.example.minimalismfx;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

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
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
                String formattedDateTime = orderDateTime.format(formatter);
                return userName + " at " + formattedDateTime + " ordered:\n" + item;
        }


}
