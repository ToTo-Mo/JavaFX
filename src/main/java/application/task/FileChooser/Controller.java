package application.task.FileChooser;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;

public class Controller implements Initializable {

    @FXML
    private MenuItem open;
    @FXML
    private Label imageLabel;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        open.setOnAction(event -> {
            FileChooser fileChooser = new FileChooser();

            fileChooser.getExtensionFilters().addAll(

                    new FileChooser.ExtensionFilter("BMP File (*.bmp)", "*.bmp"),
                    new FileChooser.ExtensionFilter("JPG File (*.jpg)", "*.jpg"),
                    new FileChooser.ExtensionFilter("GIF File (*.gif)", "*.gif"),
                    new FileChooser.ExtensionFilter("PNG File (*.png)", "*.png"));

            File file = fileChooser.showOpenDialog(null);
            if (file != null) {

                FileInputStream inputstream;

                try {
                    inputstream = new FileInputStream(file);
                    Image image = new Image(inputstream);

                    imageLabel.setGraphic(new ImageView(image));
                } catch (FileNotFoundException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        });
    }
}
