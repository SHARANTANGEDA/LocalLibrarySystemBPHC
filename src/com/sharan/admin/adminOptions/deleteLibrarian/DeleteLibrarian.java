package com.sharan.admin.adminOptions.deleteLibrarian;

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


import java.io.IOException;

import static com.sharan.Main.fileName;


public class DeleteLibrarian extends AdminSection {


    @FXML
    private Label inputAlert;

    @FXML
    private TextField enterID;


    @FXML
    public void handleButtonClickConfirmDelete (ActionEvent event) throws IOException{
        if(enterID.getText().trim().isEmpty()){
            inputAlert.setText("Enter Valid Input");
        }
        else{
            String id = enterID.getText().trim();

            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);

            DataBaseFields dataBaseFields =new DataBaseFields();
            dataBaseFields.initializeConnection();
            alert.setTitle("Do You want delete "+dataBaseFields.getName(id));
            alert.setHeaderText("Select OK to confirm");
            alert.showAndWait();
            if (alert.getResult()== ButtonType.OK){
                dataBaseFields.deleteLibrarianDetailsById(id);
                dataBaseFields.closeDatabaseConnection();
                enterID.setText("");

            }else {
                inputAlert.setText("Didnt delete");
                dataBaseFields.idDecrementer();
                dataBaseFields.closeDatabaseConnection();

            }

        }
    }
    public void handleButtonClickGoBack(ActionEvent event) throws IOException {
        fileName="../../adminSection.fxml";
        BorderPane pane = FXMLLoader.load(getClass().getResource(fileName));
        deleteLibrarian.getChildren().setAll(pane);
    }
}
