package application.task.RadioButton;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;

public class Controller implements Initializable{
    @FXML
    private ToggleGroup group1;

    @FXML
    private ToggleGroup group2;
    



    public void display(Stage primaryStage) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/application/task/RadioButton/radioButton.fxml"));
        Scene scene = new Scene(root);
        Stage stage = primaryStage;
        stage.setScene(scene);
        stage.show();

    }

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
	}
}
