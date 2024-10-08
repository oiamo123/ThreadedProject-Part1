package org.example.demo.controllers;

import java.net.URL;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import org.example.demo.models.Customers;
import org.example.demo.services.dbService;

public class MaintenanceController {

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="btnCancel"
    private Button btnCancel; // Value injected by FXMLLoader

    @FXML // fx:id="btnDelete"
    private Button btnDelete; // Value injected by FXMLLoader

    @FXML // fx:id="btnSave"
    private Button btnSave; // Value injected by FXMLLoader

    @FXML // fx:id="lblMode"
    private Label lblMode; // Value injected by FXMLLoader

    @FXML // fx:id="tfCustomerId"
    private TextField tfCustomerId; // Value injected by FXMLLoader

    @FXML // fx:id="tfCustomerFirstName"
    private TextField tfCustomerFirstName; // Value injected by FXMLLoader

    @FXML // fx:id="tfCustomerLastName"
    private TextField tfCustomerLastName; // Value injected by FXMLLoader

    @FXML // fx:id="tfCustomerAddress"
    private TextField tfCustomerAddress; // Value injected by FXMLLoader

    @FXML // fx:id="tfCity"
    private TextField tfCity; // Value injected by FXMLLoader

    @FXML // fx:id="tfProvince"
    private TextField tfProvince; // Value injected by FXMLLoader

    @FXML // fx:id="tfPostal"
    private TextField tfPostal; // Value injected by FXMLLoader

    @FXML // fx:id="tfCountry"
    private TextField tfCountry; // Value injected by FXMLLoader

    @FXML // fx:id="tfHomePhone"
    private TextField tfHomePhone; // Value injected by FXMLLoader

    @FXML // fx:id="tfBusPhone"
    private TextField tfBusPhone; // Value injected by FXMLLoader

    @FXML // fx:id="tfBusPhone"
    private TextField tfCustEmail; // Value injected by FXMLLoader

    @FXML // fx:id="tfBusPhone"
    private TextField tfAgentId; // Value injected by FXMLLoader

    private String mode; // either Add or Edit

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert btnCancel != null : "fx:id=\"btnCancel\" was not injected: check your FXML file 'dialog-view.fxml'.";
        assert btnDelete != null : "fx:id=\"btnDelete\" was not injected: check your FXML file 'dialog-view.fxml'.";
        assert btnSave != null : "fx:id=\"btnSave\" was not injected: check your FXML file 'dialog-view.fxml'.";
        assert lblMode != null : "fx:id=\"lblMode\" was not injected: check your FXML file 'dialog-view.fxml'.";
        assert tfCustomerId != null : "fx:id=\"tfCustomerId\" was not injected: check your FXML file 'dialog-view.fxml'.";
        assert tfCustomerFirstName != null : "fx:id=\"tfCustomerFirstName\" was not injected: check your FXML file 'dialog-view.fxml'.";
        assert tfCustomerLastName != null : "fx:id=\"tfCustomerLastName\" was not injected: check your FXML file 'dialog-view.fxml'.";
        assert tfCustomerAddress != null : "fx:id=\"tfCustomerAddress\" was not injected: check your FXML file 'dialog-view.fxml'.";
        assert tfCity != null : "fx:id=\"tfCity\" was not injected: check your FXML file 'dialog-view.fxml'.";
        assert tfProvince != null : "fx:id=\"tfProvince\" was not injected: check your FXML file 'dialog-view.fxml'.";
        assert tfPostal != null : "fx:id=\"tfPostal\" was not injected: check your FXML file 'dialog-view.fxml'.";
        assert tfCountry != null : "fx:id=\"tfCountry\" was not injected: check your FXML file 'dialog-view.fxml'.";
        assert tfHomePhone != null : "fx:id=\"tfHomePhone\" was not injected: check your FXML file 'dialog-view.fxml'.";
        assert tfBusPhone != null : "fx:id=\"tfBusPhone\" was not injected: check your FXML file 'dialog-view.fxml'.";
        assert tfCustEmail != null : "fx:id=\"tfBusPhone\" was not injected: check your FXML file 'dialog-view.fxml'.";
        assert tfAgentId != null : "fx:id=\"tfBusPhone\" was not injected: check your FXML file 'dialog-view.fxml'.";

