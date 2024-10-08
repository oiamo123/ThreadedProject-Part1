package org.example.demo.services;

import javafx.beans.property.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.example.demo.TravelExpertsApplication;
import org.example.demo.models.Customers;
import org.example.demo.models.Id;

import java.io.InputStream;
import java.lang.reflect.Field;
import java.sql.*;
import java.util.Date;
import java.util.Properties;
import java.util.function.Function;

public class dbService {

    // Establish a connection using configuration from the properties file
    public static Connection getConnection() {
        Connection conn = null;
        String username;
        String password;
        String uri;

        try {
            InputStream file = TravelExpertsApplication.class.getResourceAsStream("/config.properties");
            Properties prop = new Properties();
            prop.load(file);

            username = prop.getProperty("username");
            password = prop.getProperty("password");
            uri = prop.getProperty("uri");
        } catch (Exception err) {
            throw new RuntimeException("Unable to read config file");
        }

        try {
            conn = DriverManager.getConnection(uri, username, password);
        } catch (Exception err) {
            throw new RuntimeException("Error establishing database connection: " + err.getMessage());
        }
        return conn;
    }

    // Utility to prepare a PreparedStatement with provided parameters
    public static void prepareStatement(PreparedStatement stmt, Object... params) {
        try {
            for (int i = 0; i < params.length; i++) {
                if (params[i] instanceof String) {
                    stmt.setString(i + 1, (String) params[i]);
                } else if (params[i] instanceof Integer) {
                    stmt.setInt(i + 1, (int) params[i]);
                } else if (params[i] instanceof Double) {
                    stmt.setDouble(i + 1, (Double) params[i]);
                } else if (params[i] instanceof Date) {
                    stmt.setDate(i + 1, (java.sql.Date) params[i]);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error preparing statement: " + e.getMessage());
        }
    }

    // Improved getData method using PreparedStatement and proper resource management
    public static <T> ObservableList<T> getData(String query, Function<ResultSet, T> formatter, Object... params) {
        ObservableList<T> data = FXCollections.observableArrayList();
        try (Connection conn = dbService.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            // Prepare the statement with parameters if provided
            if (params.length > 0) {
                prepareStatement(stmt, params);
            }

            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    data.add(formatter.apply(rs));
                }
            }
        } catch (Exception e) {
            throw new RuntimeException("Error fetching data: " + e.getMessage());
        }
        return data;
    }

    // Insert data with reflection
    public static void insertData(Object obj) {
        Field[] fields = obj.getClass().getDeclaredFields();
        StringBuilder query = new StringBuilder("INSERT INTO " + obj.getClass().getSimpleName().toLowerCase() + " (");
        StringBuilder placeholders = new StringBuilder(") VALUES (");
        int fieldIndex = 1;

        try {
            for (int i = 0; i < fields.length; i++) {
                fields[i].setAccessible(true);

                // Skip ID field if null
                if (!fields[i].isAnnotationPresent(Id.class) || fields[i].get(obj) == null) {
                    query.append(fields[i].getName());
                    placeholders.append("?");

                    if (i < fields.length - 1) {
                        query.append(", ");
                        placeholders.append(", ");
                    }

                    fieldIndex++;
                }
            }

            // Complete the query
            query.append(placeholders).append(")");

            try (Connection conn = dbService.getConnection();
                 PreparedStatement stmt = conn.prepareStatement(query.toString())) {

                fieldIndex = 1;
                for (Field field : fields) {
                    field.setAccessible(true);
                    if (!field.isAnnotationPresent(Id.class) || field.get(obj) == null) {
                        stmt.setObject(fieldIndex++, unwrapProperty(field.get(obj)));
                    }
                }

                stmt.executeUpdate();
            }
        } catch (Exception e) {
            throw new RuntimeException("Error inserting data: " + e.getMessage());
        }
    }

    public static void deleteData(Object obj) {
        Field[] fields = obj.getClass().getDeclaredFields();
        StringBuilder query = new StringBuilder("DELETE FROM " + obj.getClass().getSimpleName().toLowerCase() + " WHERE ");

        try {
            fields[0].setAccessible(true);
            query.append(fields[0].getName()).append("=?");

            try (Connection conn = dbService.getConnection();
                 PreparedStatement stmt = conn.prepareStatement(query.toString())) {

                stmt.setObject(1, unwrapProperty(fields[0].get(obj)));
                stmt.executeUpdate();
            }
        } catch (Exception e) {
            throw new RuntimeException("Error deleting data: " + e.getMessage());
        }
    }

    public static int deleteCustomer(int customerId) throws SQLException{
        int numRows = 0;
        Connection conn = getConnection();
        String sql = "DELETE FROM customers WHERE CustomerId = ?";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setInt(1, customerId);
        numRows = stmt.executeUpdate();
        conn.close();
        return numRows;
    }

