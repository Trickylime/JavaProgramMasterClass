package com.javamasterclass.mycontacts;

import com.javamasterclass.mycontacts.datamodel.ContactData;
import com.javamasterclass.mycontacts.datamodel.ContactItem;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class DialogController {

    @FXML
    private TextField firstNameField;
    @FXML
    private TextField lastNameField;
    @FXML
    private TextField phoneNumberField;
    @FXML
    private TextArea notesAreaField;

    @FXML
    private Label firstName;
    @FXML
    private Label lastName;
    @FXML
    private Label phoneNumber;
    @FXML
    private Label notes;

    public ContactItem processResults() {
        String firstName = firstNameField.getText().trim();
        String secondName = lastNameField.getText().trim();
        String phoneNumber = phoneNumberField.getText().trim();
        String notes = notesAreaField.getText().trim();

        ContactItem newItem = (new ContactItem(firstName, secondName, phoneNumber, notes));
        ContactData.getInstance().addContact(newItem);
        return newItem;
    }

    public void setItemDetails(ContactItem item) {
        firstName.setText(item.getFirstName());
        lastName.setText(item.getLastName());
        phoneNumber.setText(item.getPhoneNumber());
        notes.setText(item.getNotes());
    }
}
