package application;

import javafx.application.Application;
import javafx.geometry.*;
import javafx.scene.*;
import javafx.scene.control.Hyperlink;
import javafx.scene.layout.*;
import javafx.scene.text.*;
import javafx.stage.*;

/**
 * JavaFX App
 */
public class STACKPANE extends Application {

    @Override
    public void start(Stage stage) {
        Text text1 = new Text("o"); Text text2 = new Text("o"); Text text3 = new Text("o");
        Text text4 = new Text("   o"); Text text5 = new Text("\n  o"); 
           
        StackPane stack = new StackPane();   
        stack.getChildren().addAll(text1, text2, text3, text4, text5);
        
        Scene scene = new Scene(stack);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

}