    public static int updateCustomer(int customerId, Customers customer) throws SQLException {
        int numRows = 0; // number of rows affected
        Connection conn = getConnection();
        String sql = "UPDATE customers SET " +
                "       CustomerId = ?, " +
                "       CustFirstName = ?, " +
                "       CustLastName = ?, " +
                "       CustAddress = ?, " +
                "       CustCity = ?, " +
                "       CustProvince = ?, " +
                "       CustPostal = ?, " +
                "       CustCountry = ?" +
                "       CustHomePhone = ?" +
                "       CustBusPhone= ?" +
                "       CustEmail= ?" +
                "       AgentId= ?" +
                "     WHERE CustomerId = ?";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setInt(1, customer.getCustomerId());
        stmt.setString(2, customer.getCustFirstName());
        stmt.setString(3, customer.getCustLastName());
        stmt.setString(4, customer.getCustAddress());
        stmt.setString(5, customer.getCustCity());
        stmt.setString(6, customer.getCustProv());
        stmt.setString(7, customer.getCustPostal());
        stmt.setString(8, customer.getCustCountry());
        stmt.setString(9, customer.getCustHomePhone());
        stmt.setString(10, customer.getCustBusPhone());
        stmt.setString(11, customer.getCustEmail());
        stmt.setInt(12, customer.getAgentId());
        numRows = stmt.executeUpdate();
        conn.close();
        return numRows;
    }

    // Update data with reflection
    public static void updateData(Object obj) {
        Field[] fields = obj.getClass().getDeclaredFields();
        StringBuilder query = new StringBuilder("UPDATE " + obj.getClass().getSimpleName().toLowerCase() + " SET ");
        int fieldIndex = 1;

        try {
            for (int i = 0; i < fields.length; i++) {
                fields[i].setAccessible(true);

                if (!fields[i].isAnnotationPresent(Id.class)) {
                    query.append(fields[i].getName()).append(" = ?");
                    if (i < fields.length - 1) {
                        query.append(", ");
                    }
                }
            }

            // Append the WHERE clause
            query.append(" WHERE ").append(fields[0].getName()).append(" = ?");

            try (Connection conn = dbService.getConnection();
                 PreparedStatement stmt = conn.prepareStatement(query.toString())) {

                // Set values for fields
                for (Field field : fields) {
                    field.setAccessible(true);
                    if (!field.isAnnotationPresent(Id.class)) {
                        stmt.setObject(fieldIndex++, unwrapProperty(field.get(obj)));
                    }
                }
                stmt.setObject(fieldIndex, unwrapProperty(fields[0]));

                stmt.executeUpdate();
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error updating data: " + e.getMessage());
        } catch (IllegalAccessException e) {
            throw new RuntimeException("Error accessing field: " + e.getMessage());
        }
    }

    public static ObservableList<Customers> getCustomers() throws SQLException {
        ObservableList<Customers> customers = FXCollections.observableArrayList();
        Customers customer; // for processing data
        Connection conn = getConnection();
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("select * from customers");
        while(rs.next()){
            customer = new Customers(
                    rs.getInt(1),
                    rs.getString(2),
                    rs.getString(3),
                    rs.getString(4),
                    rs.getString(5),
                    rs.getString(6),
                    rs.getString(7),
                    rs.getString(8),
                    rs.getString(9),
                    rs.getString(10),
                    rs.getString(11),
                    rs.getInt(12)
            );
            customers.add(customer);
        }
        conn.close();
        return customers;
    } // end getAgents

    // Utility to unwrap JavaFX property types
    private static Object unwrapProperty(Object fieldValue) {
        if (fieldValue == null) return null;  // Handle null values
        if (fieldValue instanceof SimpleObjectProperty) return ((SimpleObjectProperty<?>) fieldValue).get();
        if (fieldValue instanceof SimpleStringProperty) return ((SimpleStringProperty) fieldValue).get();
        if (fieldValue instanceof SimpleIntegerProperty) return ((SimpleIntegerProperty) fieldValue).get();
        if (fieldValue instanceof SimpleDoubleProperty) return ((SimpleDoubleProperty) fieldValue).get();
        if (fieldValue instanceof SimpleFloatProperty) return ((SimpleFloatProperty) fieldValue).get();
        if (fieldValue instanceof SimpleBooleanProperty) return ((SimpleBooleanProperty) fieldValue).get();
        if (fieldValue instanceof SimpleLongProperty) return ((SimpleLongProperty) fieldValue).get();
        return fieldValue;  // Return as-is if it's not a JavaFX property type
    }
}
