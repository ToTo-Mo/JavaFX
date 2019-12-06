package application.Dialog.FileChooser;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javafx.application.Application;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class Main extends Application implements EventHandler {
    private Scene scene;
    private Label imgLabel;
    private MenuBar mb;
    
    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("FileChooser");
        try {
            GridPane root = new GridPane();
            imgLabel = new Label();
            mb = new MenuBar();
            mb.prefWidthProperty().bind(primaryStage.widthProperty());
            createMenu();
            root.add(imgLabel, 0, 1);
            root.getChildren().addAll(mb);
            scene = new Scene(root, 500, 500);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void createMenu() {
        Menu file = new Menu("파일");
        MenuItem openItem = new MenuItem("열기");
        openItem.setOnAction(this);
        file.getItems().add(openItem);
        mb.getMenus().add(file);
    }
    @Override
    public void handle(Event e) {
        FileChooser fileChooser = new FileChooser();
        // 지원할 확장자 추가
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("BMP File (*.bmp)", "*.bmp"),
                new FileChooser.ExtensionFilter("JPG File (*.jpg)", "*.jpg"),
                new FileChooser.ExtensionFilter("GIF File (*.gif)", "*.gif"));
        File file = fileChooser.showOpenDialog(null);
        if (file != null) {
            FileInputStream inputstream;
            try {
                inputstream = new FileInputStream(file);
                Image image = new Image(inputstream);
                imgLabel.setGraphic(new ImageView(image));
            } catch (FileNotFoundException e1) {
                e1.printStackTrace();
            }
        }
    }
    public static void main(String[] args) {
        launch(args);
    }
}