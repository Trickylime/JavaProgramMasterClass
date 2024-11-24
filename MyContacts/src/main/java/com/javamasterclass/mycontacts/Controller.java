package com.javamasterclass.mycontacts;

import com.javamasterclass.mycontacts.datamodel.ContactData;
import com.javamasterclass.mycontacts.datamodel.ContactItem;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.input.MouseEvent;

public class Controller {
    @FXML
    private TableView<ContactItem> tableView;
    @FXML
    private TableColumn<ContactItem, String> firstNameColumn;
    @FXML
    private TableColumn<ContactItem, String> lastNameColumn;
    @FXML
    private TableColumn<ContactItem, String> phoneNumberColumn;
    @FXML
    private TableColumn<ContactItem, String> notesColumn;

    @FXML
    private TableView<ContactItem> contactsTableView;

    @FXML
    public void initialize() {
        contactsTableView.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);

        var data = ContactData.getInstance().getContacts();

        contactsTableView.setItems(data);

        EventHandler<? super MouseEvent> eventHandler = new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                System.out.println("Selected: " + contactsTableView.getSelectionModel().getSelectedItem());
            }
        };
        contactsTableView.setOnMouseClicked(eventHandler);



        if(true)
            return;
    }


    @FXML
    public void handleExit(ActionEvent actionEvent) {
        Platform.exit();
    }
}