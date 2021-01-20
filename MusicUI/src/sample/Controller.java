package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.concurrent.Task;
import javafx.fxml.FXML;
import javafx.scene.control.TableView;
import sample.model.Album;
import sample.model.Artist;
import sample.model.Datasource;

public class Controller {

    @FXML
    private TableView artistTable;

    public void listArtists(){

        // Creating a new task object and binding the result of the task (artist Observable List)
        // to the artistTableView.itemsProperty()
        Task<ObservableList<Artist>> task = new GetAllArtistsTask();
        artistTable.itemsProperty().bind(task.valueProperty());

        new Thread(task).start();
    }

    // Recall longer actions should be stored in the background thread

    @FXML
    public void listAlbumsForArtist(){
        final Artist artist = (Artist) artistTable.getSelectionModel().getSelectedItem();
        if (artist == null){
            System.out.println("NO ARTIST SELECTED");
            return;
        }
        Task<ObservableList<Album>> task = new Task<ObservableList<Album>>() {
            @Override
            protected ObservableList<Album> call() throws Exception {
                return FXCollections.observableArrayList(
                        Datasource.getInstance().queryAlbumForArtistId(artist.getId()));

            }
        };
        artistTable.itemsProperty().bind(task.valueProperty());

        new Thread(task).start();

    }
}

class GetAllArtistsTask extends Task{

    // Overriding the call method to call the queryArtist method in our Datasource.java
    // returning a list
    @Override
    public ObservableList<Artist> call(){
        return FXCollections.observableArrayList(
                Datasource.getInstance().queryArtist(Datasource.ORDER_BY_ASC));
    }
}
