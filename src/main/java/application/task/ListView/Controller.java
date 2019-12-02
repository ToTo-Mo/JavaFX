package application.task.ListView;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;

public class Controller implements Initializable {

    @FXML
    private ListView<String> rightList;

    @FXML
    private Button next;

    @FXML
    private Button previous;

    @FXML
    private ListView<String> leftList;

    private String[] num;

    public String[] setNum(int size) {
        String[] temp = new String[size];

        for (int i = 0; i < size; i++)
            temp[i] = Integer.toString(i + 1);

        return temp;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // TODO Auto-generated method stub
        num = setNum(10);

        leftList.getItems().setAll(num);
        leftList.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        rightList.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);

        next.setOnMouseClicked(event -> {
            ObservableList<String> items = FXCollections
                    .observableArrayList(leftList.getSelectionModel().getSelectedItems());

            leftList.getItems().removeAll(items);
            rightList.getItems().addAll(items);
            leftList.getSelectionModel().clearSelection();
        });

        previous.setOnMouseClicked(event -> {
            ObservableList<String> items = FXCollections
                    .observableArrayList(rightList.getSelectionModel().getSelectedItems());

            rightList.getItems().removeAll(items);
            leftList.getItems().addAll(items);
            rightList.getSelectionModel().clearSelection();
        });
    }

}
