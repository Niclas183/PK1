module com.example.pk_primejavafxtest {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.pk_primejavafxtest to javafx.fxml;
    exports com.example.pk_primejavafxtest;
}