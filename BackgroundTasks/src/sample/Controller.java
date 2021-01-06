package sample;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.concurrent.Task;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.ProgressBar;

public class Controller {
    private Task<ObservableList<String>> task;

    @FXML // annotating with @FXML
    private ListView listView; // able to update the listview using the platform.run later method
    // accepting a runnable and runs it on the UI thread.

    @FXML
    private ProgressBar progressBar;

    @FXML
    private Label progressLabel;

    // javafx uses initialize() to initialize
    public void initialize(){
//        task = new Task<ObservableList<String>>() {
            task = new Task<>() {
            @Override
            protected ObservableList<String> call() throws Exception {
                // pretend database that returns 4 records with 1 second of sleep simulating the database fetch
//                Thread.sleep(1000);

                String[] names = {"Bruno Reyes", "Bugs Bunny", "Jack Jill", "Bob Mcdonald"};

                ObservableList<String> employees = FXCollections.observableArrayList();
//                Platform.runLater(new Runnable() {
//                    @Override
//                    public void run() {
//                        listView.setItems(employees);
//                    }
//                });
                // since I'm updating the ListView from the task I don't have to return the list when using
                // platform.runLater() to update the UI. but need to return it to update the UI from a task.

                for (int i = 0; i < 4; i++) { // adding names from string array into the Observable list
                    employees.add(names[i]);
                    updateProgress(i + 1, 4);
                    Thread.sleep(2000);
                }
                return employees;
//                return FXCollections.observableArrayList(
//                        "Bruno Reyes", "Bugs Bunny", "Jack Jill", "Bob Mcdonald"
//                );
            }
        };

        // linking the progress bar to the task's progress using data binding.
        progressBar.progressProperty().bind(task.progressProperty());

        // Rather than using platform.runLater(), I should use data binding, to bind the items property to
        // the tasks property. Here I'm binding the tasks property to the item's property.

        progressLabel.textProperty().bind(task.messageProperty());

        listView.itemsProperty().bind(task.valueProperty());
        // So I'm performing a long-running task on the background thread and updating the UI thread.


    }

    @FXML
    public void buttonPressed(){
        new Thread(task).start();
    }
}
