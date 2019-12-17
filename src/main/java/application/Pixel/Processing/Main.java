package application.Pixel.Processing;

import java.nio.IntBuffer;

import javafx.scene.image.Image;
import javafx.scene.image.PixelFormat;
import javafx.scene.image.PixelReader;
import javafx.scene.image.PixelWriter;
import javafx.scene.image.WritableImage;
import javafx.scene.image.WritablePixelFormat;

public class Main {

    public static void main(String[] args) {
        Image image = new Image("src/main/java/image/펭수2.jpg");
        PixelReader pixelReader = image.getPixelReader();

        WritableImage writableImage = new WritableImage((int) image.getWidth(), (int) image.getHeight());
        PixelWriter pixelWriter = writableImage.getPixelWriter();
        
        
    }

    public int[] getPixels(Image img, int x, int y, int w, int h) {
        int[] pixels = new int[w * h];

        PixelReader reader = img.getPixelReader();
        PixelFormat.Type type = reader.getPixelFormat().getType();

        WritablePixelFormat<IntBuffer> format = null;

        if (type == PixelFormat.Type.INT_ARGB_PRE)
            format = PixelFormat.getIntArgbPreInstance();
        else
            format = PixelFormat.getIntArgbInstance();

        reader.getPixels(x, y, w, h, format, pixels, 0, w);
        return pixels;
    }

}