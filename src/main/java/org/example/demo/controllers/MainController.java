package org.example.demo.controllers;

import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.stage.Modality;
import javafx.stage.Stage;
import org.example.demo.TravelExpertsApplication;
import org.example.demo.models.BookingDetails;
import org.example.demo.models.Bookings;
import org.example.demo.models.Customers;
import org.example.demo.services.BookingDetailsService;
import org.example.demo.services.BookingsService;
import org.example.demo.services.CustomerService;
import org.example.demo.services.dbService;
import org.example.demo.util.TableColumnFactory;
import org.example.demo.controllers.MaintenanceController;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
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

    private ObservableList<Customers> data = FXCollections.observableArrayList();

    private String mode;

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


        btnAdd.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                mode = "Add";
                openDialog(null, mode); // no agent at the beginning of Add
            }
        });

        // user selects from the table
        tvCustomers.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Customers>() {
            @Override
            public void changed(ObservableValue<? extends Customers> observableValue, Customers customer, Customers t1) { // t1 contains new values
                // get the index
                int index = tvCustomers.getSelectionModel().getSelectedIndex();
                // check if this is selection as opposed to de-selection
                if(tvCustomers.getSelectionModel().isSelected(index)){
                    // open the dialog in a separate thread - to avoid error when the dialog closes
                    Platform.runLater(new Runnable() {
                        @Override
                        public void run() {
                            mode = "Edit";
                            openDialog(t1, mode);
                        }
                    });
                }
            }
        });

    }

    private void displayCustomers(){
        data.clear();
        try {
            data = dbService.getCustomers();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        tvCustomers.setItems(data);
    }

    private void openDialog(Customers customer, String mode){
        FXMLLoader fxmlLoader = new FXMLLoader(
                TravelExpertsApplication.class.getResource("dialog-view.fxml"));
        Scene scene = null;
        try {
            scene = new Scene(fxmlLoader.load());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        MaintenanceController maintenanceController = fxmlLoader.getController();
        maintenanceController.setMode(mode);
        if(mode.equals("Edit")){ // fill the text views in the dialog if Edit
            maintenanceController.displayCustomer(customer);
        }
        Stage stage = new Stage();
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setScene(scene);
        stage.showAndWait(); // waits until user is done  with the second scene
        displayCustomers();
    }

}
