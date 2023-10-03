package com.example.minimalismfx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import java.io.BufferedReader;

import java.io.FileReader;
import java.io.IOException;

public class LoginPageController {

        @FXML
        private Button loginButton;

        @FXML
        private Label loginLabel;

        @FXML
        private ComboBox<String> loginTypeComboBox;

        @FXML
        private PasswordField passwordField;

        @FXML
        private TextField usernameField;

    @FXML
    void setUpLoginButton(ActionEvent event) {
        String username = usernameField.getText();
        String password = passwordField.getText();
        String loginType = loginTypeComboBox.getValue();

        if (username.isEmpty() || password.isEmpty() || loginType == null) {
            System.out.println("Please enter username, password, and select login type.");
            return;
        }

        boolean loggedIn = false;
        if (loginType.equals("Shopper")) {
            loggedIn = performShopperLogin(username, password);
        } else if (loginType.equals("Staff")) {
            loggedIn = performStaffLogin(username, password);
        }

        if (loggedIn) {
            System.out.println("Login successful for " + loginType + ": Username - " + username);
        } else {
            System.out.println("Login failed. Incorrect credentials or user not found.");
        }
    }

    private boolean performShopperLogin(String username, String password) {
                return true;
    }

    private boolean performStaffLogin(String username, String password) {
        return true;
    }


    private boolean performCSVLogin (String username, String password, String loginType){
            try (BufferedReader reader = new BufferedReader(new FileReader("userFile.csv"))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    String[] parts = line.split(",");

                    if (parts.length >= 3) {
                        String storedUsername = parts[0].trim();
                        String storedPassword = parts[1].trim();
                        String storedLoginType = parts[2].trim();

                        if (username.equals(storedUsername) && password.equals(storedPassword) && loginType.equals(storedLoginType)) {
                            return true;
                        }
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

            return false;
        }


        @FXML
        void setUpLoginTypeComboBox (ActionEvent event){

        }

        @FXML
        void setUpPasswordField (ActionEvent event){

        }

        @FXML
        void setUpUsernameField (ActionEvent event){

        }

    }