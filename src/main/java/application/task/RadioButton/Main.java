package application.task.RadioButton;

import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        // TODO Auto-generated method stub
        new Controller().display(primaryStage);
    }

    public static void main(String[] args){
        launch();
    }

}