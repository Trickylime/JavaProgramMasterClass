package com.javamasterclass.mycontacts;

import com.javamasterclass.mycontacts.datamodel.ContactData;
import com.javamasterclass.mycontacts.datamodel.ContactItem;
import javafx.application.Platform;
import javafx.event.ActionEvent;
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
        contactsTableView.getSelectionModel().selectFirst();
        rightClickMenuItems();
    }

    public void setContacts() {
        contactsTableView.setItems(ContactData.getInstance().getContacts());
    }

    public void rightClickMenuItems() {
        listContextMenu = new ContextMenu();

        MenuItem editMenuItem = new MenuItem("Edit");
        editMenuItem.setOnAction((ActionEvent event) -> {
            editItem(contactsTableView.getSelectionModel().getSelectedItem());
        });

        MenuItem deleteMenuItem = new MenuItem("Delete");
        deleteMenuItem.setOnAction((ActionEvent event) -> {
            deleteItem(contactsTableView.getSelectionModel().getSelectedItem());
        });

        listContextMenu.getItems().addAll(editMenuItem, deleteMenuItem);
        contactsTableView.setContextMenu(listContextMenu);
    }

    @FXML
    public void deleteItem(ContactItem item) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Delete Contact Item");
        alert.setHeaderText("Delete item: " + item.getFirstName() + " " + item.getLastName() + "?");
        alert.setContentText("Are you sure? Press OK to confirm, or cancel");
        Optional<ButtonType> result = alert.showAndWait();

        if (result.isPresent() && result.get() == ButtonType.OK) {
            ContactData.getInstance().deleteContact(item);
        }
    }

    @FXML
    public void editItem(ContactItem item) {
        showItemDialog("EDIT");
    }

    @FXML
    public void showItemDialog(String newEditView) {
        newEditView = newEditView.toUpperCase();
        Dialog<ButtonType> dialog = new Dialog<>();
        dialog.initOwner(mainBorderPane.getScene().getWindow());

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(
                switch(newEditView.toUpperCase()) {
                    case "NEW", "EDIT" -> "newContactItemDialog.fxml";
                    case "VIEW" -> "contactItemDialog.fxml";
                    default ->  throw new IllegalArgumentException("Invalid dialog type: " + newEditView);
                }));

        try {
            dialog.getDialogPane().setContent(fxmlLoader.load());
        } catch (IOException e) {
            System.out.println("Couldn't load the dialog");
            e.printStackTrace();
            return;
        }

        dialog.getDialogPane().getButtonTypes().add(ButtonType.OK);
        dialog.getDialogPane().getButtonTypes().add(ButtonType.CANCEL);

        DialogController controller = fxmlLoader.getController();
        
        switch (newEditView) {
            case "NEW" -> {
                dialog.setTitle("Add New Contact");
                Optional<ButtonType> result = dialog.showAndWait();

                if (result.isPresent() && result.get() == ButtonType.OK) {
                    ContactItem newItem = controller.processNewItem();
                    contactsTableView.getSelectionModel().select(newItem);
                }
            }
            case "EDIT" -> {
                dialog.setTitle("Edit Contact");
                ContactItem item = contactsTableView.getSelectionModel().getSelectedItem();
                controller.editItemDetails(item);
                Optional<ButtonType> result = dialog.showAndWait();

                if (result.isPresent() && result.get() == ButtonType.OK) {
                    controller.processEditItem(item);
                    contactsTableView.refresh();
                }
            }
            default -> {
                dialog.setTitle("Contact");
                controller.viewItemDetails(contactsTableView.getSelectionModel().getSelectedItem());
                dialog.showAndWait();
            }
        }
    }

    @FXML
    public void handleDelKeyPressed(KeyEvent keyEvent) {
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


    public void showNewItemDialog() {
        showItemDialog("NEW");
    }

    public void showEditItemDialog() {
        showItemDialog("EDIT");
    }

    public void showItemDialog() {
        showItemDialog("VIEW");
    }

    public void showDeleteItemDialog() {
        deleteItem(contactsTableView.getSelectionModel().getSelectedItem());
    }
}