package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;


public class Controller {
    @FXML // type @FXML assigning text field to the name instance var
    // by annotating the instance var declaration, and accepting the import
    private TextField nameField;

    @FXML
    private Button helloButton;

    @FXML
    private Button byeButton;

    @FXML
    private CheckBox ourCheckBox; // ensure capitalized camelcase

    @FXML
    public void initialize(){
        helloButton.setDisable(true);
        byeButton.setDisable(true);
    }

    @FXML
    public void onButtonClicked(ActionEvent e){
        if (e.getSource().equals(helloButton)){
            System.out.println("Hello, " + nameField.getText());
        } else if (e.getSource().equals(byeButton)){
            System.out.println("Bye, " + nameField.getText());
        }

//        putting thread to sleep after 10 secs after printing a message to the console,
//        displaying what happens when a UI is unresponsive
//        exceptions try to track an error
        try {
            Thread.sleep(10000); // giving spinning globe of death
        } catch (InterruptedException event){
            // don't care about this at the moment
        }
        if (ourCheckBox.isSelected()){
            nameField.clear(); // clear context of nameField
            helloButton.setDisable(true);
            byeButton.setDisable(true);
        }
//        System.out.println("Hello, " + nameField.getText());
//
//        // getting the memory location that changes each time the button is clicked
//        System.out.println("The following button was pressed: " + e.getSource());
    }

    @FXML
    public void handleKeyReleased(){
        String text = nameField.getText();
        boolean disableButtons = text.isEmpty() || text.trim().isEmpty(); // .trim() ignores whitespace
        helloButton.setDisable(disableButtons);
        byeButton.setDisable(disableButtons);
    }

    public void handleChange(){
        System.out.println("The checkbox is " + (ourCheckBox.isSelected() ? "checked" : "unchecked"));
    }
}
