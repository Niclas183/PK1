package pk1.pk1_praktikum10_2;

import javafx.application.Application;
import javafx.stage.Stage;

import java.io.IOException;

public class Zeitansage extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        MessageView mv = MessageView.create(stage,"Timer","Timer beenden!");
        Timer timer = new Timer(new TimerListener() {
            int i = 1;
            @Override
            public void signalPerformed() {
                System.out.println(i++ + " Sekunde seit Start");
            }
        });
        Thread t = new Thread(timer);
        t.start();
        mv.showView();
        t.interrupt();
    }

    public static void main(String[] args) {
        launch();
    }
}