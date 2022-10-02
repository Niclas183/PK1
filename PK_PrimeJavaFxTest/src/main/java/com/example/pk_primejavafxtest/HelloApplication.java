package com.example.pk_primejavafxtest;

import javafx.application.Application;
import javafx.concurrent.Task;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        GridPane gp = new GridPane();
        gp.setHgap(10);
        gp.setVgap(10);
        gp.setPadding(new Insets(10));
        gp.setAlignment(Pos.CENTER);
        TextField tf = new TextField();
        HBox hb1 = new HBox(10);
        hb1.getChildren().add(tf);
        hb1.setAlignment(Pos.CENTER);
        Button b1 = new Button("Berechnen");
        HBox hb2 = new HBox(10);
        hb2.getChildren().add(b1);
        hb2.setAlignment(Pos.CENTER);
        ProgressBar pb = new ProgressBar();
        HBox hb3 = new HBox(10);
        hb3.getChildren().add(pb);
        hb3.setAlignment(Pos.CENTER);
        gp.add(hb1,0,0);
        gp.add(hb2,0,1);
        gp.add(hb3,0,2);

        class PrimeTask extends Task<Integer[]> {
            static int RUNNING = 0;
            static int MAX = 8;
            List<Integer> currentRunning = new LinkedList<>();
            Integer[] erg;
            int n;
            int m;

            public PrimeTask(int n, int m)
            {
                this.n=n;
                this.m=m;
                if(RUNNING==0) {
                    erg = new Integer[n];
                    for(int i = 0; i<erg.length; i++)
                        erg[i]=i+2;
                }
            }

            @Override
            protected Integer[] call() throws Exception {
                if (RUNNING == 0) {
                    System.out.println("ERSTER!");
                    RUNNING++;
                    for (int j = 0; j < Math.sqrt(n); j++) {
                        updateProgress((double) j/Math.sqrt(n),1.0);
                        if (erg[j] == 0 || currentRunning.contains(erg[j]))
                            continue;
                        for (int i = j + 1; i < n; i++) {
                            synchronized (erg) {
                                if (erg[i] % erg[j] == 0)
                                    erg[i] = 0;
                                else if (RUNNING < MAX) {
                                    currentRunning.add(erg[i]);
                                    Thread runner = new Thread(new PrimeTask(n, i));
                                    runner.start();
                                }
                            }
                        }
                    }
                }
                else {
                    RUNNING++;
                    for (int i = m + 1; i < n; i++) {
                        synchronized (erg) {
                            System.out.println(this.hashCode());
                            if (erg[i] % erg[m] == 0)
                                erg[i] = 0;
                        }
                    }
                    RUNNING--;
                    System.out.println(this.hashCode() + " ist am Ende");
                    failed();
                }
                RUNNING=0;
                return erg;
            }
        }
        b1.setOnAction(e->{
            hb3.getChildren().clear();
            hb3.getChildren().add(pb);
            Task<Integer[]> task = new PrimeTask(Integer.parseInt(tf.getText()),0);
            pb.progressProperty().bind(task.progressProperty());
            task.setOnSucceeded(v->{
                ListView<Integer> lv = new ListView();
                Integer[] erg = task.getValue();
                for(Integer i: erg)
                {
                    if(i!=0)
                        lv.getItems().add(i);
                }
                hb3.getChildren().clear();
                hb3.getChildren().add(lv);
            });
            Thread runner = new Thread(task);
            runner.setDaemon(true);
            runner.start();
        });
        Scene scene = new Scene(gp, 320, 240);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();

    }

    public static void main(String[] args) {
        launch();
    }
}