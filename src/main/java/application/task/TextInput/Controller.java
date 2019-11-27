package application.task.TextInput;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;

public class Controller implements Initializable {

    @FXML
    private TextField text1;

    @FXML
    private TextField text2;

    @FXML
    private TextField text3;

    @FXML
    private PasswordField password;

    String s ="";

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // TODO Auto-generated method stub
        

        text1.setOnAction(event ->{
            s = "text1 : " + text1.getText();
            showAlert();
        });
        text2.setOnAction(event ->{
            s = "text2 : " + text2.getText();
            showAlert();
        });
        text3.setOnAction(event ->{
            s = "text3 : " + text3.getText();
            showAlert();
        });
        password.setOnAction(event ->{
            s = "password : " + password.getText();
            showAlert();
        });
    }
    
    public void showAlert(){
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("information");
        alert.setHeaderText(null);
        alert.setContentText(s);
        alert.showAndWait();
    }
}
