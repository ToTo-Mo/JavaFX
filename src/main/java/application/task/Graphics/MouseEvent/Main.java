package application.task.Graphics.MouseEvent;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Main extends Application {

	private GraphicsContext gc;
	@Override
	public void start(Stage primaryStage) {
		StackPane root = new StackPane();

		Canvas canvas = new Canvas(300, 250);
		gc = canvas.getGraphicsContext2D();
		
		MouseEventHandler handler = new MouseEventHandler();
		canvas.setOnMousePressed(handler);
		canvas.setOnMouseReleased(handler);
		root.getChildren().add(canvas);
	
        Scene scene = new Scene(root, 300, 250);

		primaryStage.setTitle("test");
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public void drawShapes(int x1, int y1, int x2, int y2) {
		// 좌표값
		gc.setStroke(Color.BLACK);
		gc.strokeOval(x1, y1, x2-x1, y2-y1);
		
	}
    class MouseEventHandler implements EventHandler<MouseEvent>{
		private int x1, y1 ,x2, y2;
		@Override
		public void handle(MouseEvent e) {
			if(e.getEventType() == MouseEvent.MOUSE_PRESSED) {
				x1 =(int) e.getX();
				y1 =  (int) e.getY();
			}
			else if (e.getEventType() == MouseEvent.MOUSE_RELEASED) {
				x2 = (int) e.getX();
				y2 = (int) e.getY();
				drawShapes(x1,y1,x2,y2);
			}
		}
	}
    public static void main(String[] args) {
		launch(args);
	}
}