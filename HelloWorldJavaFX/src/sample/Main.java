package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
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
    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(root, 300, 275));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
