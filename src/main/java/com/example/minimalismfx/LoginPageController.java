package com.example.minimalismfx;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.control.PasswordField;
import javafx.stage.Stage;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class LoginPageController {

    @FXML
    private PasswordField passwordField;

    @FXML
    private ChoiceBox<String> userTypeBox;

    @FXML
    private TextField usernameField;



    @FXML
    private void initialize() {
        ObservableList<String> userTypes = FXCollections.observableArrayList("Staff", "Shopper");
        userTypeBox.setItems(userTypes);
    }

    private static final String CSV_FILE_PATH = "src/main/resources/com/example/minimalismfx/userFile.csv";

    @FXML
    void setPasswordField(ActionEvent event) {

    }

    @FXML
    void handleLogin(ActionEvent event) {
        String username = usernameField.getText();
        String password = passwordField.getText();
        String userType = userTypeBox.getValue();

        if (isValidLogin(username, password, userType)) {
            showAlert(Alert.AlertType.INFORMATION, "Login Successful", "Welcome, " + userType + "!");
        } else {
            showAlert(Alert.AlertType.ERROR, "Login Failed", "Invalid credentials. Please try again.");
        }

        try {
            FXMLLoader loader;
            String title;

            Parent root;

            if (userType.equals("Shopper")) {
                loader = new FXMLLoader(getClass().getResource("minimalismFX.fxml"));
                title = "Shopper Home Page";
                root = loader.load();
                MinimalismController minimalismController = loader.getController();
                minimalismController.initializeElements();

            } else if (userType.equals("Staff")) {
                loader = new FXMLLoader(getClass().getResource("adminPage.fxml"));
                title = "Staff Home Page";
                root = loader.load();
                AdminController adminController = loader.getController();
                adminController.initializeElements();

            } else {
                System.out.println("Invalid login type.");
                return;
            }

            Stage stage = new Stage();
            stage.setTitle(title);
            stage.setScene(new Scene(root));

            Stage loginStage = (Stage) usernameField.getScene().getWindow();
            loginStage.close();

            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private boolean isValidLogin(String username, String password, String userType) {
        try (BufferedReader br = new BufferedReader(new FileReader(CSV_FILE_PATH))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 5) {
                    String storedUsername = parts[0].trim();
                    String storedPassword = parts[1].trim();
                    String storedUserType = parts[2].trim();
                    if (username.equals(storedUsername) && password.equals(storedPassword) && userType.equals(storedUserType)) {
                        return true;
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    private void showAlert(Alert.AlertType type, String title, String message) {
        Alert alert = new Alert(type);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    @FXML
    void setUsernameField(ActionEvent event) {

    }

    private void handleSuccessfulLogin (String loginType) {
        try {
            FXMLLoader loader;
            String title;

            if (loginType.equals("Shopper")) {
                loader = new FXMLLoader(getClass().getResource("minimalismFX.fxml"));
                title = "Shopper Home Page";
            } else if (loginType.equals("Staff")) {
                loader = new FXMLLoader(getClass().getResource("adminPage.fxml"));
                title = "Staff Home Page";
            } else {
                System.out.println("Invalid login type.");
                return;
            }

            Parent root = loader.load();
            Stage stage = new Stage();
            stage.setTitle(title);
            stage.setScene(new Scene(root));

            Stage loginStage = (Stage) usernameField.getScene().getWindow();
            loginStage.close();

            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void setUpLoginButton (ActionEvent event) {
        String loginType = userTypeBox.getValue();
        handleSuccessfulLogin(loginType);
    }
}

