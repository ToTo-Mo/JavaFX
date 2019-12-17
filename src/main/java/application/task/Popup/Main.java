package application.task.Popup;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    static Parent root;

    @Override
    public void start(final Stage primaryStage) throws IOException {
        root = FXMLLoader.load(getClass().getResource("/application/task/Popup/popup.fxml"));
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.setTitle("test");
        primaryStage.show();
    }
    public static void main(String[] args) {
        Application.launch(args);
    }
}