package org.example.demo;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;

import java.sql.Connection;

public class MainController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btn1;

    @FXML
    private Button btn2;

    @FXML
    private Button btn3;

    @FXML
    private Button btn4;

    @FXML
    private Button btnAdd;

    @FXML
    private Button btnDelete;

    @FXML
    private Button btnEdit;

    @FXML
    private TableView<?> tbvItems;

    @FXML
    private void initialize() {
        assert btn1 != null : "fx:id=\"btn1\" was not injected: check your FXML file 'main-view.fxml'.";
        assert btn2 != null : "fx:id=\"btn2\" was not injected: check your FXML file 'main-view.fxml'.";
        assert btn3 != null : "fx:id=\"btn3\" was not injected: check your FXML file 'main-view.fxml'.";
        assert btn4 != null : "fx:id=\"btn4\" was not injected: check your FXML file 'main-view.fxml'.";
        assert btnAdd != null : "fx:id=\"btnAdd\" was not injected: check your FXML file 'main-view.fxml'.";
        assert btnDelete != null : "fx:id=\"btnDelete\" was not injected: check your FXML file 'main-view.fxml'.";
        assert btnEdit != null : "fx:id=\"btnEdit\" was not injected: check your FXML file 'main-view.fxml'.";
        assert tbvItems != null : "fx:id=\"tbvItems\" was not injected: check your FXML file 'main-view.fxml'.";

        Connection conn = ConnectionDB.getConnection();
        System.out.println("Connected to db");
    }
}