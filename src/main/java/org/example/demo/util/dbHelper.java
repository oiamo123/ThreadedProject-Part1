package org.example.demo.util;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.example.demo.TravelExpertsApplication;

import java.io.InputStream;
import java.lang.reflect.Field;
import java.sql.*;
import java.util.Date;
import java.util.Properties;
import java.util.function.Function;

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
                else if (params[i] instanceof Date) {
                    stmt.setDate(i + 1, (java.sql.Date) params[i]);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static <T> ObservableList<T> getData(String query, Function<ResultSet, T> formatter) {
        ObservableList<T> data = FXCollections.observableArrayList();
        try {
            Statement stmt = dbHelper.getConnection().createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                data.add(formatter.apply(rs));
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return data;
    }

    public static void insertData(String table, Object obj) {
        Field[] fields = obj.getClass().getDeclaredFields();
        StringBuilder query = new StringBuilder("INSERT INTO " + table + " (");
        StringBuilder placeholders = new StringBuilder(") VALUES (");
        int fieldIndex = 1; // To track parameter index for PreparedStatement

        try {
            for (int i = 0; i < fields.length; i++) {
                fields[i].setAccessible(true); // Make private fields accessible

                // Assume the first field is the auto-generated ID and skip it
                if (fields[i].getName().equalsIgnoreCase("id") || fields[i].get(obj) == null) {
                    continue; // Skip ID or any null fields (if needed)
                }

                query.append(fields[i].getName());
                placeholders.append("?");

                if (i < fields.length - 1) {
                    query.append(", ");
                    placeholders.append(", ");
                }

                fieldIndex++; // Increment field index
            }

            // Complete the query
            query.append(placeholders).append(")");

            // Prepare statement
            PreparedStatement stmt = dbHelper.getConnection().prepareStatement(query.toString());
            fieldIndex = 1; // Reset the index for prepared statement parameters

            for (int i = 0; i < fields.length; i++) {
                fields[i].setAccessible(true); // Access the field

                // Skip the ID field or null values
                if (fields[i].getName().equalsIgnoreCase("id") || fields[i].get(obj) == null) {
                    continue;
                }

                // Set values dynamically for each field in the PreparedStatement
                stmt.setObject(fieldIndex++, fields[i].get(obj));
            }

            stmt.executeUpdate(); // Execute the insertion
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}