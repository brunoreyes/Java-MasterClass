package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.concurrent.Task;
import javafx.fxml.FXML;
import javafx.scene.control.TableView;
import sample.model.Artist;
import sample.model.Datasource;

public class Controller {
    @FXML
    private TableView<Artist> artistTableView;
    public void listArtists(){
        // Creating a new task object and binding the result of the task (artist Observable List)
        // to the artistTableView.itemsProperty()
        Task<ObservableList<Artist>> task = new GetAllArtistsTask();
        artistTableView.itemsProperty().bind(task.valueProperty());
    }

    // Recall longer actions should be stored in the background thread
}

class GetAllArtistsTask extends Task{

    // Overriding the call method to call the queryArtist method in our Datasource.java
    // returning a list
    @Override
    protected ObservableList<Artist> call(){
        return FXCollections.observableArrayList(
                Datasource.getInstance().queryArtist(Datasource.ORDER_BY_ASC));
    }
}
