package application.Graphics.Shape;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.ArcType;
import javafx.stage.Stage;

public class Grid extends Application {

    @Override
    public void start(final Stage primaryStage) {
        final StackPane root = new StackPane();

        final Canvas canvas = new Canvas(400, 400);
        final GraphicsContext gc = canvas.getGraphicsContext2D();
        drawGrid(gc);

        root.getChildren().add(canvas);
        final Scene scene = new Scene(root, 400, 400);

        primaryStage.setTitle("Draw shapes with Canvas");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public void drawGrid(final GraphicsContext gc) {
        // 좌표값
        int count = 20;
        final double[] xPoints = new double[count];
        final double[] yPoints = new double[count];

        for (int i = 0; i < count; i++) {
            xPoints[i] = (i + 1) * 20;
            yPoints[i] = (i + 1) * 20;
        }

        for(int i=0; i<count; i++){
            if (i % 2 == 0)
                gc.setStroke(Color.valueOf("#3377ff"));
            else
                gc.setStroke(Color.valueOf("#ff7733"));

            gc.strokeLine(xPoints[i], yPoints[i], xPoints[i], yPoints[count-i-1]);
            gc.strokeLine(xPoints[i],yPoints[i],xPoints[count-i-1],yPoints[i]);
            gc.strokeLine(xPoints[i],yPoints[i],xPoints[count-i-1],yPoints[count-i-1]);
            gc.strokeLine(xPoints[count-i-1],yPoints[count-i-1],xPoints[i],yPoints[i]);

        }

    }

    public static void main(final String[] args) {
        launch(args);
    }
}
