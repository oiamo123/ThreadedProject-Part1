package org.example.demo.controllers;

import java.net.URL;
import java.util.Date;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Tab;
import javafx.scene.control.TableColumn;
import org.example.demo.models.BookingDetails;
import org.example.demo.models.Bookings;
import org.example.demo.models.Customers;
import org.example.demo.util.dbHelper;
import java.sql.Connection;

public class MainController {
    @FXML private ResourceBundle resources;

    @FXML private URL location;

    @FXML
    private TableColumn<BookingDetails, Double> colAgencyCommision;

    @FXML
    private TableColumn<Bookings, Date> colBookingDate;

    @FXML
    private TableColumn<BookingDetails, Integer> colBookingDetailID;

    @FXML
    private TableColumn<Bookings, Integer> colBookingId;

    @FXML
    private TableColumn<Bookings, String> colBookingNo;

    @FXML
    private TableColumn<Customers, ?> colCustAddress;

    @FXML
    private TableColumn<Customers, String> colCustBusPhone;

    @FXML
    private TableColumn<Customers, String> colCustCity;

    @FXML
    private TableColumn<Customers, String> colCustCountry;

    @FXML
    private TableColumn<Customers, String> colCustFirstName;

    @FXML
    private TableColumn<Customers, String> colCustLastName;

    @FXML
    private TableColumn<Customers, String> colCustHomePhone;

    @FXML
    private TableColumn<Customers, Integer> colCustId;

    @FXML
    private TableColumn<Customers, String> colCustPostal;

    @FXML
    private TableColumn<Customers, String> colCustProv;

    @FXML
    private TableColumn<BookingDetails, String> colDesc;

    @FXML
    private TableColumn<BookingDetails, String> colDestination;

    @FXML
    private TableColumn<BookingDetails, Integer> colIteneraryNo;

    @FXML
    private TableColumn<BookingDetails, Integer> colPrice;

    @FXML
    private TableColumn<BookingDetails, Integer> colTravellerCount;

    @FXML
    private TableColumn<BookingDetails, Date> colTripEnd;

    @FXML
    private TableColumn<BookingDetails, Date> colTripStart;

    @FXML private Tab tabBooking;

    @FXML private Button btnDelete;

    @FXML private Button btnEdit;

    @FXML private Button btnAdd;

    @FXML private Tab tabBookingDetail;

    @FXML private Tab tabCustomer;

    @FXML
    private void initialize() {
        assert colAgencyCommision != null : "fx:id=\"colAgencyCommision\" was not injected: check your FXML file 'main-view.fxml'.";
        assert colBookingDate != null : "fx:id=\"colBookingDate\" was not injected: check your FXML file 'main-view.fxml'.";
        assert colBookingDetailID != null : "fx:id=\"colBookingDetailID\" was not injected: check your FXML file 'main-view.fxml'.";
        assert colBookingId != null : "fx:id=\"colBookingId\" was not injected: check your FXML file 'main-view.fxml'.";
        assert colBookingNo != null : "fx:id=\"colBookingNo\" was not injected: check your FXML file 'main-view.fxml'.";
        assert colCustAddress != null : "fx:id=\"colCustAddress\" was not injected: check your FXML file 'main-view.fxml'.";
        assert colCustBusPhone != null : "fx:id=\"colCustBusPhone\" was not injected: check your FXML file 'main-view.fxml'.";
        assert colCustCity != null : "fx:id=\"colCustCity\" was not injected: check your FXML file 'main-view.fxml'.";
        assert colCustCountry != null : "fx:id=\"colCustCountry\" was not injected: check your FXML file 'main-view.fxml'.";
        assert colCustFirstName != null : "fx:id=\"colCustFirstName\" was not injected: check your FXML file 'main-view.fxml'.";
        assert colCustLastName != null : "fx:id=\"colLastName\" was not injected: check your FXML file 'main-view.fxml'.";
        assert colCustHomePhone != null : "fx:id=\"colCustHomePhone\" was not injected: check your FXML file 'main-view.fxml'.";
        assert colCustId != null : "fx:id=\"colCustId\" was not injected: check your FXML file 'main-view.fxml'.";
        assert colCustPostal != null : "fx:id=\"colCustPostal\" was not injected: check your FXML file 'main-view.fxml'.";
        assert colCustProv != null : "fx:id=\"colCustProv\" was not injected: check your FXML file 'main-view.fxml'.";
        assert colDesc != null : "fx:id=\"colDesc\" was not injected: check your FXML file 'main-view.fxml'.";
        assert colDestination != null : "fx:id=\"colDestination\" was not injected: check your FXML file 'main-view.fxml'.";
        assert colIteneraryNo != null : "fx:id=\"colIteneraryNo\" was not injected: check your FXML file 'main-view.fxml'.";
        assert colPrice != null : "fx:id=\"colPrice\" was not injected: check your FXML file 'main-view.fxml'.";
        assert colTravellerCount != null : "fx:id=\"colTravellerCount\" was not injected: check your FXML file 'main-view.fxml'.";
        assert colTripEnd != null : "fx:id=\"colTripEnd\" was not injected: check your FXML file 'main-view.fxml'.";
        assert colTripStart != null : "fx:id=\"colTripStart\" was not injected: check your FXML file 'main-view.fxml'.";
        assert tabBooking != null : "fx:id=\"tabBooking\" was not injected: check your FXML file 'main-view.fxml'.";
        assert tabBookingDetail != null : "fx:id=\"tabBookingDetail\" was not injected: check your FXML file 'main-view.fxml'.";
        assert tabCustomer != null : "fx:id=\"tabCustomer\" was not injected: check your FXML file 'main-view.fxml'.";
        assert btnDelete != null : "fx:id=\"btnDelete\" was not injected: check your FXML file 'main-view.fxml'.";
        assert btnEdit != null : "fx:id=\"btnEdit\" was not injected: check your FXML file 'main-view.fxml'.";
        assert btnAdd != null : "fx:id=\"btnAdd\" was not injected: check your FXML file 'main-view.fxml'.";

        Connection conn = dbHelper.getConnection();
        System.out.println("Connected to db");
    }
}