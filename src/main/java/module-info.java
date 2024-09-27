module org.example.demo {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires java.desktop;
    requires mysql.connector.j;


    opens org.example.demo to javafx.fxml;
    exports org.example.demo;
    exports org.example.demo.controllers;
    opens org.example.demo.controllers to javafx.fxml;
    opens org.example.demo.models ;
}