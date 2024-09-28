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
import org.example.demo.models.BookingDetails;
import org.example.demo.models.Bookings;
import org.example.demo.models.Column;
import org.example.demo.models.Customers;
import org.example.demo.util.BookingDetailsDB;
import org.example.demo.util.BookingsDB;
import org.example.demo.util.CustomerDB;

public class MainController {

    @FXML private ResourceBundle resources;
    @FXML private URL location;
    @FXML private Button btnAdd;
    @FXML private Button btnDelete;
    @FXML private Button btnEdit;
    @FXML private TableColumn<BookingDetails, Double> colAgencyCommision;
    @FXML private TableColumn<Customers, Integer> colAgentId;
    @FXML private TableColumn<BookingDetails, Integer> colBDBookingId;
    @FXML private TableColumn<Bookings, Integer> colBkCustomerId;
    @FXML private TableColumn<Bookings, Date> colBookingDate;
    @FXML private TableColumn<BookingDetails, Integer> colBookingDetailID;
    @FXML private TableColumn<Bookings, Integer> colBookingId;
    @FXML private TableColumn<Bookings, String> colBookingNo;
    @FXML private TableColumn<BookingDetails, String> colClass;
    @FXML private TableColumn<Customers, String> colCustAddress;
    @FXML private TableColumn<Customers, String> colCustBusPhone;
    @FXML private TableColumn<Customers, String> colCustCity;
    @FXML private TableColumn<Customers, String> colCustCountry;
    @FXML private TableColumn<Customers, String> colCustEmail;
    @FXML private TableColumn<Customers, String> colCustFirstName;
    @FXML private TableColumn<Customers, String> colCustHomePhone;
    @FXML private TableColumn<Customers, Integer> colCustId;
    @FXML private TableColumn<Customers, String> colCustPostal;
    @FXML private TableColumn<Customers, String> colCustProv;
    @FXML private TableColumn<BookingDetails, String> colDesc;
    @FXML private TableColumn<BookingDetails, String> colDestination;
    @FXML private TableColumn<BookingDetails, String> colFee;
    @FXML private TableColumn<BookingDetails, String> colIteneraryNo;
    @FXML private TableColumn<Customers, String> colLastName;
    @FXML private TableColumn<Bookings, Integer> colPackageId;
    @FXML private TableColumn<BookingDetails, Double> colPrice;
    @FXML private TableColumn<BookingDetails, Integer> colProductSupplier;
    @FXML private TableColumn<BookingDetails, String> colRegion;
    @FXML private TableColumn<Bookings, Double> colTravellerCount;
    @FXML private TableColumn<BookingDetails, Date> colTripEnd;
    @FXML private TableColumn<BookingDetails, Date> colTripStart;
    @FXML private TableColumn<Bookings, String> colTripType;
    @FXML private TableView<BookingDetails> tvBookingDetails;
    @FXML private TableView<Bookings> tvBookings;
    @FXML private TableView<Customers> tvCustomers;
    @FXML private Tab tabBooking;
    @FXML private Tab tabBookingDetail;
    @FXML private Tab tabCustomer;

