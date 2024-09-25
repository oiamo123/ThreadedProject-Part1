package util;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.example.demo.models.Invoice;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Date;

public class InvoicesDB {
    public static void insert(Invoice inv) {
        try {
            PreparedStatement stmt = dbHelper.getConnection().prepareStatement("insert into invoices set (invoiceDate, invoiceFees, invoiceTotal, invoiceTotalTax, invoiceCommisionTotal, bookingDetailId, customerId, packageId) values (?,?,?,?,?,?,?,?)");
            dbHelper.prepareStatement(stmt, inv.getInvoiceDate(), inv.getFees(), inv.getTotal(), inv.getTotalTax(), inv.getCommissionTotal(), inv.getBookingDetailId(), inv.getCustomerId(), inv.getCustomerId(), inv.getPackageId());
            stmt.executeUpdate();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static void delete(Invoice inv) {
        try {
            PreparedStatement stmt = dbHelper.getConnection().prepareStatement("delete from invoices where invoiceId=?");
            stmt.setInt(1, inv.getInvoiceId());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static void update(Invoice inv) {
        try {
            PreparedStatement stmt = dbHelper.getConnection().prepareStatement("update invoices set where =?");
            dbHelper.prepareStatement(stmt, inv.getInvoiceDate(), inv.getFees(), inv.getTotal(), inv.getTotalTax(), inv.getCommissionTotal(), inv.getBookingDetailId(), inv.getCustomerId(), inv.getCustomerId(), inv.getPackageId());
            stmt.executeUpdate();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private ObservableList<Invoice> getInvoices() {
        ObservableList<Invoice> invoices = FXCollections.observableArrayList();
        try {
            Statement stmt = dbHelper.getConnection().createStatement();
            stmt.executeQuery("select * from invoices");
            ResultSet rs = stmt.getResultSet();

            while (rs.next()) {
                Invoice inv = createInvoice(rs);
                if (inv != null) {
                    invoices.add(inv);
                }
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        return invoices;
    }

    private Invoice createInvoice (ResultSet rs) {
        try {
            Integer invoiceId = rs.getInt("invoiceId");
            Date invoiceDate = rs.getDate("invoiceDate");
            Double fees = rs.getDouble("fees");
            Double total = rs.getDouble("total");
            Double tax = rs.getDouble("totalTax");
            Double commission = rs.getDouble("commissionTotal");
            Integer bookingDetailsId = rs.getInt("bookingDetailsId");
            Integer customerId = rs.getInt("customerId");
            Integer packageId = rs.getInt("packageId");

            return new Invoice(invoiceId, invoiceDate, fees, total, tax, commission, bookingDetailsId, customerId, packageId);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        return null;
    }
}
