package application.task.KeyboardGame;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;

public class Controller implements Initializable {

    @FXML
    private Label me;

    @FXML
    private Label enemy;

    @FXML
    private Label red_position;

    int frameWidth, frameHeight;

    Random random = new Random();
    Timer timer = new Timer();
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        red_position.getScene().setOnKeyPressed(event ->{
            if(event.getCode() == KeyCode.W){
                
            }

            if(event.getCode() == KeyCode.W){
                
            }

            if(event.getCode() == KeyCode.W){
                
            }

            if(event.getCode() == KeyCode.W){
                
            }
        });        
    }

    public void initializeGame(){
        
    }
}
