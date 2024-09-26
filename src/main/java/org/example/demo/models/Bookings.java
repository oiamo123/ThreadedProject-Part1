package org.example.demo.models;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.util.converter.LocalDateStringConverter;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

public class Bookings {
    @Id
    private SimpleIntegerProperty BookingId;
    private SimpleObjectProperty<Date> BookingDate;
    private SimpleStringProperty BookingNo;
    private SimpleDoubleProperty TravelerCount;
    private SimpleIntegerProperty CustomerId;
    private SimpleStringProperty TripTypeId;
    private SimpleIntegerProperty PackageId;

    // Constructors
    public Bookings() {
        this.BookingId = new SimpleIntegerProperty();
        this.BookingDate = new SimpleObjectProperty<>();
        this.BookingNo = new SimpleStringProperty();
        this.TravelerCount = new SimpleDoubleProperty();
        this.CustomerId = new SimpleIntegerProperty();
        this.TripTypeId = new SimpleStringProperty();
        this.PackageId = new SimpleIntegerProperty();
    }

    public Bookings(
            SimpleStringProperty bookingNo,
            SimpleDoubleProperty travelerCount,
            SimpleObjectProperty<Date> bookingDate)
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

    public Date getBookingDate() {
        return BookingDate.get();
    }

    public void setBookingDate(Date bookingDate) {
        this.BookingDate.set(bookingDate);
    }

    public SimpleObjectProperty<Date> bookingDateProperty() {
        return BookingDate;
    }

    public String getBookingNo() {
        return BookingNo.get();
    }

    public SimpleStringProperty bookingNoProperty() {
        return BookingNo;
    }

    public void setBookingNo(String bookingNo) {
        this.BookingNo.set(bookingNo);
    }

    public double getTravelerCount() {
        return TravelerCount.get();
    }

    public SimpleDoubleProperty travelerCountProperty() {
        return TravelerCount;
    }

    public void setTravelerCount(double travelerCount) {
        this.TravelerCount.set(travelerCount);
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
