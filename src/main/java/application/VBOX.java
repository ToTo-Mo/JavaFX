package application;

import javafx.application.Application;
import javafx.geometry.*;
import javafx.scene.*;
import javafx.scene.control.Hyperlink;
import javafx.scene.layout.*;
import javafx.scene.text.*;
import javafx.stage.*;

/**
 * JavaFX App
 */
public class VBOX extends Application {

    @Override
    public void start(Stage stage) {
        VBox vbox = new VBox();     vbox.setPadding(new Insets(10));
        vbox.setSpacing(8);
    
        Text title = new Text("Data");
        title.setFont(Font.font("Arial", FontWeight.BOLD, 14));
        vbox.getChildren().add(title);
    
        Hyperlink options[] = new Hyperlink[] {
            new Hyperlink("Sales"), new Hyperlink("Marketing"),
            new Hyperlink("Distribution"), new Hyperlink("Costs")};
    
        for (int i=0; i<4; i++) {
            VBox.setMargin(options[i], new Insets(0, 0, 0, 8));
            vbox.getChildren().add(options[i]);
        }
    
        var scene = new Scene(vbox,600,480);

        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

}