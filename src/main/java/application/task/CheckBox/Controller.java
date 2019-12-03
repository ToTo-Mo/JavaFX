package application.task.CheckBox;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class Controller implements Initializable {

    @FXML
    private CheckBox speed;

    @FXML
    private CheckBox large;

    @FXML
    private TextField text;

    @FXML
    private Button calculate;

    @FXML
    private Label result;

    double add1;
    double add2;
    double sum;
    double page;
    double cost = 1000;

    Stage stage;
    Scene scene;
    Parent root;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        page = 0;
        sum = 0;

        calculate.setOnAction(event -> {
            showResult(calculate());
        });
    }

    private double calculate() {

        sum = 0;
        add1 = 0;
        add2 = 0;

        if(!text.getText().trim().isEmpty())
            page = Double.parseDouble(text.getText());

        add1 = speed.isSelected() ? page * cost * 0.5 : 0;

        add2 = large.isSelected() ? page * cost * 0.3 : 0;

        sum += cost * page + add1 + add2;
        return sum;
    }

    private void showResult(Double value) {
        result.setText(Double.toString(value));
    }

    public void display(Stage primaryStage) throws Exception {
        root = FXMLLoader.load(getClass().getResource("/application/task/CheckBox/checkBox.fxml"));
        scene = new Scene(root);
        stage = primaryStage;

        stage.setScene(scene);
        stage.show();
    }

}
