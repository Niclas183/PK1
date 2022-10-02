module com.example.pk1_praktikum7 {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;


    opens GUI to javafx.fxml;
    exports GUI;
    exports Fachlogik;
    opens Fachlogik to javafx.fxml;
}