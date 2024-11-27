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
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;

import java.io.IOException;
import java.util.Optional;

public class Controller {
    @FXML
    public BorderPane mainBorderPane;
    @FXML
    private TableView<ContactItem> contactsTableView;

    @FXML
    public void initialize() {
        contactsTableView.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        contactsTableView.setItems(ContactData.getInstance().getContacts());
        contactsTableView.getSelectionModel().selectFirst();

        handRightClickMenuItems();
        handleDoubleClickItems();
    }

    public void handRightClickMenuItems() {
        ContextMenu listContextMenu = new ContextMenu();

        MenuItem editMenuItem = new MenuItem("Edit");
        editMenuItem.setOnAction((ActionEvent event) -> {
            showEditItemDialog();
        });

        MenuItem deleteMenuItem = new MenuItem("Delete");
        deleteMenuItem.setOnAction((ActionEvent event) -> {
            deleteItem(contactsTableView.getSelectionModel().getSelectedItem());
        });

        listContextMenu.getItems().addAll(editMenuItem, deleteMenuItem);
        contactsTableView.setContextMenu(listContextMenu);
    }

    @FXML
    public void handleDoubleClickItems() {
        contactsTableView.setOnMouseClicked((MouseEvent event) -> {
            if (event.getButton().equals(MouseButton.PRIMARY) && event.getClickCount() == 2){
                showItemDialog();
            }
        });
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
    public void itemDialog(String newEditView) {
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
        ContactItem item = contactsTableView.getSelectionModel().getSelectedItem();
        
        switch (newEditView) {
            case "NEW" -> {
                dialog.setTitle("Add New Contact");
                dialog.setHeaderText("Enter your new contact details:");
                Optional<ButtonType> result = dialog.showAndWait();

                if (result.isPresent() && result.get() == ButtonType.OK) {
                    ContactItem newItem = controller.processNewItem();
                    contactsTableView.getSelectionModel().select(newItem);
                }
            }
            case "EDIT" -> {
                dialog.setTitle("Edit Contact");
                dialog.setHeaderText("Edit your contact details:");
                controller.editItemDetails(item);

                Optional<ButtonType> result = dialog.showAndWait();

                if (result.isPresent() && result.get() == ButtonType.OK) {
                    controller.processEditItem(item);
                    contactsTableView.refresh();
                }
            }
            default -> {
                dialog.setTitle("Contact");

                controller.viewItemDetails(item);

                ButtonType editButtonType = new ButtonType("EDIT");
                ButtonType deleteButtonType = new ButtonType("DELETE");
                dialog.getDialogPane().getButtonTypes().addAll(editButtonType, deleteButtonType);

                Optional<ButtonType> result = dialog.showAndWait();
                if (result.isPresent() && result.get() == editButtonType) {
                    showEditItemDialog();
                } else if (result.isPresent() && result.get() == deleteButtonType) {
                    deleteItem(item);
                }
            }
        }
    }

    @FXML
    public void handleExit(ActionEvent actionEvent) {
        Platform.exit();
    }

    public void showNewItemDialog() {
        itemDialog("NEW");
    }

    public void showEditItemDialog() {
        itemDialog("EDIT");
    }

    public void showItemDialog() {
        itemDialog("VIEW");
    }

    public void showDeleteItemDialog() {
        deleteItem(contactsTableView.getSelectionModel().getSelectedItem());
    }
}