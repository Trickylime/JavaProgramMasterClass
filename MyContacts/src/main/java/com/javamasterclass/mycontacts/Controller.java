package com.javamasterclass.mycontacts;

import com.javamasterclass.mycontacts.datamodel.ContactData;
import com.javamasterclass.mycontacts.datamodel.ContactItem;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

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

        contactsTableView.setItems(ContactData.getInstance().getContacts());
    }


    @FXML
    public void handleExit(ActionEvent actionEvent) {
        Platform.exit();
    }
}