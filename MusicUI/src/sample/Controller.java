package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.concurrent.Task;
import sample.model.Artist;
import sample.model.Datasource;

public class Controller {
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
