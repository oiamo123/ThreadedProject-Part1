package org.example.demo.util;

import org.example.demo.TravelExpertsApplication;

import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

public class dbHelper {
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

    public static void prepareStatement(PreparedStatement stmt, Object... params) {
        try {
            for (int i = 0; i < params.length; i++) {
                if (params[i] instanceof String) {
                    stmt.setString(i + 1, (String) params[i]);
                }
                else if (params[i] instanceof Integer) {
                    stmt.setInt(i + 1, (int) params[i]);
                }
                else if (params[i] instanceof Double) {
                    stmt.setDouble(i + 1, (Double) params[i]);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
