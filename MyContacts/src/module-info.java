module MyContacts {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.xml; // ensure to use this when dealing with xml files

    opens sample;
}