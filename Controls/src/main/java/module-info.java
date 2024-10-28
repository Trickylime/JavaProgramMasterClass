module com.javamasterclass.controls {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.javamasterclass.controls to javafx.fxml;
    exports com.javamasterclass.controls;
}