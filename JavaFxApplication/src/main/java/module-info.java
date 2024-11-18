module com.javamasterclass.javafxapplication {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;


    opens com.javamasterclass.javafxapplication to javafx.fxml;
    exports com.javamasterclass.javafxapplication;
}