        btnSave.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                buttonSaveClicked();
                closeStage(mouseEvent);
            }
        });

        btnDelete.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                buttonDeleteClicked();
                closeStage(mouseEvent);
            }
        });

        btnCancel.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                closeStage(mouseEvent);
            }
        });
    }

    private void buttonSaveClicked(){
        int nrRows = 0;
        Customers customer = collectCustomer();

        try{
            if(mode.equals("Add")){
                dbService.insertData(customer);
            }
            else{ // Edit
                nrRows = dbService.updateCustomer(customer.getCustomerId(), customer);
            }
        }
        catch(SQLIntegrityConstraintViolationException e){
            displayAlert(Alert.AlertType.ERROR, "This customer does not exist.");
            return;
        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }

        if(nrRows == 0){
            displayAlert(Alert.AlertType.ERROR, "");
        }
        else{
            displayAlert(Alert.AlertType.CONFIRMATION, "");
        }
    }

        public void buttonDeleteClicked() {
            int nrRows = 0;
            mode = "Delete";
            int CustomerId = Integer.parseInt(tfCustomerId.getText());
            try{
                nrRows = dbService.deleteCustomer(CustomerId);
            }
            catch(SQLIntegrityConstraintViolationException e){
                displayAlert(Alert.AlertType.ERROR, "Cannot delete customer");
                return;
            }
            catch(SQLException e){
                throw new RuntimeException();
            }

            if(nrRows == 0){
                displayAlert(Alert.AlertType.ERROR, "");
            }
            else{
                displayAlert(Alert.AlertType.CONFIRMATION, "");
            }
        }

    // close the window
    private void closeStage(MouseEvent mouseEvent) {
        Node node = (Node) mouseEvent.getSource();
        Stage stage = (Stage)node.getScene().getWindow();
        stage.close();
    }

    //probably going to need this to make the page more dynamic but for now the only mode is add
    public void setMode(String mode) {
        this.mode = mode;
        lblMode.setText(mode + "Customer:");
        // adjust visibility of Delete button
        if(mode.equals("Add")){
            btnDelete.setVisible(false);
        }
        else{
            btnDelete.setVisible(true);
        }
    }

    //error checking and alerts
    private void displayAlert(Alert.AlertType t, String msg){
        Alert alert = new Alert(t);
        String content = "";
        if(t == Alert.AlertType.ERROR){
            alert.setHeaderText("Database Operation Error");
            content = mode + " Failed";
        } else if( t == Alert.AlertType.CONFIRMATION) {
            alert.setHeaderText("Database Operation Confirmed");
            content = mode + " Successful";
        }
        if(!msg.isEmpty()){
            content += "\n" + msg;
        }
        alert.setContentText(content);
        alert.showAndWait();
    }

    private Customers collectCustomer() {
        String customerId = "0";
        if(!tfCustomerId.getText().isEmpty()){ // if not empty
            customerId = tfCustomerId.getText();
        }
        return new Customers(
                Integer.parseInt(customerId),
                tfCustomerFirstName.getText(),
                tfCustomerLastName.getText(),
                tfCustomerAddress.getText(),
                tfCity.getText(),
                tfProvince.getText(),
                tfPostal.getText(),
                tfCountry.getText(),
                tfHomePhone.getText(),
                tfBusPhone.getText(),
                tfCustEmail.getText(),
                Integer.parseInt(tfAgentId.getText())
        );

    }

    public void displayCustomer(Customers customer){ // public because called from the main controller
        tfCustomerId.setText(customer.getCustomerId() + "");
        tfCustomerFirstName.setText(customer.getCustFirstName());
        tfCustomerLastName.setText(customer.getCustLastName());
        tfCustomerAddress.setText(customer.getCustAddress());
        tfCity.setText(customer.getCustCity());
        tfProvince.setText(customer.getCustProv());
        tfPostal.setText(customer.getCustPostal());
        tfCountry.setText(customer.getCustCountry());
        tfHomePhone.setText(customer.getCustHomePhone());
        tfBusPhone.setText(customer.getCustBusPhone());
        tfCustEmail.setText(customer.getCustEmail());
        tfAgentId.setText(customer.getAgentId() + "");

    }
}
