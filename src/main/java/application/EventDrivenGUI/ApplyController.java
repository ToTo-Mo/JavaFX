package application.EventDrivenGUI;

import java.net.URL;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;

public class ApplyController implements Initializable {

    @FXML
    public AnchorPane show;

    @FXML
    public JFXComboBox<String> university;
    ObservableList<String> list = FXCollections.observableArrayList("Mark", "Tom", "John", "Jack");

    @FXML
    public JFXTextField department;

    @FXML
    public JFXTextField name;

    @FXML
    public JFXTextField phone;

    @FXML
    public JFXButton apply;

    @FXML
    public void initialize(){
        apply.setOnAction(event->{
            Temp.getInstance().name = name.getText();
            Temp.getInstance().university = university.getValue();
            Temp.getInstance().department = department.getText();
            Temp.getInstance().phone = phone.getText();
        });
    }

    public static class Temp {
        public static final Temp temp = new Temp();

        String name;
        String university;
        String department;
        String phone;

        public static Temp getInstance() {
            return temp;
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // TODO Auto-generated method stub
        university.setItems(list);
    }
}
