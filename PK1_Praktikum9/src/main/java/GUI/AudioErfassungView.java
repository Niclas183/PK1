package GUI;

import Fachlogik.Audio;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
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

    private Audio audio;
    private boolean create = true;

    public AudioErfassungView(Stage stage, Audio audio)
    {
        this.audio=audio;
        this.initOwner(stage);
        this.initModality(Modality.WINDOW_MODAL);
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
        Label labelInterpret = new Label("Interpret");
        GridPane.setHalignment(labelInterpret, HPos.RIGHT);
        Label labelAufnahmejahr = new Label("Aufnahmejahr:");
        GridPane.setHalignment(labelAufnahmejahr, HPos.RIGHT);
        Label labelDauer = new Label("Dauer:");
        GridPane.setHalignment(labelDauer, HPos.RIGHT);
        TextField textFieldTitel;
        TextField textFieldInterpret;
        TextField textFieldAufnahmejahr;
        TextField textFieldDauer;
        if(audio!=null)
        {
            textFieldTitel = new TextField(audio.getTitel());
            textFieldInterpret = new TextField(audio.getInterpret());
            textFieldAufnahmejahr = new TextField(Integer.toString(audio.getJahr()));
            textFieldDauer = new TextField(Integer.toString(audio.getDauer()));
        }
        else
        {
            textFieldTitel = new TextField();
            textFieldInterpret = new TextField();
            textFieldAufnahmejahr = new TextField();
            textFieldDauer = new TextField();
        }
        Button buttonNeu = new Button("Neu");
        buttonNeu.setOnAction(new EventHandler<ActionEvent>()
        {
            @Override
            public void handle(ActionEvent actionEvent) {
                if(audio!=null)
                {
                    audio.setInterpret(textFieldInterpret.getText());
                    audio.setTitel(textFieldTitel.getText());
                    try{
                        audio.setJahr(Integer.parseInt(textFieldAufnahmejahr.getText()));
                    }
                    catch(NumberFormatException e)
                    {
                        MessageView mv = MessageView.create(s,"Fehler!","Fehler beim Attribut \"Jahr\"!");
                        mv.showView();
                    }
                    try{
                        audio.setDauer(Integer.parseInt(textFieldDauer.getText()));
                        s.close();
                    }
                    catch(NumberFormatException e)
                    {
                        MessageView mv = MessageView.create(s,"Fehler!","Fehler beim Attribut \"Dauer\"!");
                        mv.showView();
                    }
                }
            }
        });
        Button buttonAbbrechen = new Button("Abbrechen");
        buttonAbbrechen.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                create=false;
                AudioErfassungView.this.close();
            }
        });
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
        this.showAndWait();
        return create;
    }

}
