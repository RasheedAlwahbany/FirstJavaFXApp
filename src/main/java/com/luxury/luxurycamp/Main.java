package com.luxury.luxurycamp;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("luxurycamp.fxml"));
//        Scene scene = new Scene(fxmlLoader.load(), 450.0, 260.0);
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Login");
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();
    }

    public void changeScene(String fxml, String title, ActionEvent actionEvent) throws IOException {
        Parent fxmlLoader = FXMLLoader.load(getClass().getResource(fxml));
        Stage stage = new Stage();
        stage.setTitle(title);
        stage.show();
        ((Node)(actionEvent.getSource())).getScene().getWindow().hide();
    }

    public static void main(String[] args) {
        launch();
    }
}