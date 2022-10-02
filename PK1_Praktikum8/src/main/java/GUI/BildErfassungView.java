package GUI;

import Fachlogik.Bild;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
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

public class BildErfassungView extends Stage {

    public BildErfassungView(Stage stage, Bild bild)
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
        Label labelOrt = new Label("Ort:");
        GridPane.setHalignment(labelOrt, HPos.RIGHT);
        Label labelAufnahmejahr = new Label("Aufnahmejahr:");
        GridPane.setHalignment(labelAufnahmejahr, HPos.RIGHT);
        TextField textFieldTitel = new TextField();
        TextField textFieldOrt = new TextField();
        TextField textFieldAufnahmejahr = new TextField();
        Button buttonNeu = new Button("Neu");
        GridPane.setHalignment(buttonNeu,HPos.CENTER);
        Button buttonAbbrechen = new Button("Abbrechen");
        GridPane.setHalignment(buttonAbbrechen,HPos.CENTER);
        HBox hb = new HBox();
        hb.setPadding(new Insets(10));
        hb.setSpacing(10);
        hb.setAlignment(Pos.CENTER);
        hb.getChildren().addAll(buttonNeu,buttonAbbrechen);
        ColumnConstraints cc = new ColumnConstraints();
        ColumnConstraints cc2 = new ColumnConstraints();
        cc2.setHgrow(Priority.ALWAYS);
        gp.getColumnConstraints().add(cc);
        gp.getColumnConstraints().add(cc2);
        gp.add(labelTitel,0,0);
        gp.add(textFieldTitel,1,0);
        gp.add(labelOrt,0,1);
        gp.add(textFieldOrt,1,1);
        gp.add(labelAufnahmejahr,0,2);
        gp.add(textFieldAufnahmejahr,1,2);
        gp.add(hb,0,3,2,1);
        Scene scene = new Scene(gp,500,165);
        this.setScene(scene);
        this.setTitle("Bilderfassung");
        this.setResizable(false);
        this.show();
    }


}
