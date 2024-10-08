package org.example.demo.services;

import javafx.collections.ObservableList;
import org.example.demo.models.Invoice;

import java.sql.ResultSet;

public class InvoicesService {
    public static void insert(Invoice inv) {
        dbService.insertData(inv);
    }

    public static void delete(Invoice inv) {
        dbService.deleteData(inv);
    }

    public static void update(Invoice inv) {
        dbService.updateData(inv);
    }

    public static ObservableList<Invoice> getInvoices() {
        return dbService.getData("select * from invoices", InvoicesService::formatInvoice);
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