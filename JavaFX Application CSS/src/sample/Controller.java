package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.GridPane;
import javafx.stage.DirectoryChooser;
import javafx.stage.FileChooser;

import java.io.File;

public class Controller {
    @FXML
    private Label label;

    @FXML
    private Button button4;

    @FXML
    private GridPane gridPane;

    public void initialize(){
        button4.setEffect(new DropShadow());
    }

    @FXML
    public void handleMouseEnter(){
        label.setScaleX(2.0); // increasing the zoom in by 2 ( x2)
        label.setScaleY(2.0);
    }

    @FXML
    public void handleMouseExit(){
        label.setScaleX(1.0); // decreasing zoom back to 1 ( x1)
        label.setScaleY(1.0);
    }

    @FXML
    public void handleClick(){
        // chooses a file instead of a directory (folder)
//        FileChooser chooser = new FileChooser();
//        chooser.showOpenDialog(null);
  //      chooser.showOpenDialog(gridPane.getScene().getWindow()); // requiring to select a window
//        Chooses a directory(folder)


        DirectoryChooser chooser = new DirectoryChooser();
        File file = chooser.showDialog(gridPane.getScene().getWindow());
        if (file != null){
            System.out.println(file.getPath()); // printing out file path
        } else {
            System.out.println("Chooser was cancelled");
        }
//        chooser.showDialog(gridPane.getScene().getWindow()); // requiring to select a window



    }


}
