package util;

import javafx.collections.ObservableList;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class InvoicesDB {
    public static void insert(Invoice inv) {
        try {
            PreparedStatement stmt = dbHelper.getConnection().prepareStatement("insert into invoices set () values ()");
            dbHelper.prepareStatement(stmt, );
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static void delete(Invoice inv) {
        try {
            PreparedStatement stmt = dbHelper.getConnection().prepareStatement("delete from invoices where invoiceId=?");
            stmt.setInt(1, inv.getId());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static void update(Invoice inv) {
        try {
            PreparedStatement stmt = dbHelper.getConnection().prepareStatement("update invoices set where =?");
            dbHelper.prepareStatement(stmt, );
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private ObservableList<Invoice> getInvoices(Invoice inv) {
        try {
            Statement stmt = dbHelper.getConnection().createStatement();
            stmt.executeQuery("select * from invoices");
            ResultSet rs = stmt.getResultSet();

            while (rs.next()) {
                createInvoice(rs);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private Invoice createInvoice (ResultSet rs) {
        try {

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
