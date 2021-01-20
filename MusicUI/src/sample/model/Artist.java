package sample.model;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class Artist {

    // Utilizing class SimpleIntegerProperty/SimpleStringProperty to be able to use data binding

    // Whenever data binding can be utilized we should use it, because we don't have to do anything
    // when the task completes, it takes care of it automatically.
    private SimpleIntegerProperty id;
    private SimpleStringProperty name;

    public SimpleIntegerProperty getId() {
        return id;
    }

    public void setId(SimpleIntegerProperty id) {
        this.id = id;
    }

    // task.setOnSucceeded(e->artistTable.getItems().setAll(artistResults);

    public SimpleStringProperty getName() {
        return name;
    }

    public void setName(SimpleStringProperty name) {
        this.name = name;
    }
}
