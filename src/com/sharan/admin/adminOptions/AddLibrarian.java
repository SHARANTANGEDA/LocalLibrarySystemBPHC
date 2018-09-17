package com.sharan.admin.adminOptions;


import com.sharan.DataBaseFields;
import com.sharan.admin.AdminSection;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Paint;

import static com.sharan.Main.fileName;

public class AddLibrarian extends AdminSection {

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


    private boolean checkEnteredDetails() {
        String name;
        String password;
        String email;
        String address;
        String city;
        boolean checker;
        long contact;
        name = nameField.getText().trim();
        password = passwordField.getText().trim();
        email = emailField.getText().trim();
        address = addressField.getText().trim();
        city = cityField.getText().trim();
        if (numberField.getText().trim().isEmpty()) {
            checker = false;
        } else {
            checker = true;
        }
        if ((!name.isEmpty()) && (!password.isEmpty()) && (!email.isEmpty()) && (!address.isEmpty()) && (!city.isEmpty()) && (checker)) {
            return true;
        } else {
            return false;
        }
    }



    @FXML
    public void handleButtonClickConfirmAddLibrarian(ActionEvent event) {
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
        fileName="../adminSection.fxml";
        BorderPane pane = FXMLLoader.load(getClass().getResource(fileName));
        addLibrarian.getChildren().setAll(pane);
    }

}
