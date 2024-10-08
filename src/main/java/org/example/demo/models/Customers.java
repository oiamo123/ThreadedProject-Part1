package org.example.demo.models;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class Customers {
    @Id
    @Column(name="Customer ID")
    private SimpleIntegerProperty CustomerId;

    @Column(name="First Name")
    private SimpleStringProperty CustFirstName;

    @Column(name="Last Name")
    private SimpleStringProperty CustLastName;

    @Column(name="Address")
    private SimpleStringProperty CustAddress;

    @Column(name="City")
    private SimpleStringProperty CustCity;

    @Column(name="Province")
    private SimpleStringProperty CustProv;

    @Column(name="Postal")
    private SimpleStringProperty CustPostal;

    @Column(name="Country")
    private SimpleStringProperty CustCountry;

    @Column(name="Home Phone")
    private SimpleStringProperty CustHomePhone;

    @Column(name="Business Phone")
    private SimpleStringProperty CustBusPhone;

    @Column(name="Email")
    private SimpleStringProperty CustEmail;

    @Column(name="Agent")
    private SimpleIntegerProperty AgentId;

    // Constructors
    public Customers() {
        this.CustomerId = new SimpleIntegerProperty();
        this.CustFirstName = new SimpleStringProperty();
        this.CustLastName = new SimpleStringProperty();
        this.CustAddress = new SimpleStringProperty();
        this.CustCity = new SimpleStringProperty();
        this.CustProv = new SimpleStringProperty();
        this.CustPostal = new SimpleStringProperty();
        this.CustCountry = new SimpleStringProperty();
        this.CustHomePhone = new SimpleStringProperty();
        this.CustBusPhone = new SimpleStringProperty();
        this.CustEmail = new SimpleStringProperty();
        this.AgentId = new SimpleIntegerProperty();
    }

    public Customers(String customerId, String text, String text1, String text2, String text3, String text4, String text5, String text6, String text7, String text8) {
    }

    public Customers(int customerId, String string, String string1, String string2, String string3, String string4, String string5, String string6, String string7, String string8, String string9, int anInt1) {
    }

    public int getCustomerId() {
        return CustomerId.get();
    }

    public SimpleIntegerProperty customerIdProperty() {
        return CustomerId;
    }

    public void setCustomerId(int customerId) {
        this.CustomerId.set(customerId);
    }

    public String getCustFirstName() {
        return CustFirstName.get();
    }

    public SimpleStringProperty custFirstNameProperty() {
        return CustFirstName;
    }

    public void setCustFirstName(String custFirstName) {
        this.CustFirstName.set(custFirstName);
    }

    public String getCustLastName() {
        return CustLastName.get();
    }

    public SimpleStringProperty custLastNameProperty() {
        return CustLastName;
    }

    public void setCustLastName(String custLastName) {
        this.CustLastName.set(custLastName);
    }

    public String getCustAddress() {
        return CustAddress.get();
    }

    public SimpleStringProperty custAddressProperty() {
        return CustAddress;
    }

    public void setCustAddress(String custAddress) {
        this.CustAddress.set(custAddress);
    }

    public String getCustCity() {
        return CustCity.get();
    }

    public SimpleStringProperty custCityProperty() {
        return CustCity;
    }

    public void setCustCity(String custCity) {
        this.CustCity.set(custCity);
    }

    public String getCustProv() {
        return CustProv.get();
    }

    public SimpleStringProperty custProvProperty() {
        return CustProv;
    }

    public void setCustProv(String custProv) {
        this.CustProv.set(custProv);
    }

    public String getCustPostal() {
        return CustPostal.get();
    }

    public SimpleStringProperty custPostalProperty() {
        return CustPostal;
    }

    public void setCustPostal(String custPostal) {
        this.CustPostal.set(custPostal);
    }

    public String getCustCountry() {
        return CustCountry.get();
    }

    public SimpleStringProperty custCountryProperty() {
        return CustCountry;
    }

    public void setCustCountry(String custCountry) {
        this.CustCountry.set(custCountry);
    }

    public String getCustHomePhone() {
        return CustHomePhone.get();
    }

    public SimpleStringProperty custHomePhoneProperty() {
        return CustHomePhone;
    }

    public void setCustHomePhone(String custHomePhone) {
        this.CustHomePhone.set(custHomePhone);
    }

    public String getCustBusPhone() {
        return CustBusPhone.get();
    }

    public SimpleStringProperty custBusPhoneProperty() {
        return CustBusPhone;
    }

    public void setCustBusPhone(String custBusPhone) {
        this.CustBusPhone.set(custBusPhone);
    }

    public String getCustEmail() {
        return CustEmail.get();
    }

    public SimpleStringProperty custEmailProperty() {
        return CustEmail;
    }

    public void setCustEmail(String custEmail) {
        this.CustEmail.set(custEmail);
    }

    public int getAgentId() {
        return AgentId.get();
    }

    public SimpleIntegerProperty agentIdProperty() {
        return AgentId;
    }

    public void setAgentId(int agentId) {
        this.AgentId.set(agentId);
    }
}
