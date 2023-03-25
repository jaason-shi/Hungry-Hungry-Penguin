package ca.bcit.comp2522.termproject.penguinpursuit;

public class Player {
    private int xCoordinate;
    private int yCoordinate;
    private int width;
    private int height;
    private int speed = 2;
    private Direction direction;
    public Player(int xCoordinate, int yCoordinate, int width, int height, int speed, Direction direction) {
        this.xCoordinate = xCoordinate;
        this.yCoordinate = yCoordinate;
        this.width = width;
        this.height = height;
        this.speed = speed;
        this.direction = direction;
    }

    public void movePlayer() {
        switch (direction) {
            case UP:
                yCoordinate -= speed;
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
}
