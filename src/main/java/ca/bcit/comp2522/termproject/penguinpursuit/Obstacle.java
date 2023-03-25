package ca.bcit.comp2522.termproject.penguinpursuit;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import java.util.ArrayList;


public class Obstacle {

    private ArrayList<Rectangle> obstacles = new ArrayList<>();

    public void addObstacle(int xCoordinate, int yCoordinate, int width, int height) {
        Rectangle obstacle = new Rectangle(xCoordinate, yCoordinate, width, height);
        obstacle.setFill(Color.ALICEBLUE);
        obstacles.add(obstacle);
    }

    public ArrayList<Rectangle> getObstacles() {
        return obstacles;
    }

//    private Rectangle obstacle;

//    public Obstacle(int xCoordinate, int yCoordinate, int width, int height) {
//        Rectangle obstacle = new Rectangle(xCoordinate, yCoordinate, width, height);
//        obstacle.setFill(Color.ALICEBLUE);
//    }


//    public void moveObstacles() {
//        ArrayList<Rectangle> outOfScreen = new ArrayList<>();
//
//        for (Rectangle rectangle : obstacles) {
//            if (rectangle.getX() < 0) {
//                outOfScreen.add(rectangle);
//            }
//            rectangle.setX(rectangle.getX() - 1);
//        }
//    }
}
