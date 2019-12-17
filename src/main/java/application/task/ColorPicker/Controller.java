package application.task.ColorPicker;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.control.ColorPicker;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;

public class Controller implements Initializable {

    @FXML
    private StackPane stackPane;

    @FXML
    private ColorPicker colorPicker;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        colorPicker.setOnAction(event ->{
            stackPane.setBackground(new Background(new BackgroundFill(colorPicker.getValue(), CornerRadii.EMPTY, Insets.EMPTY)));
        });
    }

}
