package application.task.MouseEvent;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.effect.Light.Point;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class temp extends Application {
    private Label indicator, click_here;
    private Button button1;
    private Scene scene;

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("JavaFX");
        try {
            Pane root = new Pane();

            indicator = new Label("Click Here");
            indicator.setLayoutX(0);
            indicator.setLayoutY(0);
            indicator.setBackground(new Background(new BackgroundFill(Color.YELLOW, CornerRadii.EMPTY, Insets.EMPTY)));
            indicator.setPrefSize(150, 50);

            click_here = new Label("Click Here");
            click_here.setLayoutX(0);
            click_here.setLayoutY(200);
            click_here.setBackground(new Background(new BackgroundFill(Color.YELLOW, CornerRadii.EMPTY, Insets.EMPTY)));
            click_here.setPrefSize(150, 50);

            button1 = new Button("Me");
            button1.setBackground(new Background(new BackgroundFill(Color.GREEN, CornerRadii.EMPTY, Insets.EMPTY)));
            button1.setPrefSize(50, 50);
            button1.setLayoutX(100);
            button1.setLayoutY(100);
            root.getChildren().addAll(indicator, click_here, button1);

            MouseEventHandler handlerObj = new MouseEventHandler();

            scene = new Scene(root, 300, 250);
            // 마우스 이벤트 등록
            scene.setOnMouseMoved(handlerObj);
            scene.setOnMouseDragged(handlerObj);
            click_here.setOnMouseClicked(handlerObj);
            click_here.setOnMouseMoved(handlerObj);
            button1.setOnMouseDragged(handlerObj);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }

    class MouseEventHandler implements EventHandler<MouseEvent> {
        @Override
        public void handle(MouseEvent e) {
            if (e.getSource() == scene) {
                if (e.getEventType() == MouseEvent.MOUSE_MOVED)
                    indicator.setText(e.getX() + " , " + e.getY());

                else if (e.getEventType() == MouseEvent.MOUSE_DRAGGED)
                    indicator.setText("dragged " + e.getX() + " , " + e.getY());
            
            } else if (e.getSource() == click_here) {
                if (e.getEventType() == MouseEvent.MOUSE_MOVED) {
                    indicator.setText(e.getX() + " , " + e.getY());
                    e.consume();

                } else if (e.getEventType() == MouseEvent.MOUSE_CLICKED)
                    indicator.setText("Clicked : " + e.getX() + ", " + e.getY());
            
            } else if (e.getSource() == button1) {
                Point bx = new Point((int) button1.getLayoutX(), (int) button1.getLayoutY(), 0, null);
                button1.setLayoutX(bx.getX() + e.getX());
                button1.setLayoutY(bx.getY() + e.getY());
                indicator.setText("Button Dragged : " + e.getX() + ", " + e.getY());
            }
        }
    }
}