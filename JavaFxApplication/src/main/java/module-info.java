module com.javamasterclass.javafxapplication {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.javamasterclass.javafxapplication to javafx.fxml;
    exports com.javamasterclass.javafxapplication;
}