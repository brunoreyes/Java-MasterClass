module MyContacts {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.xml; // ensure to use this when dealing with xml files
    requires javafx.web;
    requires java.desktop;
    requires javafx.swt;

    opens sample;
    opens sample.datamodel; // Make sure to open the data model as well.
}