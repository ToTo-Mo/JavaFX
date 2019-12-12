package application.task.KeyboardGame;

import java.util.Random;
import java.util.Timer;

import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.shape.Rectangle;

public class Unit {
    Random random = new Random();
    Timer timer = new Timer();

    Point point;
    int DELTA;

    int width;
    int height;

    Label skin;

    public Unit(int x, int y, int width, int height, int DELTA) {
        this.DELTA = DELTA;
        point = new Point(x, y);
        this.width = width;
        this.height = height;
    }

    public String move(KeyCode keyCode) {
        switch (keyCode) {
        case W:
            point.setY(point.getY() - DELTA);
            if (point.getY() <= 0)
                point.setY(0);
            break;
        case S:
            point.setY(point.getY() + DELTA);
            if (point.getY() >= GameManaer.frameHeight - height)
                point.setY(GameManaer.frameHeight - height);
            break;
        case A:
            point.setX(point.getX() - DELTA);
            if (point.getX() <= 0)
                point.setX(0);
            break;
        case D:
            point.setX(point.getX() + DELTA);
            if (point.getX() >= GameManaer.frameWidth - width)
                point.setX(GameManaer.frameWidth - width);
            break;
        }

        skin.setLayoutX(point.getX());
        skin.setLayoutY(point.getY());

        return "red X : " + point.getX() + ", Y : " + point.getY();
    }

    public void runAway() {
        int direction = random.nextInt(4) + 1;

        /*  direction
            1 : left
            2 : right;
            3 : up;
            4 : down;
        */
        switch (direction) {
        case 1:
            point.setX(point.getX() - DELTA);
            if (point.getX() <= 0)
                point.setX(0);
            break;
        case 2:
            point.setX(point.getX() + DELTA);
            if (point.getX() >= GameManaer.frameWidth - width)
                point.setX(GameManaer.frameWidth - width);
            break;
        case 3:
            point.setY(point.getY() - DELTA);
            if (point.getY() <= 0)
                point.setY(0);
            break;
        case 4:
            point.setY(point.getY() + DELTA);
            if (point.getY() >= GameManaer.frameHeight - height)
                point.setY(GameManaer.frameHeight - height);
            break;
        }

        skin.setLayoutX(point.getX());
        skin.setLayoutY(point.getY());
    }

   

    public void setSkin(Label skin){
        this.skin = skin;
        this.skin.setLayoutX(point.getX());
        this.skin.setLayoutY(point.getY());
    }

    public int getWidth(){
        return width;
    }

    public int getHeight(){
        return height;
    }

    public int getX(){
        return point.getX();
    }

    public int getY(){
        return point.getY();
    }

    public Label getSkin(){
        return skin;
    }
}

class Point {
    private int x, y;

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Point getLocation() {
        return this;
    }

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }
}