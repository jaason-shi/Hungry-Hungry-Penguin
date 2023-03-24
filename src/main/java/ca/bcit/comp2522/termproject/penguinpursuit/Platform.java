package ca.bcit.comp2522.termproject.penguinpursuit;

import javafx.scene.shape.Rectangle;

import java.util.ArrayList;

public class Platform {
    private ArrayList<Rectangle> platforms = new ArrayList<>();

    public void addPlatform(int xCoord, int yCoord, int width, int height) {
        Rectangle platform = new Rectangle(xCoord, yCoord, width, height);
        platforms.add(platform);
    }

    public ArrayList<Rectangle> getPlatforms() {
        return platforms;
    }
}

