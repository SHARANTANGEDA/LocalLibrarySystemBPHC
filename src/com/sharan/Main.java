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
        launch(args);

    }
}
