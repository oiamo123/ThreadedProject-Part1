package org.example.demo.controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.concurrent.Task;
import javafx.fxml.FXML;
import javafx.geometry.Orientation;
import javafx.scene.Node;
import javafx.scene.control.*;
import org.example.demo.models.Customers;
import org.example.demo.services.CustomerService;

public class MainController {

    @FXML private TableView<Customers> tvCustomers;
    @FXML private Tab tabCustomer;

    // Cached data to avoid re-fetching
    private ObservableList<Customers> cachedCustomerData = FXCollections.observableArrayList();

    // Pagination parameters
    private static final int PAGE_SIZE = 100;
    private int currentPage = 0;

    @FXML
    void initialize() {
        assertions();

        // Load customer data from cache if available, otherwise load async
        if (cachedCustomerData.isEmpty()) {
            loadCustomerDataAsync(currentPage);  // First load, fetch from service
        } else {
            tvCustomers.setItems(cachedCustomerData);  // Use cached data if available
        }

        // Lazy load more data when scrolling near the bottom of the TableView
        tvCustomers.setOnScroll(event -> {
            if (isScrollAtBottom()) {
                loadCustomerDataAsync(++currentPage);  // Load the next page
            }
        });
    }

    /**
     * Asynchronously loads customer data for the given page and caches it.
     * @param page the page number to load
     */
    private void loadCustomerDataAsync(int page) {
        Task<ObservableList<Customers>> task = new Task<>() {
            @Override
            protected ObservableList<Customers> call() {
                return CustomerService.getCustomers(page);  // Fetch data in the background
            }
        };

        // Update TableView and cache the data once the task is complete
        task.setOnSucceeded(event -> {
            cachedCustomerData.addAll(task.getValue());  // Cache the data
            tvCustomers.setItems(cachedCustomerData);    // Update TableView with the new data
        });

        // Handle failure case
        task.setOnFailed(event -> {
            System.err.println("Failed to load customers: " + task.getException());
        });

        // Run the task in a background thread to keep the UI responsive
        new Thread(task).start();
    }

    private boolean isScrollAtBottom() {
        // Get the vertical scrollbar from the TableView
        ScrollBar scrollBar = getVerticalScrollbar(tvCustomers);

        // Check if the scroll position is at the bottom
        return scrollBar != null && scrollBar.getValue() == scrollBar.getMax();
    }

    private ScrollBar getVerticalScrollbar(TableView<?> table) {
        // The TableView might have a ScrollBar in its children, so we traverse the children nodes to find it
        for (Node node : table.lookupAll(".scroll-bar")) {
            if (node instanceof ScrollBar) {
                ScrollBar bar = (ScrollBar) node;
                if (bar.getOrientation() == Orientation.VERTICAL) {
                    return bar;  // Return the vertical scrollbar
                }
            }
        }
        return null;  // No vertical scrollbar found
    }


    /**
     * Ensures all FXML elements are properly injected.
     * If any element is missing, it will assert with an error message.
     */
    public void assertions() {
        assert tvCustomers != null : "fx:id=\"tvCustomers\" was not injected: check your FXML file 'main-view.fxml'.";
        assert tabCustomer != null : "fx:id=\"tabCustomer\" was not injected: check your FXML file 'main-view.fxml'.";
    }
}
