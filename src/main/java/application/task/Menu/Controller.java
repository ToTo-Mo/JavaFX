package application.task.Menu;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.paint.Color;
import javafx.scene.control.CheckMenuItem;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.scene.control.RadioMenuItem;
import javafx.scene.control.ToggleGroup;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;

public class Controller implements Initializable {
    @FXML
    private Menu file;
    @FXML
    private Menu format;
    @FXML
    private MenuItem about;
    @FXML
    private MenuItem exit;
    @FXML
    private Menu color;
    @FXML
    private RadioMenuItem red;
    @FXML
    private ToggleGroup color_toggle;
    @FXML
    private RadioMenuItem blue;
    @FXML
    private RadioMenuItem green;
    @FXML
    private RadioMenuItem black;
    @FXML
    private Menu font;
    @FXML
    private RadioMenuItem arial;
    @FXML
    private ToggleGroup font_toggle;
    @FXML
    private RadioMenuItem cambria;
    @FXML
    private RadioMenuItem corbol;
    @FXML
    private CheckMenuItem bold;
    @FXML
    private CheckMenuItem italic;
    @FXML
    private Label text;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        text.setFont(Font.font("Corbel", FontPosture.REGULAR, 72));

        about.setOnAction(action ->{
            Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("About"); 	
			alert.setHeaderText(null);
			alert.setContentText("메뉴 예제 프로그램입니다.");
			alert.showAndWait();
        });

        exit.setOnAction(action -> System.exit(0));

        bold.setOnAction(action -> setFont());
        italic.setOnAction(action -> setFont());

        arial.setOnAction(action -> {
            text.setFont(Font.font("Arial",72));
            setFont();
        });

        corbol.setOnAction(action ->{
            text.setFont(Font.font("Corbel",72));
            setFont();
        });

        cambria.setOnAction(action ->{
            text.setFont(Font.font("Cambria",72));
            setFont();
        });

        red.setOnAction(action ->{
            text.setTextFill(Color.RED);
        });

        green.setOnAction(action ->{
            text.setTextFill(Color.GREEN);
        });

        blue.setOnAction(action->{
            text.setTextFill(Color.BLUE);
        });

        black.setOnAction(action->{
            text.setTextFill(Color.BLACK);
        });
    }

    private void setFont() {
		text.setFont(Font.font(text.getFont().getFamily(),
				bold.isSelected() ? FontWeight.BOLD : FontWeight.NORMAL,
				italic.isSelected() ?  FontPosture.ITALIC : FontPosture.REGULAR, 64));
	}


}