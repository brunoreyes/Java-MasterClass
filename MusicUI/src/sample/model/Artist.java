package sample.model;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class Artist {

    // Utilizing class SimpleIntegerProperty/SimpleStringProperty to be able to use data binding

    // Whenever data binding can be utilized we should use it, because we don't have to do anything
    // when the task completes, it takes care of it automatically.
    private SimpleIntegerProperty id;
    private SimpleStringProperty name;

    public Artist() {
        this.id = new SimpleIntegerProperty();
        this.name = new SimpleStringProperty();
    }

    public int getId() {
        return id.get();
    }

    public void setId(int id) {
        this.id.set(id);
    }

    // task.setOnSucceeded(e->artistTable.getItems().setAll(artistResults);

    public String getName() {
        return name.get();
    }

    public void setName(String name) {
        this.name.set(name);
    }
}
