package sample;

import java.io.File;
import java.util.List;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.GridPane;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;

public class Controller {
    @FXML
    private Label label;

    @FXML
    private Button button4;

    @FXML
    private GridPane gridPane;

    @FXML
    private WebView webView;

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
        FileChooser chooser = new FileChooser();
//        chooser.setTitle("Save Application File");

        // Able to save choose type of file you want to save as either txt or pdf.
        chooser.getExtensionFilters().addAll(
//                new FileChooser.ExtensionFilter("Text", "*.txt"),
                new FileChooser.ExtensionFilter("Zip", "*.zip"),
                new FileChooser.ExtensionFilter("PDF", "*.pdf"),
                new FileChooser.ExtensionFilter("Image Files", "*.jpg","*.png","*.gif"),
                new FileChooser.ExtensionFilter("All Files", "*.*")
        );

  //      chooser.showOpenDialog(gridPane.getScene().getWindow()); // requiring to select a window
//        Chooses a directory(folder)

//        DirectoryChooser chooser = new DirectoryChooser();
//        File file = chooser.showDialog(gridPane.getScene().getWindow());
//        chooser.showDialog(gridPane.getScene().getWindow()); // requiring to select a window

        // opens a dialog that prompts user to save a file by first naming it then choosing where to store it
//        File file = chooser.showSaveDialog(gridPane.getScene().getWindow());

        // showOpenDialog() will open up the file and gray out files that cannot be selected via filter
//        File file = chooser.showOpenDialog(gridPane.getScene().getWindow());

        // showOpenMultipleDialog can return a list of file objects rather than only one
        List<File> file = chooser.showOpenMultipleDialog(gridPane.getScene().getWindow());
        if (file != null){ // grabbing paths or all selected (potentially multiple) files
            for (int i=0; i<file.size(); i++){
                System.out.println(file.get(i));
            }
            //                System.out.println(file.getPath()); // printing out file path
        } else {
            System.out.println("Chooser was cancelled");
        }
    }

    @FXML
    public void handleLinkClick() {
//        try {
//            Desktop.getDesktop().browse(new URI("http://www.javafx.com"));
//        } catch(IOException e) {
//            e.printStackTrace();
//        } catch(URISyntaxException e) {
//            e.printStackTrace();
//        }
        WebEngine engine = webView.getEngine();
        engine.load("http://www.javafx.com");
    }


}
