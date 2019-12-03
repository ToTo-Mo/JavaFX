package application.Container.TableView;

import java.net.URL;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXTreeTableView;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class Controller implements Initializable {

    @FXML
    private TableView<Product> table;
    @FXML
    private TableColumn<Product,String> nameColumn;
    @FXML
    private TableColumn<Product,Integer> priceColumn;
    @FXML
    private TableColumn<Product,String> discriptionColumn;

    ObservableList<Product> products;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // TODO Auto-generated method stub

        products = FXCollections.observableArrayList(
            new Product("배",5600,"xx사에서 만든 올해 최고의 장난감")
        );

        // Column 초기화
        nameColumn.setCellValueFactory();

        // Column 초기화

    }
}
