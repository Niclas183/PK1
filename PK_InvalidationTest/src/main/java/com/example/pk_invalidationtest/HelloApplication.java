package com.example.pk_invalidationtest;

import javafx.application.Application;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Collection;
import java.util.List;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        BorderPane bp = new BorderPane();
        HBox hb = new HBox();
        Button b1 = new Button("Farbwechsel");
        Rectangle rec = new Rectangle();
        rec.setHeight(100);
        rec.setWidth(100);
        bp.setPadding(new Insets(10));
        hb.setAlignment(Pos.CENTER);
        hb.getChildren().add(b1);
        bp.setCenter(rec);
        bp.setBottom(hb);
        b1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                int r = (int)(Math.random()*255);
                int g = (int)(Math.random()*255);
                int b = (int)(Math.random()*255);
                rec.setFill(Color.rgb(r,g,b));
            }
        });
        Scene scene = new Scene(bp,300,300);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }

}