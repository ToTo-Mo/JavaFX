package application.Pixel.Processing.Lightter;

import java.io.File;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.ScrollPane.ScrollBarPolicy;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.PixelReader;
import javafx.scene.image.PixelWriter;
import javafx.scene.image.WritableImage;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class Main extends Application {
    @Override
    public void start(Stage primaryStage) {
        Button btn = new Button();
        ImageView imageView = new ImageView();
        ScrollPane scrollPane1 = setScroll(imageView, 250, 250);
        ImageView imageViewDest = new ImageView();
        ScrollPane scrollPane2 = setScroll(imageViewDest, 250, 250);
        Label label = new Label();

        imageView.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                imageView.setImage(null);
                imageViewDest.setImage(null);
                label.setText("");
            }
        });
        btn.setText("Load image");
        btn.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                FileChooser fileChooser = new FileChooser();
                File file = fileChooser.showOpenDialog(null);
                Image image = new Image(file.toURI().toString());
                imageView.setImage(image);

                // copy image
                PixelReader pixelReader = image.getPixelReader();
                WritableImage writableImage = new WritableImage((int) image.getWidth(), (int) image.getHeight());
                PixelWriter pixelWriter = writableImage.getPixelWriter();

                for (int y = 0; y < image.getHeight(); y++) {
                    for (int x = 0; x < image.getWidth(); x++) {
                        Color color = pixelReader.getColor(x, y);
                        color = color.brighter();
                        pixelWriter.setColor(x, y, color);
                    }
                }

                imageViewDest.setImage(writableImage);

                label.setText(image.getWidth() + " x " + image.getHeight());
            }
        });

        VBox vBox = new VBox();
        vBox.getChildren().addAll(btn, scrollPane1, scrollPane2, label);
        StackPane root = new StackPane();
        root.getChildren().addAll(vBox);

        Scene scene = new Scene(root, 800, 550);

        primaryStage.setTitle("test");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private ScrollPane setScroll(ImageView imageView, int w, int h) {
        ScrollPane scrollPane = new ScrollPane();
        scrollPane.setPrefSize(w, h);
        scrollPane.setVbarPolicy(ScrollBarPolicy.AS_NEEDED);
        scrollPane.setHbarPolicy(ScrollBarPolicy.AS_NEEDED);
        scrollPane.setContent(imageView);
        return scrollPane;
    }

    public static void main(String[] args) throws Throwable {
        launch(args);
    }
}