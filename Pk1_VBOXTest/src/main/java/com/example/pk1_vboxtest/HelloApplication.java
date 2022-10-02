package com.example.pk1_vboxtest;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        VBox vb = new VBox();
        Button b1 = new Button("Button 1");
        Button b2 = new Button("Button 2");
        Button b3 = new Button("Button 3");
        Button b4 = new Button("Button 4");
        Button b5 = new Button("Button 5");
        b1.setPrefWidth(320);
        b2.setPrefWidth(320);
        b3.setPrefWidth(320);
        b4.setPrefWidth(320);
        b5.setPrefWidth(320);
        b1.setPrefHeight(240);
        b2.setPrefHeight(240);
        b3.setPrefHeight(240);
        b4.setPrefHeight(240);
        b5.setPrefHeight(240);
        vb.setSpacing(10);
        vb.setPadding(new Insets(10));
        vb.getChildren().addAll(b1,b2,b3,b4,b5);
        Scene scene = new Scene(vb, 320, 240);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}