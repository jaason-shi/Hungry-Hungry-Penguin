package ca.bcit.comp2522.termproject.penguinpursuit;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.util.Random;

public class Fish {
    private ImageView imageView;
    private int xCoordinate;
    private int yCoordinate;

    public Fish() {
        Image fishImage = new Image("fish.png");
        imageView = new ImageView(fishImage);
        Random random = new Random();
        xCoordinate = random.nextInt(600) + 100;
        yCoordinate = random.nextInt(800) + 100;
        imageView.setX(xCoordinate);
        imageView.setY(yCoordinate);
    }

    public ImageView getImageView() {
        return imageView;
    }

    public int getXCoordinate() {
        return xCoordinate;
    }

    public int getYCoordinate() {
        return yCoordinate;
    }
}
