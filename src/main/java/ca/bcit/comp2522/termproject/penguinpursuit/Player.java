package ca.bcit.comp2522.termproject.penguinpursuit;

import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
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
    private Rectangle square;

    public Player(int width, int height, Direction direction) {
        this.xCoordinate = 25;
        this.yCoordinate = 500;
        this.width = width;
        this.height = height;
        this.speed = 2;
        this.direction = direction;
        this.canJump = true;

        square = new Rectangle(xCoordinate, yCoordinate, width, height);
        square.setFill(Color.BLUE);
    }

    public Image getCharacter() {
        return character;
    }

    Image character = new Image("icon.png");


    public int getxCoordinate() {
        return xCoordinate;
    }

    public int getyCoordinate() {
        return yCoordinate;
    }

    public void jump() {
        for (int i = 0; i < 10; i++) {
            yCoordinate -= 1;
        }
    }

    public void moveLeft(){
    xCoordinate -= speed;
    }

    public void moveRight(){
    xCoordinate += speed;
    }
    public void moveUp(){
    yCoordinate -= speed;
    }
    public void moveDown(){
    yCoordinate += speed;
    }

    public Rectangle getSquare() {
        return square;
    }

    public boolean collisionDetection(ArrayList<Rectangle> obstacles) {
        for (Rectangle obstacle: obstacles) {
            if (square.getBoundsInParent().intersects(obstacle.getBoundsInParent())) {
                return true;
            }
        }
        return false;
    }

}
