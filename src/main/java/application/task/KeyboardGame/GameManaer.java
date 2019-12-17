package application.task.KeyboardGame;

import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.paint.Stop;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class GameManaer extends Application {

    static int frameWidth = 500;
    static int frameHeight = 500;

    static Unit player;
    static Unit computer;

    int PLAYER_DELTA = 10;
    int COMPUTER_DELTA = 100;

    Random random = new Random();
    static Timer timer = new Timer();
    FXMLLoader loader;

    @Override
    public void start(Stage primaryStage) throws Exception {
        loader = new FXMLLoader(getClass().getResource("/application/task/KeyboardGame/keyboardGame.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root, 500, 520);
        primaryStage.setTitle("Keyboard");
        primaryStage.setScene(scene);
        primaryStage.show();

        initilizeGame();
    }

    public static void main(String[] args) {
        launch();

    }

    public void initilizeGame() {
        int width = 50;
        int height = 50;

        Label player_skin = ((Controller)(loader.getController())).getRed_skin();
        Label computer_skin =  ((Controller)(loader.getController())).getBlue_skin();

        player = new Unit(random.nextInt(frameWidth), random.nextInt(frameHeight), width,height,PLAYER_DELTA);
        computer = new Unit(random.nextInt(frameWidth), random.nextInt(frameHeight),width,height, COMPUTER_DELTA);

        player.setSkin(player_skin);
        computer.setSkin(computer_skin);

        TimerTask task = new TimerTask(){
            public void run(){
                computer.runAway();
            }
        };

        timer.scheduleAtFixedRate(task, 0,1000);
    }

    public static boolean isCatched(Unit source,Unit target){
        Rectangle field = new Rectangle();

        field.setWidth(target.getSkin().getWidth());
        field.setHeight(target.getSkin().getHeight());

        field.setX(target.getSkin().getLayoutX());
        field.setY(target.getSkin().getLayoutY());

        return field.intersects(source.getSkin().getLayoutX(),source.getSkin().getLayoutY(),source.getSkin().getWidth(),source.getSkin().getHeight());
    }

    public static void exit() {
        timer.cancel();

        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("종료");
        alert.setHeaderText(null);
        alert.setContentText("잡았습니다!");
        alert.showAndWait();
        
        System.exit(0);
    }
}