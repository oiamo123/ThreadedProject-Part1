package org.example.demo.models;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;

import java.text.SimpleDateFormat;

public class Invoice {
    // Invoice properties
    private SimpleIntegerProperty invoiceId;
    private SimpleDateFormat invoiceDate;

    // Invoice Cost properties
    private SimpleDoubleProperty fees;
    private SimpleDoubleProperty total;
    private SimpleDoubleProperty totalTax;
    private SimpleDoubleProperty commissionTotal;

    // Related properties
    private SimpleIntegerProperty bookingDetailId;
    private SimpleIntegerProperty customerId;
    private SimpleIntegerProperty packageId;

}
