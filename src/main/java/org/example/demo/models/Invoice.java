package org.example.demo.models;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Invoice {
    // Invoice properties
    private SimpleIntegerProperty invoiceId;
    private SimpleDateFormat invoiceDate;

    // Invoice Cost properties
    private SimpleDoubleProperty fees;
    private SimpleDoubleProperty total;
    private SimpleDoubleProperty totalTax;
    private SimpleDoubleProperty commissionTotal;

    // Related properties
    private SimpleIntegerProperty bookingDetailId;
    private SimpleIntegerProperty customerId;
    private SimpleIntegerProperty packageId;

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

    public int getBookingDetailId() {
        return bookingDetailId.get();
    }

    public SimpleIntegerProperty bookingDetailIdProperty() {
        return bookingDetailId;
    }

    public void setBookingDetailId(int bookingDetailId) {
        this.bookingDetailId.set(bookingDetailId);
    }

    public int getInvoiceId() {
        return invoiceId.get();
    }

    public SimpleIntegerProperty invoiceIdProperty() {
        return invoiceId;
    }

    public void setInvoiceId(int invoiceId) {
        this.invoiceId.set(invoiceId);
    }

    public SimpleDateFormat getInvoiceDate() {
        return invoiceDate;
    }

    public void setInvoiceDate(Date invoiceDate) {
        this.invoiceDate.format(invoiceDate);
    }

    public double getFees() {
        return fees.get();
    }

    public SimpleDoubleProperty feesProperty() {
        return fees;
    }

    public void setFees(double fees) {
        this.fees.set(fees);
    }

    public double getTotal() {
        return total.get();
    }

    public SimpleDoubleProperty totalProperty() {
        return total;
    }

    public void setTotal(double total) {
        this.total.set(total);
    }

    public double getTotalTax() {
        return totalTax.get();
    }

    public SimpleDoubleProperty totalTaxProperty() {
        return totalTax;
    }

    public void setTotalTax(double totalTax) {
        this.totalTax.set(totalTax);
    }

    public double getCommissionTotal() {
        return commissionTotal.get();
    }

    public SimpleDoubleProperty commissionTotalProperty() {
        return commissionTotal;
    }

    public void setCommissionTotal(double commissionTotal) {
        this.commissionTotal.set(commissionTotal);
    }

    public int getCustomerId() {
        return customerId.get();
    }

    public SimpleIntegerProperty customerIdProperty() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId.set(customerId);
    }

    public int getPackageId() {
        return packageId.get();
    }

    public SimpleIntegerProperty packageIdProperty() {
        return packageId;
    }

    public void setPackageId(int packageId) {
        this.packageId.set(packageId);
    }
}
