package application.Pixel.Processing.toColorOrGray;

import javafx.application.Application;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.ScrollPane.ScrollBarPolicy;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.PixelReader;
import javafx.scene.image.PixelWriter;
import javafx.scene.image.WritableImage;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class Main extends Application implements EventHandler {
    private MyImage image;
    private ImageView destImageView;

    @Override
    public void start(Stage primaryStage) {
        HBox root = new HBox();
        Button button = new Button("회색조");
        button.setOnAction(this);
        root.getChildren().add(button);
        Image src = new Image("src/main/java/image/펭수2.jpg");
        ScrollPane srcView = setScroll(new ImageView(src), 300, 300);
        image = new MyImage(src);
        root.getChildren().add(srcView);
        destImageView = new ImageView();
        ScrollPane destView = setScroll(destImageView, 300, 300);
        root.getChildren().add(destView);
        Scene scene = new Scene(root);
        primaryStage.setTitle("test");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    @Override
    public void handle(Event event) {
        WritableImage img = image.convertToBlack();
        destImageView.setImage(img);
    }

    private ScrollPane setScroll(ImageView imageView, int w, int h) {
        ScrollPane scrollPane = new ScrollPane();
        scrollPane.setPrefSize(w, h);
        scrollPane.setVbarPolicy(ScrollBarPolicy.AS_NEEDED);
        scrollPane.setHbarPolicy(ScrollBarPolicy.AS_NEEDED);
        scrollPane.setContent(imageView);
        return scrollPane;
    }

    public static void main(String[] args) {
        launch(args);
    }

}

class MyImage {
    private PixelReader reader;
    private PixelWriter writer;
    int width, height;
    WritableImage dest;

    public MyImage(Image src) {
        reader = src.getPixelReader();
        width = (int) src.getWidth();
        height = (int) src.getHeight();
        dest = new WritableImage(width, height);
        writer = dest.getPixelWriter();

        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {

                int argb = reader.getArgb(x, y);
                writer.setArgb(x, y, argb);
            }
        }
    }

    public WritableImage convertToGray() {

        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                int pixel = reader.getArgb(x, y);
                // 1. 쉬프트 연산자를 이용한 방법
                // [1][2][3][4]
                // [A][R][G][B]

                // x는 쓰레기값,    Alpha : 밝기
                // pixel >> 16 -> pixel & 0xff
                // [Alpha][R][G][B] -> [x][x][A][R] -> [0][0][0][R]
                int red = ((pixel >> 16) & 0xff);
                int green = ((pixel >> 8) & 0xff);
                int blue = (pixel & 0xff);

                // 2. getter를 이용한 방법
                double d_red = reader.getColor(x, y).getRed();
                double d_green = reader.getColor(x, y).getGreen();
                double d_blue = reader.getColor(x, y).getBlue();

                int grayLevel = (int) (0.2162 * (double) red + 0.7152 * (double) green + 0.0722 * (double) blue) / 3;
                grayLevel = 255 - grayLevel;
                int gray = (grayLevel << 16) + (grayLevel << 8) + grayLevel;

                writer.setArgb(x, y, -gray);
            }
        }
        return dest;
    }

    public WritableImage converToBinary(HBox root) {
        return null;
    }

    public WritableImage convertToBlack() {

        double gray_level = 0;
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                double red = reader.getColor(x, y).getRed();
                double blue = reader.getColor(x, y).getBlue();
                double green = reader.getColor(x, y).getGreen();

                gray_level += Math.sqrt((Math.pow(red, 2)) + (Math.pow(blue, 2)) + (Math.pow(green, 2)) / 3);
            }
        }
        gray_level /= (width * height);

        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                double red = reader.getColor(x, y).getRed();
                double blue = reader.getColor(x, y).getBlue();
                double green = reader.getColor(x, y).getGreen();

                double average_gray = Math.sqrt((Math.pow(red, 2)) + (Math.pow(blue, 2)) + (Math.pow(green, 2)) / 3);

                if (gray_level > average_gray)
                    writer.setArgb(x, y, 0xff000000);
                else
                    writer.setArgb(x, y, 0xffffa0bb);

            }
        }

        return dest;
    }
}