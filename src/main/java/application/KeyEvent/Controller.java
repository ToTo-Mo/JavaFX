package application.KeyEvent;

import java.net.URL;
import java.util.Random;
import java.util.ResourceBundle;
import java.util.Timer;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

public class Controller implements Initializable {

    @FXML
    private Label blue;
    @FXML
    private Label red;
    @FXML
    private Label position;

    final int DELTABlue = 100, DELTARed = 10;
    private Point bluePoint, redPoint;
    int frameWidth;
    int frameHeight;

    Random random = new Random();
    private Timer timer = new Timer("keyBoard");

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // TODO Auto-generated method stub

    }

    
}
