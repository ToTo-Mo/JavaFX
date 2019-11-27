package application.Container;

import javafx.application.Application;
import javafx.geometry.*;
import javafx.scene.*;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.layout.*;
import javafx.scene.text.*;
import javafx.stage.*;

/**
 * JavaFX App
 */
public class BORDERPANE extends Application {

    @Override
    public void start(Stage stage) {
        BorderPane border = new BorderPane();

        Button btn1 = new Button("Button1");
        btn1.setMaxWidth(Double.MAX_VALUE);
        border.setTop(btn1);
        Button btn2 = new Button("Button2");
        btn2.setMaxWidth(Double.MAX_VALUE);
        btn2.setMaxHeight(Double.MAX_VALUE);
        border.setLeft(btn2);
        Button btn3 = new Button("Button3");
        btn3.setMaxHeight(Double.MAX_VALUE);
        btn3.setMaxWidth(Double.MAX_VALUE);
        border.setRight(btn3);
        Button btn4 = new Button("Button4");
        btn4.setMaxWidth(Double.MAX_VALUE);
        border.setBottom(btn4);
        Button btn5 = new Button("hello");
        btn5.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        border.setCenter(btn5);

        Scene scene = new Scene(border);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

}