package sample;

import javafx.collections.FXCollections;
import javafx.concurrent.Task;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;

public class Controller {
    private Task<ObservableList<String>> task;

    // javafx uses initialize() to initialize
    public void initialize(){
        task = new Task<ObservableList<String>>() {
            @Override
            protected ObservableList<String> call() throws Exception {
                // pretend database that returns 4 records with 1 second of sleep simulating the database fetch
                Thread.sleep(1000);
                return FXCollections.observableArrayList(
                        "Bruno Reyes", "Bugs Bunny", "Jack Jill", "Bob Mcdonald"
                );
            }
        };
    }

    @FXML
    public void buttonPressed(){
        new Thread(task).start();
    }
}
