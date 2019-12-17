package application.Graphics.Image;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import javafx.application.Application;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage stage) {
        // 이미지 로딩
        Image image = new Image("비둘기.jpg");

        // 이미지 그대로 출력
        ImageView iv1 = new ImageView();
        iv1.setImage(image);

        // 표시될 이미지의 폭을 지정. 이 때 가로세로 비율을 지키도록 지정. 또한 이미지 크기가 달라지면서 스무딩 효과를 주도록
        ImageView iv2 = new ImageView();
        iv2.setImage(image);
        iv2.setPreserveRatio(true);
        iv2.setSmooth(true);
        iv2.setFitWidth(200);

        // 뷰포트를 지정한 후 90도 회전토록
        ImageView iv3 = new ImageView();
        iv3.setImage(image);
        Rectangle2D viewportRect = new Rectangle2D(600, 600, 200, 200);
        iv3.setViewport(viewportRect);
        iv3.setRotate(90);

        HBox box = new HBox();
        box.getChildren().add(iv1);
        box.getChildren().add(iv2);
        box.getChildren().add(iv3);
        Scene scene = new Scene(box);

        GraphicsContext gc = new Canvas(iv1.getFitWidth(), iv1.getFitHeight()).getGraphicsContext2D();
        gc.fillText(image.getUrl(), 0, 0);

        stage.setTitle("ImageView");
        stage.setWidth(800);
        stage.setHeight(800);
        stage.setScene(scene);
        stage.sizeToScene();
        stage.show();

        FileChooser fileChooser = new FileChooser();
        File file = fileChooser.showSaveDialog(scene.getWindow());
        // fileChooser.getExtensionFilters(
        //     new FileChooser.ExtensionFilter("file", "*.png")
        // );

        try {
            Files.write(Paths.get(file.getPath()), Files.readAllBytes(Paths.get(image.getUrl())));
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Application.launch(args);
    }
}