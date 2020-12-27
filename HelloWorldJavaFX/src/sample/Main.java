package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class Main extends Application { // the Application Class manages the life-cycle of a JavaFX app
    /*
    1. Download the proper ver 11 Java FX file for your OS from here: https://gluonhq.com/products/javafx/
    2. Unlock the zip file and place file where you usually put Java files
    3. Start up IntelliJ, go up to file > project structure > global libraries > find the file & go into
    the javafx-sdk-11.0.2's lib sub-folder and download all JAR (java files) and the src.zip file for the lib sub-folder > then press ok
    4. Now start a new project > view left list and instead of starting with Java, go down to Java FX
    5. Within the newly created project, right-click on the project > open module settings > make sure projects
    setting are using correct version (in our case that's 11) global settings
    > right-click on javaFX library > press "add to modules" > press ok > press ok
    6. Right-click on src of project file and new > module-info.java and add the following code within the:
    module HelloWorldFX{
    requires javafx.fxml;
    requires javafx.controls;
    7. In Mac's preferences> security & privacy > input monitoring > check IntelliJ
    opens sample;
    }
    8. That's it. Now I have successfully installed JavaFX and implemented it within a project
            */

/*
Overview:
JavaFX was designed with the MVC or Model View Controller, pattern in mind. In a nutshell,
this pattern keeps the code that handles an application's data separate from the UI code

B/c of this, when we're using the MVC pattern, we wouldn't mix the code that deals with the UI
and the code that manipulates the app's data in the same class. The controller is sort of the
middleman between the UI and the data.

When working with JavaFX, the model corresponds to the app's data model, the view is the FXML,
and the controller is the code that determines what happens when a user interacts with the UI.
Essentially the controller handles events.
 */
    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml")); // loads FX UI file

        // editing the font type, color, size, and weight via main class
//        GridPane root = new GridPane();
//        root.setAlignment(Pos.CENTER);

//        // setting equivalent of V/H gap from Main instead of sample.fxml
//        root.setVgap(10);
//        root.setHgap(10);
//        Label greeting = new Label("Welcome to JavaFX!");
//
//        greeting.setTextFill(Color.GREEN); // changing color
//        // changing font and font weight and font size
//        greeting.setFont(Font.font("Times New Roman", FontWeight.BOLD, 70));
//        root.getChildren().add(greeting); // adding a label control to the list


        primaryStage.setTitle("Hello JavaFX!"); // title on top of window
        primaryStage.setScene(new Scene(root, 700, 275)); // theatre metaphor
        primaryStage.show(); // showing the ui
    }


    public static void main(String[] args) {
        launch(args);
    }
}
