package application.task.UserDialog;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class Main extends Application implements Initializable {

    @FXML
    private Button button;

    static String result = "";
    Stage stage;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        button.setOnAction(event -> {
            MyDialog myDialog = new MyDialog(stage);
            if(!result.equals("")){
                button.setText(result);
            }
        });
    }
    @Override
    public void start(Stage primaryStage) throws IOException {
        MainWindow main = new MainWindow(primaryStage);
        stage = primaryStage;
    }
    public static void main(String[] args) {
        launch(args);
    }
}

class MainWindow {
    public MainWindow(Stage primaryStage) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/application/task/UserDialog/main.fxml"));
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}

