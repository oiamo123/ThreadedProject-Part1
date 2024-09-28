package org.example.demo.services;

import javafx.collections.ObservableList;
import org.example.demo.models.Customers;
import org.example.demo.util.dbHelper;

import java.sql.ResultSet;

public class CustomerService {
    public static void insert(Customers cust) {
        dbHelper.insertData(cust);
    }

    public static void delete(Customers cust) {
        dbHelper.deleteData(cust);
    }

    public static void update(Customers cust) {
        dbHelper.updateData(cust);
    }

    public static ObservableList<Customers> getCustomers() {
        return dbHelper.getData("select * from customers", CustomerService::formatCustomer);
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