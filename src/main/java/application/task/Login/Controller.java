package application.task.Login;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class Controller implements Initializable {

    @FXML
    private TextField id;
    @FXML
    private PasswordField password;
    @FXML
    private Button login;
    @FXML
    private Button exit;

    String str;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        login.setOnAction(event ->{
            if(id.getText().equals("20161213") && password.getText().equals("최범휘"))
                str = "축하합니다.";
            else
                str = "틀렸습니다. 다시입력하세요.";
            showAlert(str);
        });

        exit.setOnAction(event -> {
            System.exit(0);
        });
    }

    public void showAlert(String message){
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("알림");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait(); 
    }

}