    @FXML
    void initialize() {
        assert btnAdd != null : "fx:id=\"btnAdd\" was not injected: check your FXML file 'main-view.fxml'.";
        assert btnDelete != null : "fx:id=\"btnDelete\" was not injected: check your FXML file 'main-view.fxml'.";
        assert btnEdit != null : "fx:id=\"btnEdit\" was not injected: check your FXML file 'main-view.fxml'.";
        assert colAgencyCommision != null : "fx:id=\"colAgencyCommision\" was not injected: check your FXML file 'main-view.fxml'.";
        assert colAgentId != null : "fx:id=\"colAgentId\" was not injected: check your FXML file 'main-view.fxml'.";
        assert colBDBookingId != null : "fx:id=\"colBDBookingId\" was not injected: check your FXML file 'main-view.fxml'.";
        assert colBkCustomerId != null : "fx:id=\"colBkCustomerId\" was not injected: check your FXML file 'main-view.fxml'.";
        assert colBookingDate != null : "fx:id=\"colBookingDate\" was not injected: check your FXML file 'main-view.fxml'.";
        assert colBookingDetailID != null : "fx:id=\"colBookingDetailID\" was not injected: check your FXML file 'main-view.fxml'.";
        assert colBookingId != null : "fx:id=\"colBookingId\" was not injected: check your FXML file 'main-view.fxml'.";
        assert colBookingNo != null : "fx:id=\"colBookingNo\" was not injected: check your FXML file 'main-view.fxml'.";
        assert colClass != null : "fx:id=\"colClass\" was not injected: check your FXML file 'main-view.fxml'.";
        assert colCustAddress != null : "fx:id=\"colCustAddress\" was not injected: check your FXML file 'main-view.fxml'.";
        assert colCustBusPhone != null : "fx:id=\"colCustBusPhone\" was not injected: check your FXML file 'main-view.fxml'.";
        assert colCustCity != null : "fx:id=\"colCustCity\" was not injected: check your FXML file 'main-view.fxml'.";
        assert colCustCountry != null : "fx:id=\"colCustCountry\" was not injected: check your FXML file 'main-view.fxml'.";
        assert colCustEmail != null : "fx:id=\"colCustEmail\" was not injected: check your FXML file 'main-view.fxml'.";
        assert colCustFirstName != null : "fx:id=\"colCustFirstName\" was not injected: check your FXML file 'main-view.fxml'.";
        assert colCustHomePhone != null : "fx:id=\"colCustHomePhone\" was not injected: check your FXML file 'main-view.fxml'.";
        assert colCustId != null : "fx:id=\"colCustId\" was not injected: check your FXML file 'main-view.fxml'.";
        assert colCustPostal != null : "fx:id=\"colCustPostal\" was not injected: check your FXML file 'main-view.fxml'.";
        assert colCustProv != null : "fx:id=\"colCustProv\" was not injected: check your FXML file 'main-view.fxml'.";
        assert colDesc != null : "fx:id=\"colDesc\" was not injected: check your FXML file 'main-view.fxml'.";
        assert colDestination != null : "fx:id=\"colDestination\" was not injected: check your FXML file 'main-view.fxml'.";
        assert colFee != null : "fx:id=\"colFee\" was not injected: check your FXML file 'main-view.fxml'.";
        assert colIteneraryNo != null : "fx:id=\"colIteneraryNo\" was not injected: check your FXML file 'main-view.fxml'.";
        assert colLastName != null : "fx:id=\"colLastName\" was not injected: check your FXML file 'main-view.fxml'.";
        assert colPackageId != null : "fx:id=\"colPackageId\" was not injected: check your FXML file 'main-view.fxml'.";
        assert colPrice != null : "fx:id=\"colPrice\" was not injected: check your FXML file 'main-view.fxml'.";
        assert colProductSupplier != null : "fx:id=\"colProductSupplier\" was not injected: check your FXML file 'main-view.fxml'.";
        assert colRegion != null : "fx:id=\"colRegion\" was not injected: check your FXML file 'main-view.fxml'.";
        assert colTravellerCount != null : "fx:id=\"colTravellerCount\" was not injected: check your FXML file 'main-view.fxml'.";
        assert colTripEnd != null : "fx:id=\"colTripEnd\" was not injected: check your FXML file 'main-view.fxml'.";
        assert colTripStart != null : "fx:id=\"colTripStart\" was not injected: check your FXML file 'main-view.fxml'.";
        assert colTripType != null : "fx:id=\"colTripType\" was not injected: check your FXML file 'main-view.fxml'.";
        assert tabBooking != null : "fx:id=\"tabBooking\" was not injected: check your FXML file 'main-view.fxml'.";
        assert tabBookingDetail != null : "fx:id=\"tabBookingDetail\" was not injected: check your FXML file 'main-view.fxml'.";
        assert tabCustomer != null : "fx:id=\"tabCustomer\" was not injected: check your FXML file 'main-view.fxml'.";
        assert tvBookingDetails != null : "fx:id=\"tvBookingDetails\" was not injected: check your FXML file 'main-view.fxml'.";
        assert tvBookings != null : "fx:id=\"tvBookings\" was not injected: check your FXML file 'main-view.fxml'.";
        assert tvCustomers != null : "fx:id=\"tvCustomers\" was not injected: check your FXML file 'main-view.fxml'.";

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
