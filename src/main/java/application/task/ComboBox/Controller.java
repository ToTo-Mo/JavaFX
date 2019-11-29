package application.task.ComboBox;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

public class Controller implements Initializable {

    @FXML
    private ComboBox<String> comboBox;

    @FXML
    private TextArea list;

    String num[] = { "2", "3", "4", "5", "6", "7", "8", "9" };

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // TODO Auto-generated method stub
        comboBox.getItems().addAll(num);

        comboBox.setOnAction(event -> {
            int dan = Integer.parseInt((String) comboBox.getValue());
            String res = "";

            for (int i = 1; i <= 9; i++) {
                res += dan + " * " + i + " = " + dan * i + "\n";
                list.setText(res);
            }
        });
    }

    public void display(Stage primaryStage) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/application/task/ComboBox/comboBox.fxml"));
        var scene = new Scene(root);
        var stage = primaryStage;
        stage.setScene(scene);
        stage.show();
    }

}
