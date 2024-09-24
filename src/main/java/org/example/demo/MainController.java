package org.example.demo;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

import java.sql.Connection;

public class MainController {
    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }

    @FXML
    private void initialize() {
        Connection conn = ConnectionDB.getConnection();
        System.out.println("Connected to db");
    }
}