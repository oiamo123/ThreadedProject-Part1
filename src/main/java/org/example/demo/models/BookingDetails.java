package org.example.demo.models;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;

import java.text.SimpleDateFormat;
import java.util.Date;

public class BookingDetails {
    @Id
    private SimpleIntegerProperty BookingDetailId;
    private SimpleIntegerProperty ItineraryNo;
    private SimpleObjectProperty<Date> TripStart;
    private SimpleObjectProperty<Date> TripEnd;
    private SimpleStringProperty Description;
    private SimpleStringProperty Destination;
    private SimpleDoubleProperty BasePrice;
    private SimpleDoubleProperty AgencyCommission;
    private SimpleIntegerProperty BookingId;
    private SimpleStringProperty RegionId;
    private SimpleStringProperty ClassId;
    private SimpleStringProperty FeeId;
    private SimpleIntegerProperty ProductSupplierId;

    // Constructors
    public BookingDetails() {
        this.BookingDetailId = new SimpleIntegerProperty();
        this.ItineraryNo = new SimpleIntegerProperty();
        this.TripStart = new SimpleObjectProperty<>();
        this.TripEnd = new SimpleObjectProperty<>();
        this.Description = new SimpleStringProperty();
        this.Destination = new SimpleStringProperty();
        this.BasePrice = new SimpleDoubleProperty();
        this.AgencyCommission = new SimpleDoubleProperty();
        this.BookingId = new SimpleIntegerProperty();
        this.RegionId = new SimpleStringProperty();
        this.ClassId = new SimpleStringProperty();
        this.FeeId = new SimpleStringProperty();
        this.ProductSupplierId = new SimpleIntegerProperty();
    }

    public BookingDetails(
            SimpleIntegerProperty itineraryNo,
            SimpleStringProperty description,
            SimpleStringProperty destination,
            SimpleDoubleProperty basePrice,
            SimpleDoubleProperty agencyCommission)
    {
        this.ItineraryNo = itineraryNo;
        this.Description = description;
        this.Destination = destination;
        this.BasePrice = basePrice;
        this.AgencyCommission = agencyCommission;
    }

    public int getBookingDetailId() {
        return BookingDetailId.get();
    }

    public SimpleIntegerProperty bookingDetailIdProperty() {
        return BookingDetailId;
    }

    public void setBookingDetailId(int bookingDetailId) {
        this.BookingDetailId.set(bookingDetailId);
    }

    public int getItineraryNo() {
        return ItineraryNo.get();
    }

    public SimpleIntegerProperty itineraryNoProperty() {
        return ItineraryNo;
    }

    public void setItineraryNo(int itineraryNo) {
        this.ItineraryNo.set(itineraryNo);
    }

    public Date getTripStart() {
        return TripStart.get();
    }

    public SimpleObjectProperty<Date> tripStartProperty() {
        return TripStart;
    }

    public void setTripStart(Date tripStart) {
        this.TripStart.set(tripStart);
    }

    public Date getTripEnd() {
        return TripEnd.get();
    }

    public SimpleObjectProperty<Date> tripEndProperty() {
        return TripEnd;
    }

    public void setTripEnd(Date tripEnd) {
        this.TripEnd.set(tripEnd);
    }

    public String getDescription() {
        return Description.get();
    }

    public SimpleStringProperty descriptionProperty() {
        return Description;
    }

    public void setDescription(String description) {
        this.Description.set(description);
    }

    public String getDestination() {
        return Destination.get();
    }

    public SimpleStringProperty destinationProperty() {
        return Destination;
    }

    public void setDestination(String destination) {
        this.Destination.set(destination);
    }

    public double getBasePrice() {
        return BasePrice.get();
    }

    public SimpleDoubleProperty basePriceProperty() {
        return BasePrice;
    }

    public void setBasePrice(double basePrice) {
        this.BasePrice.set(basePrice);
    }

    public double getAgencyCommission() {
        return AgencyCommission.get();
    }

    public SimpleDoubleProperty agencyCommissionProperty() {
        return AgencyCommission;
    }

    public void setAgencyCommission(double agencyCommission) {
        this.AgencyCommission.set(agencyCommission);
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

    public String getRegionId() {
        return RegionId.get();
    }

    public SimpleStringProperty regionIdProperty() {
        return RegionId;
    }

    public void setRegionId(String regionId) {
        this.RegionId.set(regionId);
    }

    public String getClassId() {
        return ClassId.get();
    }

    public SimpleStringProperty classIdProperty() {
        return ClassId;
    }

    public void setClassId(String classId) {
        this.ClassId.set(classId);
    }

    public String getFeeId() {
        return FeeId.get();
    }

    public SimpleStringProperty feeIdProperty() {
        return FeeId;
    }

    public void setFeeId(String feeId) {
        this.FeeId.set(feeId);
    }

    public int getProductSupplierId() {
        return ProductSupplierId.get();
    }

    public SimpleIntegerProperty productSupplierIdProperty() {
        return ProductSupplierId;
    }

    public void setProductSupplierId(int productSupplierId) {
        this.ProductSupplierId.set(productSupplierId);
    }
}
