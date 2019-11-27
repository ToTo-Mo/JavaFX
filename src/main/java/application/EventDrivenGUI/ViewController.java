package application.EventDrivenGUI;

import java.io.IOException;

import com.jfoenix.controls.JFXButton;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class ViewController extends Application {

    @FXML
    public JFXButton apply;
    @FXML
    public JFXButton cancel;
    @FXML
    public JFXButton lookup;
    @FXML
    public JFXButton search;
    @FXML
    public JFXButton setting;
    @FXML
    public AnchorPane show;

    Scene scene;
    Stage primaryStage;

    @FXML
    public void initialize() {
        
        apply.setOnAction(event -> {
            try {
                show.getChildren().add(FXMLLoader.load(getClass().getResource("/application/EventDrivenGUI/apply.fxml")));
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        });

        cancel.setOnAction(event ->{
            show.getChildren().clear();
        });
    }

    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        // TODO Auto-generated method stub
        Parent root = FXMLLoader.load(getClass().getResource("/application/EventDrivenGUI/view.fxml"));
        scene = new Scene(root);
        this.primaryStage = primaryStage;
        this.primaryStage.setScene(scene);
        this.primaryStage.show();
    }
}
