package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.TableView;
import javafx.scene.layout.BorderPane;
import sample.datamodel.Contact;
import sample.datamodel.ContactData;

import java.io.IOException;
import java.util.Optional;

public class Controller {

    @FXML
    private BorderPane mainPanel;

    @FXML
    private TableView<Contact> contactsTable;

    private ContactData data;

    public void initialize(){
        data = new ContactData();
        data.loadContacts();
        contactsTable.setItems(data.getContacts());
    }

    @FXML
    public void showAddContactDialog(){
        Dialog<ButtonType> dialog = new Dialog<ButtonType>(); // created a dialog instance an assigning the main
        dialog.initOwner(mainPanel.getScene().getWindow());         // window as it's parent which is from the
        dialog.setTitle("Add New Contact");                         // borderPane. Dialog's context is that of the
        FXMLLoader fxmlLoader = new FXMLLoader();                   // fxml file
        fxmlLoader.setLocation(getClass().getResource("contactdialog.fxml"));
        try {
            dialog.getDialogPane().setContent(fxmlLoader.load());
        } catch (IOException e){
            System.out.println("Couldn't load the dialog");
            e.printStackTrace();
            return;
        } // adding buttons to the dialog controller
        dialog.getDialogPane().getButtonTypes().add(ButtonType.OK);
        dialog.getDialogPane().getButtonTypes().add(ButtonType.CANCEL);

        Optional<ButtonType> result = dialog.showAndWait();
        if (result.isPresent() && result.get() == ButtonType.OK){ // pressed button ok, meaning the want to save the info
            ContactController contactController = fxmlLoader.getController();
            Contact newContact = contactController.getNewContact(); // access to contact controller to access get new contact
            data.addContact(newContact); // method to retrieve contents from dialog fields and save the info to the xml file
            data.saveContacts(); // saving the contact changes after a contact has been added to the list
        }

    }
}
