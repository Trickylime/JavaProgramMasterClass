package com.javamasterclass.mycontacts;

import com.javamasterclass.mycontacts.datamodel.ContactData;
import com.javamasterclass.mycontacts.datamodel.ContactItem;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class DialogController {

    @FXML
    private TextField firstNameField;
    @FXML
    private TextField secondNameField;
    @FXML
    private TextField phoneNumberField;
    @FXML
    private TextArea notesAreaField;

    public ContactItem processResults() {
        String firstName = firstNameField.getText().trim();
        String secondName = secondNameField.getText().trim();
        String phoneNumber = phoneNumberField.getText().trim();
        String notes = notesAreaField.getText().trim();

        ContactItem newItem = (new ContactItem(firstName, secondName, phoneNumber, notes));
        ContactData.getInstance().addContact(newItem);
        return newItem;
    }
}
