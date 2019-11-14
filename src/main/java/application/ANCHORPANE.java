package application;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

/**
 * JavaFX App
 */
public class ANCHORPANE extends Application {

    @Override
    public void start(Stage stage) {
        AnchorPane root = new AnchorPane();
        BorderPane child = new BorderPane();
        
        Button btn1 = new Button("Button1");
        root.getChildren().add(btn1);
        Button btn2 = new Button("Button2");
        root.getChildren().add(btn2);
        AnchorPane.setRightAnchor(btn2, 5.0);
        Button btn3 = new Button("Button3");
        root.getChildren().add(btn3);
        AnchorPane.setTopAnchor(btn3, 20.0);
        Button btn4 = new Button("Button4");
        root.getChildren().add(btn4);
        AnchorPane.setBottomAnchor(btn4, 8.0);
        AnchorPane.setRightAnchor(btn4, 5.0);
        Button btn5 = new Button("Button5");
        root.getChildren().add(btn5);
        AnchorPane.setBottomAnchor(btn5, 8.0);


        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

}