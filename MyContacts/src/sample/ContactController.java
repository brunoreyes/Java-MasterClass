package sample;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import sample.datamodel.Contact;

public class ContactController {

    @FXML
    private TextField firstNameField;

    @FXML
    private TextField lastNameField;

    @FXML
    private TextField phoneNumberField;

    @FXML
    private TextField notesField;

    public Contact getNewContact(){
        String firstName = firstNameField.getText();
        String lastName = lastNameField.getText();
        String phoneNumber = phoneNumberField.getText();
        String notes = notesField.getText();

        // Possibly could add validation not allowing the add button to work until all fields are filled
        Contact newContact = new Contact(firstName, lastName, phoneNumber, notes);
        return newContact;
        }

        // Setting the four fields within the dialog
        public void editContact(Contact contact){
            firstNameField.setText(contact.getFirstName());
            lastNameField.setText(contact.getLastName());
            phoneNumberField.setText(contact.getPhoneNumber());
            notesField.setText(contact.getNotes());
        }

        // transferring the values back from the dialog fields back into the contact object
        public void updateContact(Contact contact){
            contact.setFirstName(firstNameField.getText());
            contact.setLastName(lastNameField.getText());
            contact.setPhoneNumber(phoneNumberField.getText());
            contact.setNotes(notesField.getText());
        }
    }

