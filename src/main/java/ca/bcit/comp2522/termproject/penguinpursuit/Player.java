package ca.bcit.comp2522.termproject.penguinpursuit;

import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Rectangle;

import java.util.ArrayList;

public class Player extends Rectangle{
    private int xCoordinate;
    private int yCoordinate;
    private int width;
    private int height;
    private int speed;
    private Direction direction;
    private boolean canJump;
    private ImageView penguin;

    public Player(int width, int height, Direction direction) {
        this.xCoordinate = 50;
        this.yCoordinate = 507;
        this.width = width;
        this.height = height;
        this.speed = 2;
        this.direction = direction;
        this.canJump = true;

        Image penguinImage = new Image("penguin.png");
        penguin = new ImageView(penguinImage);
        penguin.setX(xCoordinate);
        penguin.setY(yCoordinate);
        penguin.setFitWidth(width);
        penguin.setFitHeight(height);
    }

    public ImageView getPenguin() {
        return penguin;
    }

    public int getXCoordinate() {
        return xCoordinate;
    }

    public int getYCoordinate() {
        return yCoordinate;
    }

    public void moveLeft(){
        if(getXCoordinate() > 0) {
            xCoordinate -= 7;
        }
    }

    public void moveRight(Scene scene){
        if(getXCoordinate() < scene.getWidth() - penguin.getFitWidth()) {
            xCoordinate += 7;
        }
    }


    public void moveUp(ArrayList<Platform> platforms) {
        for (Platform platform : platforms) {
            if (penguin.getBoundsInParent().intersects(platform.getIcePlatform().getBoundsInParent())) {
                yCoordinate = (int) (platform.getIcePlatform().getY() + platform.getIcePlatform().getFitHeight());
                return;
            }
        }
        if (getYCoordinate() > 0) {
            yCoordinate -= 7;
        }
    }



    public void moveDown(Scene scene){
        if(getYCoordinate() < scene.getHeight() - penguin.getFitHeight()) {
            yCoordinate += 7;
        }
    }
public Rectangle2D getBounds() {
        return new Rectangle2D(getX(), getY(), getWidth(), getHeight());
}

//    public boolean collisionDetection(ArrayList<Rectangle> obstacles) {
//        for (Rectangle obstacle: obstacles) {
//            if (penguin.getBoundsInParent().intersects(obstacle.getBoundsInParent())) {
//                return true;
//            }
//        }
//        return false;
//    }

}
