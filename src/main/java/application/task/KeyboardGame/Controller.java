package application.task.KeyboardGame;

import java.net.URL;
import java.util.Random;
import java.util.ResourceBundle;
import java.util.Timer;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;

public class Controller implements Initializable {

    @FXML
    private Label blue_skin;

    @FXML
    private Label red_skin;

    @FXML
    private Label red_position;

    public Label getBlue_skin() {
        return blue_skin;
    }

    public Label getRed_skin() {
        return red_skin;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        
        Platform.runLater(() -> {
            red_position.getScene().setOnKeyPressed(event ->{
                if(GameManaer.isCatched(GameManaer.player, GameManaer.computer)){
                    GameManaer.exit();
                }

                red_position.setText(GameManaer.player.move(event.getCode()));
            });
        });
    }

}
