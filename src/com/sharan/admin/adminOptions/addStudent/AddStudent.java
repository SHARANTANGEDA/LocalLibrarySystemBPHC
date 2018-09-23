package com.sharan.admin.adminOptions.addStudent;


import com.sharan.DataBaseFields;
import com.sharan.PasswordHashing;
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

public class AddStudent extends AdminSection {

    @FXML
    private TextField nameField;

    @FXML
    private TextField passwordField;

    @FXML
    private TextField emailField;

    @FXML
    private TextField idNumberField;

    @FXML
    private TextField roomNoField;

    @FXML
    private TextField numberField;

    @FXML
    private Label alertLabel;


    private boolean checkEnteredDetails() {
        String name;
        String password;
        String email;
        String idNumber;
        String roomNo;
        boolean checker;
        name = nameField.getText().trim();
        password = passwordField.getText().trim();
        email = emailField.getText().trim();
        idNumber = idNumberField.getText().trim();
        roomNo = roomNoField.getText().trim();
        if ((numberField.getText().trim().isEmpty())){
            checker = false;
        } else {
            checker = true;
        }
        if ((!name.isEmpty()) && (!password.isEmpty()) && (!email.isEmpty()) && (!idNumber.isEmpty()) && (!roomNo.isEmpty()) && (checker)) {
            if(numberField.getText().trim().matches("[0-9]+")){
                return true;
            }
            else {
                return false;
            }
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
            address = idNumberField.getText().trim();
            city = roomNoField.getText().trim();

            PasswordHashing passwordHashing =new PasswordHashing();
            String str=passwordHashing.hashPassword(password);



            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Success");
            alert.setHeaderText("Details Successfully added to DataBase");
            alert.showAndWait();
            if ((alert.getResult() == ButtonType.OK)) {
                alert.close();
                DataBaseFields dataBaseFields = new DataBaseFields();
                dataBaseFields.initializeConnection();
                dataBaseFields.addLibrarianDetails(name, str, email, address, city, numberField.getText().trim());
                nameField.setText("");
                passwordField.setText("");
                emailField.setText("");
                idNumberField.setText("");
                roomNoField.setText("");
                numberField.setText("");
            }


        }else {
            alertLabel.setText("Please Check All The Fields correctly");
            alertLabel.setTextFill(Paint.valueOf("RED"));
        }

    }
    public void handleButtonClickgoBackToAdminOptions(ActionEvent event) throws Exception{
        fileName="../../adminSection.fxml";
        BorderPane pane = FXMLLoader.load(getClass().getResource(fileName));
        addLibrarian.getChildren().setAll(pane);
    }

}
