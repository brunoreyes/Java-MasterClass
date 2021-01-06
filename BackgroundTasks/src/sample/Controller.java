package sample;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.concurrent.Task;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;

public class Controller {
    private Task<ObservableList<String>> task;

    @FXML
    private ListView listView; // able to update the listview using the platform.run later method
    // accepting a runnable and runs it on the UI thread. So I'll cal

    // javafx uses initialize() to initialize
    public void initialize(){
        task = new Task<ObservableList<String>>() {
            @Override
            protected ObservableList<String> call() throws Exception {
                // pretend database that returns 4 records with 1 second of sleep simulating the database fetch
                Thread.sleep(1000);
                ObservableList<String> employees = FXCollections.observableArrayList(
                        "Bruno Reyes", "Bugs Bunny", "Jack Jill", "Bob Mcdonald"
                );
//                Platform.runLater(new Runnable() {
//                    @Override
//                    public void run() {
//                        listView.setItems(employees);
//                    }
//                });
                // since I'm updating the ListView from the task I don't have to return the list when using
                // platform.runLater() to update the UI. but need to return it to update the UI from a task.


                return employees;
//                return FXCollections.observableArrayList(
//                        "Bruno Reyes", "Bugs Bunny", "Jack Jill", "Bob Mcdonald"
//                );
            }
        };
        // Rather than using platform.runLater(), I should use data binding, to bind the items property to
        // the tasks property.
        // Here i'm binding the tasks property to the item's property
        listView.itemsProperty().bind(task.valueProperty());

        // So I'm performing a long-running task on the background thread and updating the UI thread.

    }

    @FXML
    public void buttonPressed(){
        new Thread(task).start();
    }
}
