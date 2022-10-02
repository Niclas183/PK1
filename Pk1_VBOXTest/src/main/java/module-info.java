module com.example.pk1_vboxtest {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.pk1_vboxtest to javafx.fxml;
    exports com.example.pk1_vboxtest;
}