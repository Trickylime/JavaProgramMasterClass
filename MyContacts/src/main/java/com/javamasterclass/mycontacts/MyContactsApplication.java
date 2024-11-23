package com.javamasterclass.mycontacts;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class MyContactsApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(MyContactsApplication.class.getResource("mainwindow.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 750, 500);
        stage.setTitle("My Contacts");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}