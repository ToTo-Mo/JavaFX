package application.task.KeyboardGame;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        // TODO Auto-generated method stub
        Parent root = FXMLLoader.load(getClass().getResource("/application/task/KeyboardGame/keyboardGame.fxml"));
        Scene scene = new Scene(root,500,520);
        primaryStage.setTitle("Keyboard");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args){
        launch();

    }

}

class Point{
    private int x, y;

    public int getX() {
        return x;
    }
    public int getY() {
        return y;
    }

    public Point getLocation(){
        return this;
    }

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}