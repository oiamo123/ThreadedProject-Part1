package org.example.demo;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class ConnectionDB {
    public static Connection getConnection() {
        Connection conn = null;

        String username;
        String password;
        String uri;

        try {
            InputStream file = TravelExpertsApplication.class.getResourceAsStream("config.properties");
            Properties prop = new Properties();
            prop.load(file);

            username = prop.getProperty("username");
            password = prop.getProperty("password");
            uri = prop.getProperty("uri");

            System.out.println(username);
            System.out.println(password);
            System.out.println(uri);
        } catch (Exception err) {
            throw new RuntimeException("Unable to read file");
        }

        try {
            conn = DriverManager.getConnection(uri, username, password);
        } catch (Exception err) {
            throw new RuntimeException(err.getMessage());
        }
        return conn;
    }
}
