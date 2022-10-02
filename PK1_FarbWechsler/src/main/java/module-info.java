module com.example.farbwechselr {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.farbwechselr to javafx.fxml;
    exports com.example.farbwechselr;
}