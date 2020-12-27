package sample;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
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
    private Label ourLabel;

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

        Runnable task = new Runnable() { // creating another program separate from UI to do processing
            @Override
            public void run() {
                try {
                    String s = Platform.isFxApplicationThread() ? "UI Thread" : "Background Thread";
                    System.out.println("I'm going to sleep on the: "+ s);
                    Thread.sleep(10000);
                    // Exception in thread "Thread-4" java.lang.IllegalStateException:
                    // Not on FX application thread; currentThread = Thread-4

                    // Thread B can white out what thread a started, and when thread A runs again
                    // it continues its updates w/o knowing it's prev. updates were overwritten by thread B
                    Platform.runLater(new Runnable() { // invoking command, updating UI label on UI thread
                        @Override
                        public void run() {
                            String s = Platform.isFxApplicationThread() ? "UI Thread" : "Background Thread";
                            System.out.println("I'm updating the label on the: "+ s);
                            ourLabel.setText("We did something!");
                        }
                    });
                } catch (InterruptedException event){
                    // we don't care about this
                }
            }
        }; // ensure to put a semicolon at end of runnable

        new Thread(task).start();

//        putting thread to sleep after 10 secs after printing a message to the console,
//        displaying what happens when a UI is unresponsive
//        exceptions try to track an error
//        try {
//            Thread.sleep(10000); // giving spinning globe of death aka sleeping the UI thread
//            // if an action takes more than a sec to complete, it should be starting another thread
//            // that'll do the work that'll take a while to process.
//            // the background thread is the thread that takes a while to do the work
//            // meanwhile the UI thread is what the user views
//        } catch (InterruptedException event){
//            // don't care about this at the moment
//        }
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
