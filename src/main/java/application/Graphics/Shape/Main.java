package application.Graphics.Shape;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.ArcType;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) {
        StackPane root = new StackPane();

        Canvas canvas = new Canvas(300, 250);
        GraphicsContext gc = canvas.getGraphicsContext2D();
        drawShapes(gc);

        root.getChildren().add(canvas);
        Scene scene = new Scene(root, 300, 250);

        primaryStage.setTitle("Draw shapes with Canvas");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public void drawShapes(GraphicsContext gc) {
        // 좌표값
        double[] xPoints = new double[5];
        double[] yPoints = new double[5];

        xPoints[0] = 70;
        yPoints[0] = 90;
        xPoints[1] = 100;
        yPoints[1] = 70;
        xPoints[2] = 130;
        yPoints[2] = 90;
        xPoints[3] = 130;
        yPoints[3] = 130;
        xPoints[4] = 70;
        yPoints[4] = 130;
        gc.setFill(Color.valueOf("#225588")); // 도형을 채울 색상
        gc.fillRect(0, 0, 60, 60);
        gc.fillPolygon(xPoints, yPoints, 5);
        gc.fillOval(140, 0, 60, 60);
        gc.fillArc(210, 0, 60, 60, 90, 90, ArcType.ROUND);

        gc.setStroke(Color.BLUE); // 도형을 그릴 색상(선)
        gc.strokeRect(0, 70, 60, 60);
        gc.strokeLine(70, 0, 130, 60);
        gc.strokeOval(140, 70, 60, 60);
        gc.strokeArc(210, 70, 60, 60, 90, 90, ArcType.ROUND);

    }

    public static void main(String[] args) {
        launch(args);
    }
}
