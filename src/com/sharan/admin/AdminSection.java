package com.sharan.admin;


import com.sharan.Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;

import javafx.scene.layout.BorderPane;

import static com.sharan.Main.fileName;

public class AdminSection extends Controller {



    @FXML
    protected BorderPane addLibrarian;

    @FXML
    protected BorderPane deleteLibrarian;

    @FXML
    protected BorderPane viewLibrarian;






    @FXML
    public void handleButtonClickAddLibrarian(ActionEvent event) throws Exception {
        fileName = "adminOptions/addStudent/addStudent.fxml";
        addLibrarian = FXMLLoader.load(getClass().getResource(fileName));
        adminSection.getChildren().setAll(addLibrarian);
    }

    @FXML
    public void handleButtonClickDeleteLibrarian(ActionEvent event) throws Exception {
        fileName="adminOptions/deleteStudent/deleteStudent.fxml";
        deleteLibrarian=FXMLLoader.load(getClass().getResource(fileName));
        adminSection.getChildren().setAll(deleteLibrarian);
    }

    @FXML
    public void handleButtonClickLogout(ActionEvent event) throws Exception {
        fileName="adminLoginPage.fxml";
        adminSignIn=FXMLLoader.load(getClass().getResource(fileName));
        adminSection.getChildren().setAll(adminSignIn);
    }

    @FXML
    public void handleButtonClickViewLibrarian(ActionEvent event) throws Exception {
        fileName="adminOptions/viewStudent/viewStudent.fxml";
        viewLibrarian=FXMLLoader.load(getClass().getResource(fileName));
        adminSection.getChildren().setAll(viewLibrarian);
    }
}
