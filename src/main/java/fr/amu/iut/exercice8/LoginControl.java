package fr.amu.iut.exercice8;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class LoginControl {

    @FXML
    private TextField userIdField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private Button okButton;

    @FXML
    private Button cancelButton;

    @FXML
    private void initialize() {
        // Initialize any additional setup here
        okButton.setOnAction(event -> okClicked());
        cancelButton.setOnAction(event -> cancelClicked());
    }

    @FXML
    private void okClicked() {
        String userId = userIdField.getText();
        String password = passwordField.getText();
        int passwordLength = password.length();

        System.out.println("User ID: " + userId);
        System.out.println("Password: " + "*".repeat(passwordLength));
    }

    @FXML
    private void cancelClicked() {
        userIdField.clear();
        passwordField.clear();
    }

}

