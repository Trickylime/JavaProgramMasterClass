package com.javamasterclass.mycontacts;

import com.javamasterclass.mycontacts.datamodel.ContactData;
import com.javamasterclass.mycontacts.datamodel.ContactItem;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.BorderPane;

import java.io.IOException;
import java.util.Optional;

public class Controller {
    @FXML
    public BorderPane mainBorderPane;
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
        setContacts();
    }

    public void setContacts() {
        contactsTableView.setItems(ContactData.getInstance().getContacts());
    }

    @FXML
    public void showNewItemDialog(ActionEvent actionEvent) {
        Dialog<ButtonType> dialog = new Dialog<>();
        dialog.initOwner(mainBorderPane.getScene().getWindow());
        dialog.setTitle("Add New Contact");
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("contactItemDialog.fxml"));

        try {
            dialog.getDialogPane().setContent(fxmlLoader.load());
        } catch (IOException e) {
            System.out.println("Couldn't load the dialog");
            e.printStackTrace();
            return;
        }

        dialog.getDialogPane().getButtonTypes().add(ButtonType.OK);
        dialog.getDialogPane().getButtonTypes().add(ButtonType.CANCEL);

        Optional<ButtonType> result = dialog.showAndWait();
        if (result.isPresent() && result.get() == ButtonType.OK) {
            DialogController controller = fxmlLoader.getController();
            ContactItem newItem = controller.processResults();
            contactsTableView.getSelectionModel().select(newItem);
        }
    }

    @FXML
    public void handleExit(ActionEvent actionEvent) {
        Platform.exit();
    }


}