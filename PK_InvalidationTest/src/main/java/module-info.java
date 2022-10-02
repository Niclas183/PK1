module com.example.pk_invalidationtest {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.pk_invalidationtest to javafx.fxml;
    exports com.example.pk_invalidationtest;
}