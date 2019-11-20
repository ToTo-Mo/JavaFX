package application.EventDrivenGUI;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class ViewController extends Application {

    Scene scene;
    AnchorPane root;

    Button[] buttons;
    Label test;

    @Override
    public void start(Stage primaryStage) throws Exception {
        // TODO Auto-generated method stub

        initialize();
        setEvent();

        root.getChildren().addAll(buttons);
        root.getChildren().add(test);
        

        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public void initialize(){
        buttons = new Button[2];
        for(int i=0; i<buttons.length; i++)
            buttons[i] = new Button();
    
        test = new Label("잘가");

        root = new AnchorPane();
        scene = new Scene(root);
    }
    
    public void setEvent(){
        for(int i=0; i<buttons.length; i++)
            buttons[i].setOnMousePressed(event -> {
                test.setText("안녕");
            });
    }

    public static void main(String[] args){
        launch();
    }
}