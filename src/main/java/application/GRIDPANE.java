package application;

import javafx.application.Application;
import javafx.geometry.*;
import javafx.scene.*;
import javafx.scene.control.Button;
import javafx.scene.layout.*;
import javafx.stage.*;

/**
 * JavaFX App
 */
public class GRIDPANE extends Application {

    @Override
    public void start(Stage stage) {
        GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(0, 10, 0, 10));

        Button btn1 = new Button("Button1");
        grid.add(btn1, 0, 0);
        Button btn2 = new Button("Button2");
        grid.add(btn2, 1, 0);
        Button btn3 = new Button("Button3");
        grid.add(btn3, 2, 0);
        Button btn4 = new Button("Button4");
        GridPane.setHalignment(btn4, HPos.RIGHT);
        grid.add(btn4, 0, 1, 3, 1);
        Button btn5 = new Button("Button5");
        GridPane.setHalignment(btn5, HPos.RIGHT);
        btn5.setMaxWidth(Double.MAX_VALUE);
        grid.add(btn5, 0, 2, 3, 1);

        Scene scene = new Scene(grid);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

}