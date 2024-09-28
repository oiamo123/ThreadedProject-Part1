package org.example.demo.controllers;

import java.lang.reflect.Field;
import java.net.URL;
import java.util.Date;
import java.util.ResourceBundle;

import javafx.collections.ObservableList;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Tab;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import org.example.demo.models.*;
import org.example.demo.util.BookingDetailsDB;
import org.example.demo.util.BookingsDB;
import org.example.demo.util.CustomerDB;

public class MainController {

    @FXML private ResourceBundle resources;
    @FXML private URL location;
    @FXML private Button btnAdd;
    @FXML private Button btnDelete;
    @FXML private Button btnEdit;
    @FXML private Tab tabBooking;
    @FXML private Tab tabBookingDetail;
    @FXML private Tab tabCustomer;
    @FXML private Tab tabInvoices;
    @FXML private TableView<BookingDetails> tvBookingDetails;
    @FXML private TableView<Bookings> tvBookings;
    @FXML private TableView<Customers> tvCustomers;
    @FXML private TableView<Invoice> tvInvoices;

    @FXML
    void initialize() {
        assert btnAdd != null : "fx:id=\"btnAdd\" was not injected: check your FXML file 'main-view.fxml'.";
        assert btnDelete != null : "fx:id=\"btnDelete\" was not injected: check your FXML file 'main-view.fxml'.";
        assert btnEdit != null : "fx:id=\"btnEdit\" was not injected: check your FXML file 'main-view.fxml'.";
        assert tabBooking != null : "fx:id=\"tabBooking\" was not injected: check your FXML file 'main-view.fxml'.";
        assert tabBookingDetail != null : "fx:id=\"tabBookingDetail\" was not injected: check your FXML file 'main-view.fxml'.";
        assert tabCustomer != null : "fx:id=\"tabCustomer\" was not injected: check your FXML file 'main-view.fxml'.";
        assert tabInvoices != null : "fx:id=\"tabInvoices\" was not injected: check your FXML file 'main-view.fxml'.";
        assert tvBookingDetails != null : "fx:id=\"tvBookingDetails\" was not injected: check your FXML file 'main-view.fxml'.";
        assert tvBookings != null : "fx:id=\"tvBookings\" was not injected: check your FXML file 'main-view.fxml'.";
        assert tvCustomers != null : "fx:id=\"tvCustomers\" was not injected: check your FXML file 'main-view.fxml'.";
        assert tvInvoices != null : "fx:id=\"tvInvoices\" was not injected: check your FXML file 'main-view.fxml'.";

        tabBooking.setOnSelectionChanged(new EventHandler<Event>() {
            @Override
            public void handle(Event event) {
                if (tabBooking.isSelected()) {
                    createColumns(new Bookings(), tvBookings);
                    ObservableList<Bookings> data = BookingsDB.getBookings();
                    tvBookings.setItems(data);
                }
            }
        });

        tabCustomer.setOnSelectionChanged(new EventHandler<Event>() {
            @Override
            public void handle(Event event) {
                if (tabCustomer.isSelected()) {
                    createColumns(new Customers(), tvCustomers);
                    ObservableList<Customers> data = CustomerDB.getCustomers();
                    tvCustomers.setItems(data);
                }
            }
        });

        tabBookingDetail.setOnSelectionChanged(new EventHandler<Event>() {
            @Override
            public void handle(Event event) {
                if (tabBookingDetail.isSelected()) {
                    createColumns(new BookingDetails(), tvBookingDetails);
                    ObservableList<BookingDetails> data = BookingDetailsDB.getBookingDetails();
                    tvBookingDetails.setItems(data);
                }
            }
        });

        createColumns(new Customers(), tvCustomers);
        tvCustomers.setItems(CustomerDB.getCustomers());
    }

    public void createColumns(Object obj, TableView table) {
        table.getColumns().clear();

        Field[] fields = obj.getClass().getDeclaredFields();

        for (Field field : fields) {
            Column column = field.getAnnotation(Column.class);
            String name = column.name();

            TableColumn<?, ?> tableColumn = new TableColumn<>(name);

            tableColumn.setCellValueFactory(new PropertyValueFactory<>(field.getName()));

            table.getColumns().add(tableColumn);
        }
    }
}
