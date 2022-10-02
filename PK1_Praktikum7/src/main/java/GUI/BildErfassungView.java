package GUI;

import Fachlogik.Bild;
import javafx.scene.Scene;
import javafx.scene.control.Label;
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
        Label label = new Label("Hallo Welt");
        Scene scene = new Scene(label,500,500);
        this.setScene(scene);
        this.setTitle("Bilderfassung");
        this.show();
    }


}
