module com.javamasterclass.todolist {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.javamasterclass.todolist to javafx.fxml;
    exports com.javamasterclass.todolist;
}