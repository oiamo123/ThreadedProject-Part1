package util;

import javafx.collections.ObservableList;
import org.example.demo.models.Customers;
import org.example.demo.util.dbHelper;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class CustomerDB {
    public static void insert(Customers cust) {
        try {
            PreparedStatement stmt = dbHelper.getConnection().prepareStatement("insert into customers set (CustFirstName, CustLastName, CustAddress, CustCity, CustProv, CustPostal, CustCountry, CustHomePhone, CustBusPhone, CustEmail, AgentId) values (?,?,?,?,?,?,?,?,?,?,?)");
            dbHelper.prepareStatement(stmt, cust.getCustFirstName(), cust.getCustLastName(), cust.getCustAddress(), cust.getCustCity(), cust.getCustProv(), cust.getCustPostal(), cust.getCustCountry(), cust.getCustHomePhone(), cust.getCustBusPhone(), cust.getCustEmail(), cust.getAgentId());
            stmt.executeUpdate();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static void delete(Customers cust) {
        try {
            PreparedStatement stmt = dbHelper.getConnection().prepareStatement("delete from customers where customerId=?");
            stmt.setInt(1, cust.getCustomerId());
            stmt.executeUpdate();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static void update(Customers cust) {
        try {
            PreparedStatement stmt = dbHelper.getConnection().prepareStatement("updates customers set custFirstName=?, custLastName=?, custAddress=?, custCity=?, custProv=?, custPostal=?, custCountry=?, custHomePhone=?, custBusPhone=?, CustEmail=?, AgentId=? where customerId=?");
            dbHelper.prepareStatement(stmt, cust.getCustFirstName(), cust.getCustLastName(), cust.getCustAddress(), cust.getCustCity(), cust.getCustProv(), cust.getCustPostal(), cust.getCustCountry(), cust.getCustHomePhone(), cust.getCustBusPhone(), cust.getCustomerId(), cust.getCustEmail(), cust.getAgentId());
            stmt.executeUpdate();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static ObservableList<Customers> getCustomers() {
        return dbHelper.getData("select * from customers", CustomerDB::formatCustomer);
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