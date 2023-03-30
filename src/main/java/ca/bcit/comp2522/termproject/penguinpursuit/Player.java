package ca.bcit.comp2522.termproject.penguinpursuit;

import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Rectangle;

import java.util.ArrayList;

public class Player {
    private int xCoordinate;
    private int yCoordinate;
    private int width;
    private int height;
    private int speed;
    private Direction direction;
    private boolean canJump;
    private ImageView penguin;

    public Player(int width, int height, Direction direction) {
        this.xCoordinate = 25;
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
    public void moveUp(){
        if(getYCoordinate() > 0) {
            yCoordinate -= 7;
        }
    }

    public void moveDown(Scene scene){
        if(getYCoordinate() < scene.getHeight() - penguin.getFitHeight()) {
            yCoordinate += 7;
        }
    }

    public boolean collisionDetection(ArrayList<Rectangle> obstacles) {
        for (Rectangle obstacle: obstacles) {
            if (penguin.getBoundsInParent().intersects(obstacle.getBoundsInParent())) {
                return true;
            }
        }
        return false;
    }

}
