package org.example.demo.models;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Bookings {
    private SimpleIntegerProperty BookingId;
    private SimpleDateFormat BookingDate;
    private final SimpleStringProperty BookingNo;
    private final SimpleDoubleProperty TravelerCount;
    private SimpleIntegerProperty CustomerId;
    private SimpleStringProperty TripTypeId;
    private SimpleIntegerProperty PackageId;

    // Constructors
    public Bookings() {
        this.BookingId = new SimpleIntegerProperty();
        this.BookingDate = new SimpleDateFormat();
        this.BookingNo = new SimpleStringProperty();
        this.TravelerCount = new SimpleDoubleProperty();
        this.CustomerId = new SimpleIntegerProperty();
        this.TripTypeId = new SimpleStringProperty();
        this.PackageId = new SimpleIntegerProperty();
    }

    public Bookings(
            SimpleStringProperty bookingNo,
            SimpleDoubleProperty travelerCount,
            SimpleDateFormat bookingDate)
    {
        this.BookingNo = bookingNo;
        this.TravelerCount = travelerCount;
        this.BookingDate = bookingDate;
    }

    public int getBookingId() {
        return BookingId.get();
    }

    public SimpleIntegerProperty bookingIdProperty() {
        return BookingId;
    }

    public void setBookingId(int bookingId) {
        this.BookingId.set(bookingId);
    }

    public SimpleDateFormat getBookingDate() {
        return BookingDate;
    }

    public void setBookingDate(SimpleDateFormat bookingDate) {
        BookingDate = bookingDate;
    }

    public String getBookingNo() {
        return BookingNo.get();
    }

    public SimpleStringProperty bookingNoProperty() {
        return BookingNo;
    }

    public double getTravelerCount() {
        return TravelerCount.get();
    }

    public SimpleDoubleProperty travelerCountProperty() {
        return TravelerCount;
    }

    public int getCustomerId() {
        return CustomerId.get();
    }

    public SimpleIntegerProperty customerIdProperty() {
        return CustomerId;
    }

    public void setCustomerId(int customerId) {
        this.CustomerId.set(customerId);
    }

    public String getTripTypeId() {
        return TripTypeId.get();
    }

    public SimpleStringProperty tripTypeIdProperty() {
        return TripTypeId;
    }

    public void setTripTypeId(String tripTypeId) {
        this.TripTypeId.set(tripTypeId);
    }

    public int getPackageId() {
        return PackageId.get();
    }

    public SimpleIntegerProperty packageIdProperty() {
        return PackageId;
    }

    public void setPackageId(int packageId) {
        this.PackageId.set(packageId);
    }
}
