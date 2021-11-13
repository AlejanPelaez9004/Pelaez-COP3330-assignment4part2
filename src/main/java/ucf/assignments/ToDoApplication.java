/*
 *  UCF COP3330 Fall 2021 Assignment 4 Solution
 *  Copyright 2021 Alejandro Pelaez
 */
package ucf.assignments;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class ToDoApplication extends Application {
    private Stage primaryStage;
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(ToDoApplication.class.getResource("ItemView.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("To-do List Manager");
        stage.setScene(scene);
        stage.show();
        primaryStage = stage;
    }

    public Stage GetPrimaryStage()
    {
        return primaryStage;
    }

    public static void main(String[] args) {
        launch();
    }
}