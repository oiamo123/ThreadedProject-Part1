package org.example.demo.controllers;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Tab;
import javafx.scene.control.TableColumn;
import org.example.demo.ConnectionDB;

import java.sql.Connection;

public class MainController {
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TableColumn<?, ?> colAgencyCommision;

    @FXML
    private TableColumn<?, ?> colBookingDate;

    @FXML
    private TableColumn<?, ?> colBookingDetailID;

    @FXML
    private TableColumn<?, ?> colBookingId;

    @FXML
    private TableColumn<?, ?> colBookingNo;

    @FXML
    private TableColumn<?, ?> colCustAddress;

    @FXML
    private TableColumn<?, ?> colCustBusPhone;

    @FXML
    private TableColumn<?, ?> colCustCity;

    @FXML
    private TableColumn<?, ?> colCustCountry;

    @FXML
    private TableColumn<?, ?> colCustFirstName;

    @FXML
    private TableColumn<?, ?> colCustHomePhone;

    @FXML
    private TableColumn<?, ?> colCustId;

    @FXML
    private TableColumn<?, ?> colCustPostal;

    @FXML
    private TableColumn<?, ?> colCustProv;

    @FXML
    private TableColumn<?, ?> colDesc;

    @FXML
    private TableColumn<?, ?> colDestination;

    @FXML
    private TableColumn<?, ?> colIteneraryNo;

    @FXML
    private TableColumn<?, ?> colLastName;

    @FXML
    private TableColumn<?, ?> colPrice;

    @FXML
    private TableColumn<?, ?> colTravellerCount;

    @FXML
    private TableColumn<?, ?> colTripEnd;

    @FXML
    private TableColumn<?, ?> colTripStart;

    @FXML
    private Tab tabBooking;

    @FXML
    private Tab tabBookingDetail;

    @FXML
    private Tab tabCustomer;

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
        assert colCustHomePhone != null : "fx:id=\"colCustHomePhone\" was not injected: check your FXML file 'main-view.fxml'.";
        assert colCustId != null : "fx:id=\"colCustId\" was not injected: check your FXML file 'main-view.fxml'.";
        assert colCustPostal != null : "fx:id=\"colCustPostal\" was not injected: check your FXML file 'main-view.fxml'.";
        assert colCustProv != null : "fx:id=\"colCustProv\" was not injected: check your FXML file 'main-view.fxml'.";
        assert colDesc != null : "fx:id=\"colDesc\" was not injected: check your FXML file 'main-view.fxml'.";
        assert colDestination != null : "fx:id=\"colDestination\" was not injected: check your FXML file 'main-view.fxml'.";
        assert colIteneraryNo != null : "fx:id=\"colIteneraryNo\" was not injected: check your FXML file 'main-view.fxml'.";
        assert colLastName != null : "fx:id=\"colLastName\" was not injected: check your FXML file 'main-view.fxml'.";
        assert colPrice != null : "fx:id=\"colPrice\" was not injected: check your FXML file 'main-view.fxml'.";
        assert colTravellerCount != null : "fx:id=\"colTravellerCount\" was not injected: check your FXML file 'main-view.fxml'.";
        assert colTripEnd != null : "fx:id=\"colTripEnd\" was not injected: check your FXML file 'main-view.fxml'.";
        assert colTripStart != null : "fx:id=\"colTripStart\" was not injected: check your FXML file 'main-view.fxml'.";
        assert tabBooking != null : "fx:id=\"tabBooking\" was not injected: check your FXML file 'main-view.fxml'.";
        assert tabBookingDetail != null : "fx:id=\"tabBookingDetail\" was not injected: check your FXML file 'main-view.fxml'.";
        assert tabCustomer != null : "fx:id=\"tabCustomer\" was not injected: check your FXML file 'main-view.fxml'.";

        Connection conn = ConnectionDB.getConnection();
        System.out.println("Connected to db");
    }
}