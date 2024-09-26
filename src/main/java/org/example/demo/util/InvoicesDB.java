package org.example.demo.util;

import javafx.collections.ObservableList;
import org.example.demo.models.Invoice;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class InvoicesDB {
    public static void insert(Invoice inv) {
        dbHelper.insertData(inv);
    }

    public static void delete(Invoice inv) {
        dbHelper.deleteData(inv);
    }

    public static void update(Invoice inv) {
        dbHelper.updateData(inv);
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