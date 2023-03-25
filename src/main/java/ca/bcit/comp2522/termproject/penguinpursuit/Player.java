package ca.bcit.comp2522.termproject.penguinpursuit;

public class Player {
    private int xCoordinate;
    private int yCoordinate;
    private int width;
    private int height;
    private int speed;
    private Direction direction;
    public Player(int xCoordinate, int yCoordinate, int width, int height, int speed, Direction direction) {
        this.xCoordinate = xCoordinate;
        this.yCoordinate = yCoordinate;
        this.width = width;
        this.height = height;
        this.speed = speed;
        this.direction = direction;
    }

    public int xCoordinate() {
        return xCoordinate;
    }

    public int yCoordinate() {
        return yCoordinate;
    }

    public void movePlayer() {
        if (direction == Direction.UP) {
            yCoordinate -= speed;
        } else if (direction == Direction.DOWN) {
            yCoordinate += speed;
        } else if (direction == Direction.LEFT) {
            xCoordinate -= speed;
        } else if (direction == Direction.RIGHT) {
            xCoordinate += speed;
        }
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

//    public void jump
}
