package application.UsingCSS;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class code extends Application {
    GridPane grid = new GridPane();
    HBox buttons = new HBox();
    JFXButton btnSubmit = new JFXButton("Submit");
    JFXButton btnClear = new JFXButton("Clear");
    Label label_id = new Label("User name:");
    JFXTextField id = new JFXTextField();
    Label label_password = new Label("Password:");
    JFXPasswordField password = new JFXPasswordField();
    Scene scene = new Scene(grid);

    @Override
    public void start(Stage primaryStage) throws Exception {
        initialize();
        setStyle();
        
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public void initialize(){

        grid.setHgap(10);
        grid.setVgap(12);
        grid.setPadding(new Insets(50, 50, 50, 50));
        grid.setAlignment(Pos.CENTER);
        grid.setMaxSize(scene.getWidth(), scene.getHeight());
        
        buttons.setSpacing(10.0);
        buttons.setAlignment(Pos.CENTER);
        buttons.setMaxWidth(grid.getPrefWidth());
        buttons.setPrefWidth(grid.getPrefWidth());
        btnSubmit.setMaxWidth(buttons.getMaxWidth());
        btnSubmit.setPrefWidth(buttons.getPrefWidth());
        btnClear.setMaxWidth(buttons.getMaxWidth());
        btnClear.setPrefWidth(buttons.getPrefWidth());

        buttons.getChildren().addAll(btnSubmit, btnClear);
        grid.add(label_id, 0, 0);
        grid.add(id, 1, 0);
        grid.add(label_password, 0, 1);
        grid.add(password, 1, 1);
        grid.add(buttons, 0, 2, 2, 1);
    }

    public void setStyle(){
        label_password.setId("label_password");
        scene.getStylesheets().add(getClass().getResource("/application/UsingCSS/DesignPack.css").toExternalForm());
    }

    public static void main(String[] args){
        launch();
    }

}