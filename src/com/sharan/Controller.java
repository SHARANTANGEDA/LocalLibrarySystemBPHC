package com.sharan;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.BorderPane;


import static com.sharan.Main.fileName;

public class Controller {


    @FXML
    protected BorderPane rootPane;

    @FXML
    protected BorderPane adminSignIn;

    @FXML
    protected BorderPane librarianSignIn;

    @FXML
    protected BorderPane adminSection;

    @FXML
    protected BorderPane librarianSection;




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
        librarianSection= FXMLLoader.load(getClass().getResource(fileName));
        librarianSignIn.getChildren().setAll(librarianSection);
    }

    @FXML
    public void handleButtonClickReturntoMainMenu(ActionEvent event) throws Exception {
        fileName = "mainWindow.fxml";
        BorderPane pane = FXMLLoader.load(getClass().getResource(fileName));
        adminSignIn.getChildren().setAll(pane);
    }




}



