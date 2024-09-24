package org.example.demo.models;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

import java.text.SimpleDateFormat;
import java.util.Date;

public class BookingDetails {
    private SimpleIntegerProperty bookingDetailId;
    private final SimpleIntegerProperty itineraryNo;
    private SimpleDateFormat tripStart;
    private SimpleDateFormat tripEnd;
    private final SimpleStringProperty description;
    private final SimpleStringProperty destination;
    private final SimpleDoubleProperty basePrice;
    private final SimpleDoubleProperty agencyCommission;
    private SimpleIntegerProperty bookingId;

    // Constructors
    public BookingDetails() {
        this.bookingDetailId = new SimpleIntegerProperty();
        this.itineraryNo = new SimpleIntegerProperty();
        this.tripStart = new SimpleDateFormat();
        this.tripEnd = new SimpleDateFormat();
        this.description = new SimpleStringProperty();
        this.destination = new SimpleStringProperty();
        this.basePrice = new SimpleDoubleProperty();
        this.agencyCommission = new SimpleDoubleProperty();
        this.bookingId = new SimpleIntegerProperty();
    }

    public BookingDetails(
            SimpleIntegerProperty itineraryNo,
            SimpleStringProperty description,
            SimpleStringProperty destination,
            SimpleDoubleProperty basePrice,
            SimpleDoubleProperty agencyCommission)
    {
        this.itineraryNo = itineraryNo;
        this.description = description;
        this.destination = destination;
        this.basePrice = basePrice;
        this.agencyCommission = agencyCommission;
    }


    // Getters and Setters

    public int getBookingDetailId() {
        return bookingDetailId.get();
    }

    public void setBookingDetailId(int bookingDetailId) {
        this.bookingDetailId.set(bookingDetailId);
    }

    public int getItineraryNo() {
        return itineraryNo.get();
    }

    public void setItineraryNo(int itineraryNo) {
        this.itineraryNo.set(itineraryNo);
    }

    public String getTripStart() {
        return tripStart.format(new Date());
    }

    public void setTripStart(Date tripStart) {
        this.tripStart = new SimpleDateFormat("yyyy-MM-dd");
    }

    public String getTripEnd() {
        return tripEnd.format(new Date());
    }

    public void setTripEnd(Date tripEnd) {
        this.tripEnd = new SimpleDateFormat("yyyy-MM-dd");
    }

    public String getDescription() {
        return description.get();
    }

    public void setDescription(String description) {
        this.description.set(description);
    }

    public String getDestination() {
        return destination.get();
    }

    public void setDestination(String destination) {
        this.destination.set(destination);
    }

    public double getBasePrice() {
        return basePrice.get();
    }

    public void setBasePrice(double basePrice) {
        this.basePrice.set(basePrice);
    }

    public double getAgencyCommission() {
        return agencyCommission.get();
    }

    public void setAgencyCommission(double agencyCommission) {
        this.agencyCommission.set(agencyCommission);
    }

    public int getBookingId() {
        return bookingId.get();
    }


}
