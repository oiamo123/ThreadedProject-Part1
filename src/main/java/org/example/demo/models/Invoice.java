package org.example.demo.models;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;

import java.text.SimpleDateFormat;

public class Invoice {
    // Invoice properties
    private final SimpleIntegerProperty invoiceId;
    private SimpleDateFormat invoiceDate;

    // Invoice Cost properties
    private final SimpleDoubleProperty fees;
    private final SimpleDoubleProperty total;
    private final SimpleDoubleProperty totalTax;
    private final SimpleDoubleProperty commissionTotal;

    // Related properties
    private final SimpleIntegerProperty bookingDetailId;
    private final SimpleIntegerProperty customerId;
    private final SimpleIntegerProperty packageId;

    public Invoice() {
        this.invoiceId = new SimpleIntegerProperty();
        this.invoiceDate = new SimpleDateFormat();
        this.fees = new SimpleDoubleProperty();
        this.total = new SimpleDoubleProperty();
        this.totalTax = new SimpleDoubleProperty();
        this.commissionTotal = new SimpleDoubleProperty();
        this.bookingDetailId = new SimpleIntegerProperty();
        this.customerId = new SimpleIntegerProperty();
        this.packageId = new SimpleIntegerProperty();
    }
    // Getters and Setters

    public int getInvoiceId() {
        return invoiceId.get();
    }

    public void setInvoiceId(int invoiceId) {
        this.invoiceId.set(invoiceId);
    }

    public String getInvoiceDate() {
        return invoiceDate.format(new java.util.Date());
    }

    public void setInvoiceDate(java.util.Date invoiceDate) {
        this.invoiceDate = new SimpleDateFormat("yyyy-MM-dd");
    }

    public double getFees() {
        return fees.get();
    }

    public void setFees(double fees) {
        this.fees.set(fees);
    }

    public double getTotal() {
        return total.get();
    }

    public void setTotal(double total) {
        this.total.set(total);
    }

    public double getTotalTax() {
        return totalTax.get();
    }

    public void setTotalTax(double totalTax) {
        this.totalTax.set(totalTax);
    }

    public double getCommissionTotal() {
        return commissionTotal.get();
    }

    public void setCommissionTotal(double commissionTotal) {
        this.commissionTotal.set(commissionTotal);
    }

    public int getBookingDetailId() {
        return bookingDetailId.get();
    }

    public int getCustomerId() {
        return customerId.get();
    }

    public int getPackageId() {
        return packageId.get();
    }


}
