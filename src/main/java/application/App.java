package application;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

/**
 * JavaFX App
 */
public class App extends Application {

    @Override
    public void start(Stage stage) {
        var label = new Label("hello world");
        label.setFont(new Font("system",30));

        var button = new Button("국밥 마이졍");

        var root = new StackPane();
        root.getChildren().add(label);
        root.getChildren().add(button);
        root.setAlignment(label,Pos.CENTER);

        
        var scene = new Scene(root,600,480);
        scene.setCursor(Cursor.CROSSHAIR);

        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

}