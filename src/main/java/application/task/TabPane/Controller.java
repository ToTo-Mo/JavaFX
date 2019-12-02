package application.task.TabPane;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.CheckBox;

public class Controller implements Initializable {

    @FXML
    private CheckBox checkBox;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // TODO Auto-generated method stub

        checkBox.selectedProperty().addListener(listener -> {
            if (checkBox.isSelected() == true)
                System.out.println(checkBox.getText() + "is selected");
            else
                System.out.println(checkBox.getText() + "is deselected");
        });
    }
}
