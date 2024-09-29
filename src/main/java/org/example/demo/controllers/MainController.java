package org.example.demo.controllers;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import org.example.demo.models.BookingDetails;
import org.example.demo.models.Bookings;
import org.example.demo.models.Customers;
import org.example.demo.services.BookingDetailsService;
import org.example.demo.services.BookingsService;
import org.example.demo.services.CustomerService;
import org.example.demo.util.TableColumnFactory;

import java.net.URL;
import java.util.ResourceBundle;

public class MainController {

    @FXML private ResourceBundle resources;
    @FXML private URL location;
    @FXML private Button btnAdd;
    @FXML private Button btnDelete;
    @FXML private Button btnEdit;
    @FXML private TableView<BookingDetails> tvBookingDetails;
    @FXML private TableView<Bookings> tvBookings;
    @FXML private TableView<Customers> tvCustomers;
    @FXML private Tab tabBooking;
    @FXML private Tab tabBookingDetail;
    @FXML private Tab tabCustomer;

    @FXML
    void initialize() {
        // Ensure all FXML elements are injected properly
        assertions();
        loadInitialCustomerData();

        // Event handling for selecting tabs (use lambdas for JavaFX)
        tabBooking.setOnSelectionChanged(event -> handleTabSelection(
                tabBooking, new Bookings(), tvBookings, BookingsService.getBookings()
        ));

        tabCustomer.setOnSelectionChanged(event -> handleTabSelection(
                tabCustomer, new Customers(), tvCustomers, CustomerService.getCustomers()
        ));

        tabBookingDetail.setOnSelectionChanged(event -> handleTabSelection(
                tabBookingDetail, new BookingDetails(), tvBookingDetails, BookingDetailsService.getBookingDetails()
        ));
    }

    private void loadInitialCustomerData() {
        // Assume that the Customers tab is the first one to be displayed, so load data for it initially
        handleTabSelection(tabCustomer, new Customers(), tvCustomers, CustomerService.getCustomers());
    }

    /**
     * Handles tab selection and populates the TableView with the corresponding data.
     * @param tab the Tab that is being selected.
     * @param entity an instance of the entity to create columns from.
     * @param table the TableView to populate.
     * @param data the data to set for the TableView.
     */
    private <T> void handleTabSelection(Tab tab, T entity, TableView<T> table, ObservableList<T> data) {
        if (tab.isSelected()) {
            // Create columns dynamically based on the entity's fields
            createColumns(entity, table);
            // Set data into the TableView
            table.setItems(data);
        }
    }

    /**
     * Dynamically creates TableColumns for a given entity's fields and sets them in the provided TableView.
     * @param entity the entity used to create columns.
     * @param table the TableView to set the columns on.
     */
    public <T> void createColumns(T entity, TableView<T> table) {
        TableColumnFactory.createColumns(entity, table);
    }

    /**
     * Ensures all FXML elements are properly injected.
     * If any element is missing, it will assert with an error message.
     */
    public void assertions() {
        assert btnAdd != null : "fx:id=\"btnAdd\" was not injected: check your FXML file 'main-view.fxml'.";
        assert btnDelete != null : "fx:id=\"btnDelete\" was not injected: check your FXML file 'main-view.fxml'.";
        assert btnEdit != null : "fx:id=\"btnEdit\" was not injected: check your FXML file 'main-view.fxml'.";
        assert tvBookingDetails != null : "fx:id=\"tvBookingDetails\" was not injected: check your FXML file 'main-view.fxml'.";
        assert tvBookings != null : "fx:id=\"tvBookings\" was not injected: check your FXML file 'main-view.fxml'.";
        assert tvCustomers != null : "fx:id=\"tvCustomers\" was not injected: check your FXML file 'main-view.fxml'.";
        assert tabBooking != null : "fx:id=\"tabBooking\" was not injected: check your FXML file 'main-view.fxml'.";
        assert tabBookingDetail != null : "fx:id=\"tabBookingDetail\" was not injected: check your FXML file 'main-view.fxml'.";
        assert tabCustomer != null : "fx:id=\"tabCustomer\" was not injected: check your FXML file 'main-view.fxml'.";
    }
}
