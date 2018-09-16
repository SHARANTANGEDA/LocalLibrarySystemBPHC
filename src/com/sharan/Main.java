package com.sharan;


import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;


public class Main extends Application {

    public static String fileName="";

    @Override
    public void start(Stage primaryStage) throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("mainWindow.fxml"));
        primaryStage.setTitle("LMS@BPHC");
        primaryStage.setScene(new Scene(root, 700, 500));
        primaryStage.show();
        }

    public static void main(String[] args){
        DataBaseFields dataBaseFields = new DataBaseFields();
        dataBaseFields.initializeConnection();
        dataBaseFields.addLibrarianDetails("Ram","0000","Ram.com","Madhapur","Hyd","9999999999");
        dataBaseFields.deleteLibrarianDetailsById("2");
        dataBaseFields.closeDatabaseConnection();
        launch(args);

    }
}
