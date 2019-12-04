package application.MenuBar;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.input.KeyCombination;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        // TODO Auto-generated method stub
        Pane root = new Pane();

        MenuBar menuBar = new MenuBar();
        Menu file = new Menu("_File");
        MenuItem open = new MenuItem("_open");
        MenuItem save = new MenuItem("_save");
        file.setMnemonicParsing(true);
        file.getItems().addAll(open,save);

        open.setAccelerator(KeyCombination.keyCombination("SHORTCUT + o"));

        Menu game = new Menu("_Game");
        MenuItem start = new MenuItem("_start");
        MenuItem close = new MenuItem("_close");
        game.setMnemonicParsing(true);
        game.getItems().addAll(start,close);

        Menu info = new Menu("정보(_i)");
        info.setMnemonicParsing(true);

        menuBar.getMenus().addAll(file,game,info);
        root.getChildren().add(menuBar);

        Scene scene = new Scene(root,100,100);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args){
        launch();
    }
}