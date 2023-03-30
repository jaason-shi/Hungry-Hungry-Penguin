package ca.bcit.comp2522.termproject.penguinpursuit;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Rectangle;

import java.util.ArrayList;

public class Platform {
    private ArrayList<Rectangle> platforms = new ArrayList<>();
    private ImageView icePlatform;

    public void addPlatform(int xCoord, int yCoord, int width, int height) {
        Rectangle platform = new Rectangle(xCoord, yCoord, width, height);
        platforms.add(platform);

        Image icePlatformImage = new Image("ice-platform.png");
        icePlatform = new ImageView(icePlatformImage);
        icePlatform.setX(xCoord);
        icePlatform.setY(yCoord);
        icePlatform.setFitWidth(width);
        icePlatform.setFitHeight(height);
    }

    public ArrayList<Rectangle> getPlatforms() {
        return platforms;
    }

    public ImageView getIcePlatform() {
        return icePlatform;
    }

//    public boolean collisionDetection(Player penguin) {
//        for (platform: getPlatforms()) {
//            if (penguin.getBoundsInParent().intersects(platform.getBoundsInParent())) {
//                return true;
//            }
//        }
//        return false;
//    }
}

