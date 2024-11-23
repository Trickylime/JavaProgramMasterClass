module com.javamasterclass.mycontacts {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.xml;


    opens com.javamasterclass.mycontacts to javafx.fxml;
    exports com.javamasterclass.mycontacts;
    exports com.javamasterclass.mycontacts.datamodel;
    opens com.javamasterclass.mycontacts.datamodel to javafx.fxml;
}