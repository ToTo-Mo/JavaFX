package application.ColorChooser;

import javafx.application.Application;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.ColorPicker;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Main extends Application {
    @Override
    public void start(Stage primaryStage) {
        StackPane root = new StackPane();
         
        ColorPicker colorPicker = new ColorPicker();       
        colorPicker.setOnAction(new EventHandler(){
            @Override
            public void handle(Event event) {
                Color fill = colorPicker.getValue();
                BackgroundFill backgroundFill = 
                    new BackgroundFill(fill, 
                            CornerRadii.EMPTY, 
                            Insets.EMPTY);
                Background background = new Background(backgroundFill);
                root.setBackground(background);
            }
        });
        root.getChildren().add(colorPicker);
         
        Scene scene = new Scene(root, 300, 250);
         
        primaryStage.setTitle("Color Picker Test");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
 
    public static void main(String[] args) {
        launch(args);
    }   
}