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
    public void handleButtonClickAddLibrarian(ActionEvent event) throws Exception {
        fileName = "adminOptions/addLibrarian/addLibrarian.fxml";
        addLibrarian = FXMLLoader.load(getClass().getResource(fileName));
        adminSection.getChildren().setAll(addLibrarian);
    }

    @FXML
    public void handleButtonClickDeleteLibrarian(ActionEvent event) throws Exception {
        fileName="adminOptions/deleteLibrarian/deleteLibrar.fxml";
        deleteLibrarian=FXMLLoader.load(getClass().getResource(fileName));
        adminSection.getChildren().setAll(deleteLibrarian);
    }

    @FXML public void handleButtonClickLogout(ActionEvent event) throws Exception {
        fileName="adminLoginPage.fxml";
        adminSignIn=FXMLLoader.load(getClass().getResource(fileName));
        adminSection.getChildren().setAll(adminSignIn);
    }
}
