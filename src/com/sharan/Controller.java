package com.sharan;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;

import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Paint;
import org.w3c.dom.Text;

import static com.sharan.Main.fileName;

public class Controller {


    @FXML
    private BorderPane rootPane;

    @FXML
    private BorderPane adminSignIn;

    @FXML
    private BorderPane librarianSignIn;

    @FXML
    private BorderPane adminSection;

    @FXML
    private BorderPane addLibrarian;


    @FXML
    public void initialize() {

    }


    @FXML
    public void handleButtonClickAdmin(ActionEvent event) throws Exception {
        fileName = "admin/adminLoginPage.fxml";
        adminSignIn = FXMLLoader.load(getClass().getResource(fileName));
        rootPane.getChildren().add(adminSignIn);
        rootPane.getChildren().setAll(adminSignIn);
    }

    @FXML
    public void handleButtonClickLibrarian(ActionEvent event) throws Exception {
        fileName = "librarian/librarianLoginPage.fxml";
        librarianSignIn = FXMLLoader.load(getClass().getResource(fileName));
        rootPane.getChildren().add(librarianSignIn);
        rootPane.getChildren().setAll(librarianSignIn);
    }

    @FXML
    public void handleButtonClickAdminSignIn(ActionEvent event) throws Exception {
        fileName = "admin/adminSection.fxml";
        adminSection = FXMLLoader.load(getClass().getResource(fileName));
        adminSignIn.getChildren().setAll(adminSection);
    }

    @FXML
    public void handleButtonClickLibrarianSignIn(ActionEvent event) throws Exception {
        fileName = "librarian/librarianSection.fxml";
        BorderPane pane = FXMLLoader.load(getClass().getResource(fileName));
        librarianSignIn.getChildren().setAll(pane);
    }

    @FXML
    public void handleButtonClickReturntoMainMenu(ActionEvent event) throws Exception {
        fileName = "mainWindow.fxml";
        BorderPane pane = FXMLLoader.load(getClass().getResource(fileName));
        adminSignIn.getChildren().setAll(pane);
    }

    @FXML
    public void handleButtonClickAddLibrarian(ActionEvent event) throws Exception {
        fileName = "admin/adminOptions/addLibrarian.fxml";
        addLibrarian = FXMLLoader.load(getClass().getResource(fileName));
//        adminSection.getChildren().add(addLibrarian);
        adminSection.getChildren().setAll(addLibrarian);
    }

    @FXML
    private TextField nameField;

    @FXML
    private TextField passwordField;

    @FXML
    private TextField emailField;

    @FXML
    private TextField addressField;

    @FXML
    private TextField cityField;

    @FXML
    private TextField numberField;

    @FXML
    private Label alertLabel;

    public boolean checkEnteredDetails() {
        String name;
        String password;
        String email;
        String address;
        String city;
        boolean checker;
        int contact;
        name = nameField.getText().trim();
        password = passwordField.getText().trim();
        email = emailField.getText().trim();
        address = addressField.getText().trim();
        city = cityField.getText().trim();
        if (numberField.getText().trim().isEmpty()) {
            checker = false;
        } else {
            contact = Integer.parseInt(numberField.getText().trim());
            checker = true;
        }
        if ((!name.isEmpty()) && (!password.isEmpty()) && (!email.isEmpty()) && (!address.isEmpty()) && (!city.isEmpty()) && (checker)) {
            return true;
        } else {
            return false;
        }
    }

    @FXML
    public void handleButtonClickConfirmAddLibrarian(ActionEvent event) throws Exception {
        if (checkEnteredDetails()) {
            String name;
            String password;
            String email;
            String address;
            String city;
            name = nameField.getText().trim();
            password = passwordField.getText().trim();
            email = emailField.getText().trim();
            address = addressField.getText().trim();
            city = cityField.getText().trim();

            DataBaseFields dataBaseFields = new DataBaseFields();
            dataBaseFields.initializeConnection();
            dataBaseFields.addLibrarianDetails(name, password, email, address, city, numberField.getText().trim());


            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Success");
            alert.setHeaderText("Details Successfully added to DataBase");
            alert.showAndWait();
            if (alert.getResult() == ButtonType.OK) {
                alert.close();
                nameField.setText("");
                passwordField.setText("");
                emailField.setText("");
                addressField.setText("");
                cityField.setText("");
                numberField.setText("");
            }


        }else {
            alertLabel.setText("Please Check All The Fields correctly");
            alertLabel.setTextFill(Paint.valueOf("RED"));
        }

    }

    public void handleButtonClickgoBackToAdminOptions(ActionEvent event) throws Exception{
        fileName="admin/adminSection.fxml";
        BorderPane pane = FXMLLoader.load(getClass().getResource(fileName));
        addLibrarian.getChildren().setAll(pane);
    }
}