package GUI;

import Fachlogik.Audio;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class AudioErfassungView extends Stage {

    public AudioErfassungView(Stage stage, Audio audio)
    {
        this.initOwner(stage);
        this.initModality(Modality.WINDOW_MODAL);
    }

}
