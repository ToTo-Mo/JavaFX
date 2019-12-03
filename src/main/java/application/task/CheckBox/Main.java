package application.task.CheckBox;

import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        Controller controller = new Controller();
        controller.display(primaryStage);
    }

    public static void main(String[] args) {
        launch();
    }
}