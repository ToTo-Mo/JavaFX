package application.Container.ListView;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class Main extends Application implements EventHandler {

    private String num[] = { "2", "3", "4", "5", "6", "7", "8", "9" };
    private ListView<String> leftList, rightList;
    private ObservableList<String> leftListModel, rightListModel;
    private Button next, previous;

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("test");
        FlowPane root = new FlowPane();

        leftListModel = FXCollections.observableArrayList(num);
        leftList = new ListView<String>(leftListModel);
        leftList.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        leftList.setPrefWidth(150);
        leftList.setPrefHeight(150);
        rightListModel = FXCollections.observableArrayList();
        rightList = new ListView<String>(rightListModel);
        rightList.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        rightList.setPrefWidth(150);
        rightList.setPrefHeight(150);

        next = new Button("next");
        next.setOnAction(this);
        previous = new Button("previous");
        previous.setOnAction(this);

        HBox hBox = new HBox(5);
        hBox.getChildren().addAll(next, previous);
        root.getChildren().addAll(leftList, hBox, rightList);
        root.setAlignment(Pos.CENTER);
        root.setPadding(new Insets(5, 5, 5, 5));
        root.setHgap(5); // 컴포넌트 사이 수평 간격
        root.setVgap(5); // 컴포넌트 사이 수직간격

        Scene scene = new Scene(root, 500, 250);

        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void handle(Event e) {
        if (e.getSource() == next) {
            ObservableList<String> items = FXCollections.observableArrayList(leftList.getSelectionModel().getSelectedItems());

            if (items != null) {
                leftListModel.removeAll(items);
                rightListModel.addAll(items);
                leftList.getSelectionModel().clearSelection();
            }
        } else if (e.getSource() == previous) {
            ObservableList<String> items = FXCollections.observableArrayList(rightList.getSelectionModel().getSelectedItems());

            if (items != null) {
                rightListModel.removeAll(items);
                leftListModel.addAll(items);
                rightList.getSelectionModel().clearSelection();
            }
        }
    }
}
