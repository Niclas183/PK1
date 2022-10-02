package GUI;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        BorderPane bp = new BorderPane();
        MenuBar mb = new MenuBar();
        Menu menuDatei = new Menu("Datei");
        MenuItem menuLaden = new MenuItem("Laden");
        MenuItem menuSpeichern = new MenuItem("Speichern");
        MenuItem menuMedienlisteInDatei = new MenuItem("Medienliste in Datei");
        MenuItem menuBeenden = new MenuItem("Beenden");
        menuDatei.getItems().addAll(menuLaden,menuSpeichern,new SeparatorMenuItem(),menuMedienlisteInDatei,new SeparatorMenuItem(),menuBeenden);
        Menu menuMedium = new Menu("Medium");
        MenuItem menuAudioNeu = new MenuItem("Audio Neu");
        MenuItem menuBildNeu = new MenuItem("Bild neu");
        menuMedium.getItems().addAll(menuAudioNeu,menuBildNeu);
        Menu menuAnzeige = new Menu("Anzeige");
        MenuItem menuErscheinungsjahr = new MenuItem("Erscheinungsjahr");
        MenuItem menuNeuestesMedium = new MenuItem("Neuestes Medium");
        menuAnzeige.getItems().addAll(menuErscheinungsjahr,menuNeuestesMedium);
        mb.getMenus().addAll(menuDatei,menuMedium,menuAnzeige);
        bp.setTop(mb);
        Scene scene = new Scene(bp, 320, 240);
        stage.setTitle("Medienverwaltung");
        stage.setScene(scene);
        stage.show();
        BildErfassungView bildStage = new BildErfassungView(stage, null);
        bildStage.showView();
        AudioErfassungView audioStage = new AudioErfassungView(stage, null);
        audioStage.showView();
       }

    public static void main(String[] args) {
        launch();
    }
}