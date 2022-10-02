package GUI;

import Datenhaltung.PersistenzException;
import Datenhaltung.SerializableIDao;
import Fachlogik.*;
import javafx.application.Application;
import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Menu;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import javax.swing.*;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.function.IntUnaryOperator;

public class MainMenu extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        Medienverwaltung m = new Medienverwaltung();
        ListView<Medium> lv = new ListView<>();
        BorderPane bp = new BorderPane();
        MenuBar mb = new MenuBar();
        Menu menuDatei = new Menu("Datei");
        MenuItem menuLaden = new MenuItem("Laden");
        menuLaden.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                InputView iv = InputView.create(stage, "Medienliste Laden","Bitte Speicherort eingeben","");
                String speicherort = iv.showView();
                if(speicherort!=null && !speicherort.equals("")) {
                    try {
                        m.laden(new SerializableIDao(speicherort));
                        lv.getItems().clear();
                        Iterator<Medium> i = m.iterator();
                        while (i.hasNext())
                            lv.getItems().add(i.next());
                    } catch (PersistenzException e) {
                        MessageView mv = MessageView.create(stage, "Error", "Fehler beim einlesen der Liste! Eventuell ungültiger Pfad!");
                        mv.showView();
                    }
                }
                else if(speicherort!=null && speicherort.equals("")){
                    MessageView mv = MessageView.create(stage, "Fehler", "Speicherort Leer!");
                    mv.showView();
                }
            }
        });
        MenuItem menuSpeichern = new MenuItem("Speichern");
        menuSpeichern.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                InputView iv = InputView.create(stage, "Medienliste speichern","Bitte Speicherort eingeben","");
                String speicherort = iv.showView();
                if(speicherort!=null && !speicherort.equals("")) {
                    try {
                        m.speichern(new SerializableIDao(speicherort));
                    } catch (PersistenzException e) {
                        MessageView mv = MessageView.create(stage, "Error", "Fehler beim einlesen der Liste! Eventuell ungültiger Pfad!");
                        mv.showView();
                    }
                }
                else if(speicherort!=null && speicherort.equals("")){
                    MessageView mv = MessageView.create(stage, "Fehler", "Speicherort Leer!");
                    mv.showView();
                }
            }
        });
        MenuItem menuMedienlisteInDatei = new MenuItem("Medienliste in Datei");
        menuMedienlisteInDatei.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                InputView iv = InputView.create(stage, "Medienliste in Datei","Bitte Speicherort eingeben","");
                String speicherort = iv.showView();
                if(speicherort!=null && !speicherort.equals("")) {
                    try {
                        m.writeInFile(speicherort);
                    } catch (IOException e) {
                        MessageView mv = MessageView.create(stage, "Error", "Fehler beim Speichern der Datei! Eventuell ungültiger Pfad!");
                        mv.showView();
                    }
                }
                else if(speicherort!=null && speicherort.equals("")){
                    MessageView mv = MessageView.create(stage, "Fehler", "Speicherort Leer!");
                    mv.showView();
                }
            }
        });
        MenuItem menuBeenden = new MenuItem("Beenden");
        menuBeenden.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                stage.close();
            }
        });
        menuDatei.getItems().addAll(menuLaden,menuSpeichern,new SeparatorMenuItem(),menuMedienlisteInDatei,new SeparatorMenuItem(),menuBeenden);
        Menu menuMedium = new Menu("Medium");
        MenuItem menuAudioNeu = new MenuItem("Audio Neu");
        menuAudioNeu.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                Audio a = new Audio();
                AudioErfassungView audioStage = new AudioErfassungView(stage, a);
                if(audioStage.showView())
                {
                    a.setMedienverwaltung(m);
                    m.aufnehmen(a);
                    lv.getItems().add(a);
                }
                else{
                    Medium.setNumM(Medium.getNumM()-1);
                }
            }
        });
        MenuItem menuBildNeu = new MenuItem("Bild neu");
        menuBildNeu.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                Bild b = new Bild();
                BildErfassungView bildstage = new BildErfassungView(stage,b);
                if(bildstage.showView())
                {
                    b.setMedienverwaltung(m);
                    m.aufnehmen(b);
                    lv.getItems().add(b);
                }
                else{
                    Medium.setNumM(Medium.getNumM()-1);
                }
            }
        });
        menuMedium.getItems().addAll(menuAudioNeu,menuBildNeu);
        Menu menuAnzeige = new Menu("Anzeige");
        MenuItem menuErscheinungsjahr = new MenuItem("Erscheinungsjahr");
        menuErscheinungsjahr.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                MessageView mv = MessageView.create(stage,"Erscheinungsjahr","Durchschnittliches Erscheinungsjahr: " + m.berechneErscheinungsjahr());
                mv.showView();
            }
        });
        MenuItem menuNeuestesMedium = new MenuItem("Neuestes Medium");
        menuNeuestesMedium.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                Medium neu = m.sucheNeuesMedium();
                MessageView mv;
                if(neu!=null)
                    mv = MessageView.create(stage,"Neuestes Medium",neu.toString());
                else
                    mv = MessageView.create(stage,"Neuestes Medium","Liste leer!");
                mv.showView();
            }
        });
        menuAnzeige.getItems().addAll(menuErscheinungsjahr,menuNeuestesMedium);
        mb.getMenus().addAll(menuDatei,menuMedium,menuAnzeige);
        bp.setTop(mb);
        bp.setCenter(lv);
        Scene scene = new Scene(bp, 320, 240);
        stage.setTitle("Medienverwaltung");
        stage.setScene(scene);
        stage.show();
       }

    public static void main(String[] args) {
        launch();
    }
}