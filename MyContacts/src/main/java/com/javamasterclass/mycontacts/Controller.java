package com.javamasterclass.mycontacts;

import com.javamasterclass.mycontacts.datamodel.ContactData;
import com.javamasterclass.mycontacts.datamodel.ContactItem;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.*;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
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
    private ContextMenu listContextMenu;

    @FXML
    public void initialize() {
        contactsTableView.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        setContacts();
        menuItems();
    }

    public void setContacts() {
        contactsTableView.setItems(ContactData.getInstance().getContacts());
    }

    public void menuItems() {
        listContextMenu = new ContextMenu();
        MenuItem deleteMenuItem = new MenuItem("Delete");
        deleteMenuItem.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                ContactItem item = contactsTableView.getSelectionModel().getSelectedItem();
                deleteItem(item);
            }
        });
        listContextMenu.getItems().addAll(deleteMenuItem);
        contactsTableView.setContextMenu(listContextMenu);
    }

    @FXML
    public void deleteItem(ContactItem item) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Delete Contact Item");
        alert.setHeaderText("Delete item: " + item.getFirstName() + " " + item.getLastName());
        alert.setContentText("Are you sure? Press OK to confirm, or cancel");
        Optional<ButtonType> result = alert.showAndWait();

        if (result.isPresent() && result.get() == ButtonType.OK) {
            ContactData.getInstance().deleteContact(item);
        }
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
    public void handleKeyPressed(KeyEvent keyEvent) {
        ContactItem selectedItem = contactsTableView.getSelectionModel().getSelectedItem();
        if (selectedItem != null) {
            if (keyEvent.getCode().equals(KeyCode.DELETE)) {
                deleteItem(selectedItem);
            }
        }
    }
    @FXML
    public void handleExit(ActionEvent actionEvent) {
        Platform.exit();
    }


}