package application.EventDrivenGUI;

import javafx.application.Application;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class StageExamples extends Application {
    public static void main(String[] args) {
        launch(args);
    }
    @Override
    public void start(Stage primaryStage) throws Exception {
        // TODO Auto-generated method stub
        primaryStage.setTitle("JavaFX App");

        Stage stage = new Stage();
        stage.initModality(Modality.APPLICATION_MODAL);

        primaryStage.show();
        stage.showAndWait();
    }
}

