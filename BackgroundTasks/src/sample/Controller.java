package sample;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.concurrent.Service;
import javafx.concurrent.Task;
import javafx.collections.ObservableList;
import javafx.concurrent.Worker;
import javafx.concurrent.WorkerStateEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.ProgressBar;

public class Controller {

//    private Task<ObservableList<String>> task;

    @FXML // annotating with @FXML
    private ListView listView; // able to update the listview using the platform.run later method
    // accepting a runnable and runs it on the UI thread.

    @FXML
    private ProgressBar progressBar;

    @FXML
    private Label progressLabel;

    private Service<ObservableList<String>> service;

    // javafx uses initialize() to initialize
    public void initialize(){
////        task = new Task<ObservableList<String>>() {
//            task = new Task<>() {
//            @Override
//            protected ObservableList<String> call() throws Exception {
//                // pretend database that returns 4 records with 1 second of sleep simulating the database fetch
////                Thread.sleep(1000);
//
//
//            }
//        };

        service = new EmployeeService();

        // linking the progress bar to the task's progress using data binding.
        progressBar.progressProperty().bind(service.progressProperty()); // switched task to service
        // Rather than using platform.runLater(), I should use data binding, to bind the items property to
        // the tasks property. Here I'm binding the tasks property to the item's property.
        progressLabel.textProperty().bind(service.messageProperty());
        listView.itemsProperty().bind(service.valueProperty());
        // So I'm performing a long-running task on the background thread and updating the UI thread.

        // if service is running
        progressBar.visibleProperty().bind(service.runningProperty());
        progressLabel.visibleProperty().bind(service.runningProperty());

        // Or the commented code below
//        service.setOnRunning(new EventHandler<WorkerStateEvent>() {
//            @Override
//            public void handle(WorkerStateEvent event) {
//                progressBar.setVisible(true);
//                progressLabel.setVisible(true);
//            }
//        });
//
//        // if service has succeeded
//        service.setOnSucceeded(new EventHandler<WorkerStateEvent>() {
//            @Override
//            public void handle(WorkerStateEvent event) {
//                progressBar.setVisible(false);
//                progressLabel.setVisible(false);
//            }
//        });
//        // when running for the first time
//        progressBar.setVisible(false);
//        progressLabel.setVisible(false);


    }

    @FXML
    public void buttonPressed(){
        if (service.getState() == Worker.State.SUCCEEDED){ // resetting service to start to
            service.reset(); // avoid illegalStateException stating that I can only run code from
            service.start(); // Start and not state SUCCEEDED
        } else if (service.getState() == Worker.State.READY){
            service.start();
        }
//        new Thread(task).start();
    }
}
