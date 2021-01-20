package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.concurrent.Task;
import javafx.fxml.FXML;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TableView;
import sample.model.Album;
import sample.model.Artist;
import sample.model.Datasource;

public class Controller {

    @FXML
    private TableView artistTable;

    @FXML
    private ProgressBar progressBar;

    @FXML // allowing us to use listArtist as an event handler for a button
    public void listArtists(){
        // Creating a new task object and binding the result of the task (artist Observable List)
        // to the artistTableView.itemsProperty()
        Task<ObservableList<Artist>> task = new GetAllArtistsTask();
        artistTable.itemsProperty().bind(task.valueProperty());
        progressBar.progressProperty().bind(task.progressProperty());

        progressBar.setVisible(true);

        task.setOnSucceeded(e -> progressBar.setVisible(false));
        task.setOnFailed(e -> progressBar.setVisible(false));

        new Thread(task).start();
    }

    // Recall longer actions should be stored in the background thread

    @FXML
    public void listAlbumsForArtist(){
        final Object obj = artistTable.getSelectionModel().getSelectedItem();
        if (obj instanceof Album) {
            return;
        }
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

    // Getting the actual record we want to update and passing the new name with a slash in it
    @FXML
    public void updateArtist(){
        final Artist artist = (Artist) artistTable.getItems().get(2);
        Task<Boolean> task = new Task<Boolean>() {
            @Override
            protected Boolean call() throws Exception {
                return Datasource.getInstance().updateArtistName(artist.getId(),"AC/DC");
            }
        };
        task.setOnSucceeded(event -> {
            if (task.valueProperty().get()){
                artist.setName("AC/DC");
                artistTable.refresh(); // underlying dataSources change in a way not observed by the tableView itself
                // so I'm adding the refresh() to force the update
            }
        });
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
