package GUI;

import Fachlogik.Audio;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class AudioErfassungView extends Stage {

    public AudioErfassungView(Stage stage, Audio audio)
    {
        this.initOwner(stage);
        this.initModality(Modality.WINDOW_MODAL);
    }

    public void showView()
    {
        GridPane gp = new GridPane();
        gp.setHgap(10);
        gp.setVgap(10);
        gp.setPadding(new Insets(10,10,10,10));
        Label labelTitel = new Label("Titel:");
        GridPane.setHalignment(labelTitel, HPos.RIGHT);
        Label labelInterpret = new Label("Interpret");
        GridPane.setHalignment(labelInterpret, HPos.RIGHT);
        Label labelAufnahmejahr = new Label("Aufnahmejahr:");
        GridPane.setHalignment(labelAufnahmejahr, HPos.RIGHT);
        Label labelDauer = new Label("Dauer:");
        GridPane.setHalignment(labelDauer, HPos.RIGHT);
        TextField textFieldTitel = new TextField();
        TextField textFieldInterpret = new TextField();
        TextField textFieldAufnahmejahr = new TextField();
        TextField textFieldDauer = new TextField();
        Button buttonNeu = new Button("Neu");
        Button buttonAbbrechen = new Button("Abbrechen");
        HBox hb = new HBox();
        hb.setPadding(new Insets(10));
        hb.setSpacing(10);
        hb.setAlignment(Pos.CENTER);
        hb.getChildren().addAll(buttonNeu,buttonAbbrechen);
        ColumnConstraints cc = new ColumnConstraints();
        cc.setHgrow(Priority.NEVER);
        ColumnConstraints cc2 = new ColumnConstraints();
        cc2.setHgrow(Priority.ALWAYS);
        gp.getColumnConstraints().add(cc);
        gp.getColumnConstraints().add(cc2);
        gp.add(labelTitel,0,0);
        gp.add(textFieldTitel,1,0);
        gp.add(labelInterpret,0,1);
        gp.add(textFieldInterpret,1,1);
        gp.add(labelAufnahmejahr,0,2);
        gp.add(textFieldAufnahmejahr,1,2);
        gp.add(labelDauer,0,3);
        gp.add(textFieldDauer,1,3);
        gp.add(hb,0,4,2,1);
        Scene scene = new Scene(gp,500,200);
        this.setScene(scene);
        this.setTitle("Audioerfassung");
        this.setResizable(false);
        this.show();
    }

}
