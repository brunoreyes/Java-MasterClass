package sample;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;


public class Controller {
    @FXML // type @FXML assigning text field to the name instance var
    // by annotating the instance var declaration, and accepting the import
    private TextField nameField;

    @FXML
    public void onButtonClicked(){
        System.out.println("Hello, " + nameField.getText());
    }
}
