package GUI;

import Fachlogik.Bild;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
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

    private Bild bild;
    private boolean create = true;

    public BildErfassungView(Stage stage, Bild bild)
    {
        this.initOwner(stage);
        this.initModality(Modality.WINDOW_MODAL);
        this.bild=bild;
    }

    public boolean showView()
    {
        Stage s = this;
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
        TextField textFieldTitel;
        TextField textFieldOrt;
        TextField textFieldAufnahmejahr;
        if(bild!=null) {
            textFieldTitel = new TextField(bild.getTitel());
            textFieldOrt = new TextField(bild.getOrt());
            textFieldAufnahmejahr = new TextField(Integer.toString(bild.getJahr()));
        }
        else {
            textFieldTitel = new TextField();
            textFieldOrt = new TextField();
            textFieldAufnahmejahr = new TextField();
        }
        Button buttonNeu = new Button("Neu");
        buttonNeu.setOnAction(new EventHandler<ActionEvent>()
        {
            @Override
            public void handle(ActionEvent actionEvent) {
                if(bild!=null)
                {
                    bild.setOrt(textFieldOrt.getText());
                    bild.setTitel(textFieldTitel.getText());
                    try{
                        bild.setJahr(Integer.parseInt(textFieldAufnahmejahr.getText()));
                        s.close();
                    }
                    catch(NumberFormatException e)
                    {
                        MessageView mv = MessageView.create(s,"Fehler!","Fehler beim Attribut \"Jahr\"!");
                        mv.showView();
                    }
                }
            }
        });
        GridPane.setHalignment(buttonNeu,HPos.CENTER);
        Button buttonAbbrechen = new Button("Abbrechen");
        buttonAbbrechen.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                create=false;
                s.close();
            }
        });
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
        this.showAndWait();
        return create;
    }

}
