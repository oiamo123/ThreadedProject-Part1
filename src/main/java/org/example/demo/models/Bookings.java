package org.example.demo.models;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Bookings {
    private SimpleIntegerProperty bookingId;
    private SimpleDateFormat bookingDate;
    private SimpleStringProperty bookingNo;
    private SimpleDoubleProperty travelerCount;
    private SimpleIntegerProperty customerId;
    private SimpleIntegerProperty packageId;

    public Bookings() {
        this.bookingId = new SimpleIntegerProperty();
        this.bookingDate = new SimpleDateFormat();
        this.bookingNo = new SimpleStringProperty();
        this.travelerCount = new SimpleDoubleProperty();
        this.customerId = new SimpleIntegerProperty();
        this.packageId = new SimpleIntegerProperty();
    }

    public int getBookingId() {
        return bookingId.get();
    }

    public void setBookingId(int bookingId) {
        this.bookingId.set(bookingId);
    }

    public String getBookingDate() {
        return bookingDate.format(new Date());
    }

    public void setBookingDate(Date bookingDate) {
        this.bookingDate = new SimpleDateFormat("yyyy-MM-dd");
    }

    public String getBookingNo() {
        return bookingNo.get();
    }

    public void setBookingNo(String bookingNo) {
        this.bookingNo.set(bookingNo);
    }

    public double getTravelerCount() {
        return travelerCount.get();
    }

    public void setTravelerCount(double travelerCount) {
        this.travelerCount.set(travelerCount);
    }

    public int getCustomerId() {
        return customerId.get();
    }

    public int getPackageId() {
        return packageId.get();
    }
}
