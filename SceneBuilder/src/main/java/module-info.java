module com.javamasterclass.scenebuilder {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.javamasterclass.scenebuilder to javafx.fxml;
    exports com.javamasterclass.scenebuilder;
}