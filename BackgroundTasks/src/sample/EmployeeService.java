package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.concurrent.Service;
import javafx.concurrent.Task;

public class EmployeeService extends Service<ObservableList<String>> {
    @Override
    protected Task<ObservableList<String>> createTask() {
        return new Task<ObservableList<String>>() {
            @Override
            protected ObservableList<String> call() throws Exception {
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
                    updateMessage("Added " + names[i] + " to the list");

                    updateProgress(i + 1, 4);
                    Thread.sleep(300);
                }
                return employees;
//                return FXCollections.observableArrayList(
//                        "Bruno Reyes", "Bugs Bunny", "Jack Jill", "Bob Mcdonald"
//                );
            }
        };
    }
}
