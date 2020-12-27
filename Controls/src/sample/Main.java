package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
// to avoid error: Invalid Module Name: '1' is not a Java identifier
    //1. Simply rename the file to jlfgr-1.0.jar
    //2. Follow Tim's 2nd way of adding the jar BUT in the new IntelliJ the tab is called (on Windows ver.)
    // Open in -> Explorer
    //3. In module-info.java type requires and while you start typing 'j' should be on the list.
    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(root, 800, 500));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
