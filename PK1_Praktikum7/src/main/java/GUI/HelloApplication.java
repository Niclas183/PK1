package GUI;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        Scene scene = new Scene(new Label("Hallo Welt!"), 320, 240);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
        BildErfassungView bildStage = new BildErfassungView(stage, null);
        bildStage.showView();
       }

    public static void main(String[] args) {
        launch();
    }
}