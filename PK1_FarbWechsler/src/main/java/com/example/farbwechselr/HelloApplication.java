package com.example.farbwechselr;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        BorderPane bp = new BorderPane();
        Pane p = new Pane();
        Rectangle r = new Rectangle();
        r.setX(200);
        r.setY(200);
        r.setHeight(100);
        r.setWidth(100);
        r.setFill(Color.RED);
        p.getChildren().add(r);
        Button b1 = new Button("Farbwechsel");
        b1.setOnAction((a)->{
            int r1 = (int)(Math.random()*255.0);
            int g1 = (int)(Math.random()*255.0);
            int b = (int)(Math.random()*255.0);
            r.setFill(Color.rgb(r1,g1,b));
        });
        BorderPane.setAlignment(b1, Pos.CENTER);
        bp.setPadding(new Insets(10));
        bp.bottomProperty().set(b1);
        bp.setCenter(p);
        Scene scene = new Scene(bp, 500, 500);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}