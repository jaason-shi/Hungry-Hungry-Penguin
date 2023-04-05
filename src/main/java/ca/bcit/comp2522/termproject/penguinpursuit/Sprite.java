package ca.bcit.comp2522.termproject.penguinpursuit;

import javafx.scene.image.Image;
import javafx.scene.canvas.GraphicsContext;

import java.util.ArrayList;

public class Sprite {
    public Vector position;
    public Vector speed;
    public Image image;
    public Rectangle boundary;

    public Sprite() {
        position = new Vector(0, 0);
        speed = new Vector(0, 0);
        boundary = new Rectangle(0, 0, 0, 0);
    }

    public void setImage(String fileName) {
        image = new Image(fileName);
        boundary.width = image.getWidth();
        boundary.height = image.getHeight();
    }

    public Rectangle getBoundary() {
        boundary.xCoordinate = position.xCoordinate;
        boundary.yCoordinate = position.yCoordinate;
        return boundary;
    }

    public boolean intersects(Sprite other) {
        return this.getBoundary().intersects(other.getBoundary());
    }

    public void render(GraphicsContext context) {
        context.drawImage(image, position.xCoordinate, position.yCoordinate);
    }

    public boolean intersectsAny(ArrayList<Sprite> others) {
        for (Sprite other : others) {
            if (this.intersects(other)) {
                return true;
            }
        }
        return false;
    }
}
