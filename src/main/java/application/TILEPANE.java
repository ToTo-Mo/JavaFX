package application;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.TilePane;
import javafx.stage.Stage;

/**
 * JavaFX App
 */
public class TILEPANE extends Application {

    @Override
    public void start(Stage stage) {
        TilePane tile = new TilePane();
        tile.setPadding(new Insets(5, 0, 5, 0));
        tile.setVgap(4);
        tile.setHgap(4);

        Button btn1 = new Button("Button1");
        tile.getChildren().add(btn1);
        Button btn2 = new Button("Button2.....................................................");
        btn2.setMaxWidth(Double.MAX_VALUE);
        tile.getChildren().add(btn2);
        Button btn3 = new Button("Button3");
        tile.getChildren().add(btn3);
        Button btn4 = new Button("Button4");
        tile.getChildren().add(btn4);
        Button btn5 = new Button("Button5");
        tile.getChildren().add(btn5);

        Scene scene = new Scene(tile);
        stage.setScene(scene);
        stage.show();

        scene.setCursor(Cursor.CROSSHAIR);

        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

}