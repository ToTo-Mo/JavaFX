package application.task.MouseEvent;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    Scene scene;
    Stage stage;

    @Override
    public void start(Stage primaryStage) throws IOException {
        stage = primaryStage;
        changeScene(stage);
    }

    private void changeScene(Stage primaryStage) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/application/task/MouseEvent/mouseEvent.fxml"));
        Scene scene = new Scene(root);

        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
