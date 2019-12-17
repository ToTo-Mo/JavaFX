package application.task.UserDialog;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class MyDialog extends Stage {
    public MyDialog(){

    }

    public MyDialog(Stage primaryStage){
        this.initModality(Modality.WINDOW_MODAL);
		this.initOwner(primaryStage);
		this.setTitle("찾기");
		try {
		this.setScene(new Scene(FXMLLoader.load(getClass().getResource("/application/task/UserDialog/finder.fxml"))));
		} catch (IOException e) {
			e.printStackTrace();
        }
		this.setResizable(false);
		this.showAndWait();
    }
}