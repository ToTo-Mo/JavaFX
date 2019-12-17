package application.task.Popup;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.Label;
import javafx.scene.control.RadioMenuItem;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;

public class Controller implements Initializable {

    @FXML
    private Label text;
    @FXML
    private ContextMenu contextMenu;

    @FXML
    private RadioMenuItem red;
    @FXML
    private RadioMenuItem blue;
    @FXML
    private RadioMenuItem green;
    @FXML
    private RadioMenuItem black;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        text.setText("String for test");
        text.setTextFill(Color.BLACK);
        text.setFont(Font.font("Corbel", FontPosture.REGULAR, 72));

        Platform.runLater(() -> {
            text.getScene().setOnMousePressed(event -> {
                if (event.isSecondaryButtonDown())
                    contextMenu.show(Main.root, event.getScreenX(), event.getScreenY());
            });
        });

        red.setOnAction(event-> text.setTextFill(Color.RED));
        blue.setOnAction(event-> text.setTextFill(Color.BLUE));
        green.setOnAction(event-> text.setTextFill(Color.GREEN));
        black.setOnAction(event-> text.setTextFill(Color.BLACK));
    }
}
