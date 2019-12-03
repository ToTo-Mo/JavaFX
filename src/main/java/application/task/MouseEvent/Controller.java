package application.task.MouseEvent;

import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.effect.Light.Point;

public class Controller implements Initializable {

    @FXML
    private Label click_here;

    @FXML
    private Label indicator;

    @FXML
    private Button button;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // TODO Auto-generated method stub

        button.setOnMouseDragged(event -> {
            Point button_point = new Point((int) button.getLayoutX(), (int) button.getLayoutY(), 0, null);
            button.setLayoutX(button_point.getX() + event.getX());
            button.setLayoutY(button_point.getY() + event.getY());
            indicator.setText("Button Dragged : " + button.getLayoutX() + ", " + button.getLayoutX());
        });

        Optional.ofNullable(button.getScene()).ifPresent(scene -> {
            scene.setOnMouseMoved(event->{
                indicator.setText(event.getX() + ", " + event.getY());

            });
        });

        Optional.ofNullable(button.getScene()).ifPresent(scene -> {
            scene.setOnMouseMoved(event->{
                indicator.setText("dragged" + event.getX() + ", " + event.getY());
            });
        });
        
        click_here.setOnMouseMoved(event -> {
            indicator.setText(event.getX() + " , " + event.getY());
            event.consume();
        });

        click_here.setOnMouseClicked(event -> {
            indicator.setText("Clicked : " + event.getX() + ", " + event.getY());
        });
    }
}
