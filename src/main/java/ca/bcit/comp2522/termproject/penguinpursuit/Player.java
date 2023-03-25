package ca.bcit.comp2522.termproject.penguinpursuit;

import javafx.scene.Node;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Player {
    private int xCoordinate;
    private int yCoordinate;
    private int width;
    private int height;
    private int speed;
    private Direction direction;
    private boolean canJump;
    private Rectangle square;

    public Player(int xCoordinate, int yCoordinate, int width, int height, int speed, Direction direction) {
        this.xCoordinate = xCoordinate;
        this.yCoordinate = yCoordinate;
        this.width = width;
        this.height = height;
        this.speed = 2;
        this.direction = direction;
        this.canJump = true;

        square = new Rectangle(xCoordinate, yCoordinate, width, height);
        square.setFill(Color.BLUE);
    }

    public void movePlayer() {
        switch (direction) {
            case UP:
                if(canJump) {
                    jump();
                    canJump = false;
                }
                break;
            case DOWN:
                yCoordinate += speed;
                break;
            case LEFT:
                xCoordinate -= speed;
                break;
            case RIGHT:
                xCoordinate += speed;
                break;
            default:
                break;
        }
    }

    public void jump() {
        for (int i = 0; i < 10; i++) {
            yCoordinate -= 1;
        }
    }

    public Rectangle getSquare() {
        return square;
    }

}
