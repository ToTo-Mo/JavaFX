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
public class FLOWPANE extends Application {

    @Override
    public void start(Stage stage) {
        FlowPane flow = new FlowPane(); // FlowPane(Orientation.VERTICAL);
        flow.setPadding(new Insets(5, 0, 5, 0));
        flow.setVgap(4);
        flow.setHgap(4);

        Button btn1 = new Button("Button1");
        flow.getChildren().add(btn1);
        Button btn2 = new Button("Button2");
        flow.getChildren().add(btn2);
        Button btn3 = new Button("Button3");
        flow.getChildren().add(btn3);
        Button btn4 = new Button("Button4");
        flow.getChildren().add(btn4);
        Button btn5 = new Button("Button5");
        flow.getChildren().add(btn5);

        Scene scene = new Scene(flow);
        stage.setScene(scene);
        stage.show();

    }

    public static void main(String[] args) {
        launch();
    }

}