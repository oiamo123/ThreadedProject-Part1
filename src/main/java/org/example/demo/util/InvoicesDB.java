package org.example.demo.util;

import javafx.collections.ObservableList;
import org.example.demo.models.Invoice;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

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

    public static ObservableList<Invoice> getInvoices() {
        return dbHelper.getData("select * from invoices", InvoicesDB::formatInvoice);
    }

    private static Invoice formatInvoice (ResultSet rs) {
        Invoice invoice = new Invoice();
        try {
            invoice.setInvoiceId(rs.getInt(1));
            invoice.setInvoiceDate(rs.getDate(2));
            invoice.setFees(rs.getDouble(3));
            invoice.setTotal(rs.getDouble(4));
            invoice.setTotalTax(rs.getDouble(5));
            invoice.setCommissionTotal(rs.getDouble(6));
            invoice.setBookingDetailId(rs.getInt(7));
            invoice.setCustomerId(rs.getInt(8));
            invoice.setPackageId(rs.getInt(9));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        return invoice;
    }
}