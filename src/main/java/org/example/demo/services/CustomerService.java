package org.example.demo.services;

import javafx.collections.ObservableList;
import org.example.demo.models.Customers;

import java.sql.ResultSet;

public class CustomerService {
    private final static int PAGE_SIZE = 10;

    public static void insert(Customers cust) {
        dbService.insertData(cust);
    }

    public static void delete(Customers cust) {
        dbService.deleteData(cust);
    }

    public static void update(Customers cust) {
        dbService.updateData(cust);
    }

    public static ObservableList<Customers> getCustomers(int page) {
        // Implement pagination in your data fetching logic
        // For example, if using SQL: SELECT * FROM customers LIMIT ? OFFSET ?
        String query = "SELECT * FROM customers LIMIT " + PAGE_SIZE + " OFFSET " + (page * PAGE_SIZE);
        // Fetch and return the paged data from your database
    }

    private static Customers formatCustomer(ResultSet rs) {
        Customers cust = new Customers();
        try {
            cust.setCustomerId(rs.getInt(1));
            cust.setCustFirstName(rs.getString(2));
            cust.setCustLastName(rs.getString(3));
            cust.setCustAddress(rs.getString(4));
            cust.setCustCity(rs.getString(5));
            cust.setCustProv(rs.getString(6));
            cust.setCustPostal(rs.getString(7));
            cust.setCustCountry(rs.getString(8));
            cust.setCustHomePhone(rs.getString(9));
            cust.setCustBusPhone(rs.getString(10));
            cust.setCustEmail(rs.getString(11));
            cust.setAgentId(rs.getInt(12));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        return cust;
    }
}