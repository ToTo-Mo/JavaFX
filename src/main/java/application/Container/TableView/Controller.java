package application.Container.TableView;

import java.net.URL;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXTreeTableView;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class Controller implements Initializable {

    @FXML
    private TableView<ProductDataModel> table;
    @FXML
    private TableColumn<ProductDataModel,String> nameColumn;
    @FXML
    private TableColumn<ProductDataModel,Integer> priceColumn;
    @FXML
    private TableColumn<ProductDataModel,String> descriptionColumn;

    ObservableList<ProductDataModel> products = FXCollections.observableArrayList(
        new ProductDataModel(new SimpleStringProperty("로봇"), new SimpleIntegerProperty(1200),new SimpleStringProperty("TV만화 또봇"))
    );


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        nameColumn.setCellValueFactory(cellData -> cellData.getValue().getNameProperty());
        priceColumn.setCellValueFactory(cellData -> cellData.getValue().getPriceProperty().asObject());
        descriptionColumn.setCellValueFactory(cellData -> cellData.getValue().getDecriptionProperty());

        table.setItems(products);

        // Column 초기화

        // Column 초기화

    }
}
