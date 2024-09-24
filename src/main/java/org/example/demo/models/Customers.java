package org.example.demo.models;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class Customers {
    private final SimpleIntegerProperty customerId;
    private final SimpleStringProperty custFirstName;
    private final SimpleStringProperty custLastName;
    private final SimpleStringProperty custAddress;
    private final SimpleStringProperty custCity;
    private final SimpleStringProperty custProv;
    private final SimpleStringProperty custPostal;
    private final SimpleStringProperty custCountry;
    private final SimpleStringProperty custHomePhone;
    private final SimpleStringProperty custBusPhone;

    // Constructors
    public Customers() {
        this.customerId = new SimpleIntegerProperty();
        this.custFirstName = new SimpleStringProperty();
        this.custLastName = new SimpleStringProperty();
        this.custAddress = new SimpleStringProperty();
        this.custCity = new SimpleStringProperty();
        this.custProv = new SimpleStringProperty();
        this.custPostal = new SimpleStringProperty();
        this.custCountry = new SimpleStringProperty();
        this.custHomePhone = new SimpleStringProperty();
        this.custBusPhone = new SimpleStringProperty();
    }


    // Getters and Setters
    public int getCustomerId() {
        return customerId.get();
    }

    public void setCustomerId(int customerId) {
        this.customerId.set(customerId);
    }

    public String getCustFirstName() {
        return custFirstName.get();
    }

    public void setCustFirstName(String custFirstName) {
        this.custFirstName.set(custFirstName);
    }

    public String getCustLastName() {
        return custLastName.get();
    }

    public void setCustLastName(String custLastName) {
        this.custLastName.set(custLastName);
    }

    public String getCustAddress() {
        return custAddress.get();
    }

    public void setCustAddress(String custAddress) {
        this.custAddress.set(custAddress);
    }

    public String getCustCity() {
        return custCity.get();
    }

    public void setCustCity(String custCity) {
        this.custCity.set(custCity);
    }

    public String getCustProv() {
        return custProv.get();
    }

    public void setCustProv(String custProv) {
        this.custProv.set(custProv);
    }

    public String getCustPostal() {
        return custPostal.get();
    }

    public void setCustPostal(String custPostal) {
        this.custPostal.set(custPostal);
    }

    public String getCustCountry() {
        return custCountry.get();
    }

    public void setCustCountry(String custCountry) {
        this.custCountry.set(custCountry);
    }

    public String getCustHomePhone() {
        return custHomePhone.get();
    }

    public void setCustHomePhone(String custHomePhone) {
        this.custHomePhone.set(custHomePhone);
    }

    public String getCustBusPhone() {
        return custBusPhone.get();
    }

    public void setCustBusPhone(String custBusPhone) {
        this.custBusPhone.set(custBusPhone);
    }


}
