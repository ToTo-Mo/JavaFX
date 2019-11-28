package application.EventDrivenGUI;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.control.TextArea;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class SequenceOfEvent extends Application {

    // Create the LoggingArea
    private TextArea loggingArea = new TextArea("");

    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage stage) {
        // Create a Circle
        Circle circle = new Circle(50, 50, 50);
        circle.setFill(Color.CORAL);

        // Create a Rectangle
        Rectangle rectangle = new Rectangle(100, 100);
        rectangle.setFill(Color.TAN);

        // Create the HBox
        HBox hbox = new HBox();
        // Set Padding and Spacing of the HBox
        hbox.setPadding(new Insets(20));
        hbox.setSpacing(20);

        // Add the children to the HBox
        hbox.getChildren().addAll(circle, rectangle);

        // CReate the VBox
        VBox root = new VBox();
        // Set Padding and Spacing of the VBox
        root.setPadding(new Insets(20));
        root.setSpacing(20);
        // Add the children to the VBox
        root.getChildren().addAll(hbox, loggingArea);

        // Create the Scene

    }
}
