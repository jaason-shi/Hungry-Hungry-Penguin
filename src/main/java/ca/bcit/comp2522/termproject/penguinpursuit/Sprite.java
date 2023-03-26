package ca.bcit.comp2522.termproject.penguinpursuit;

import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.canvas.GraphicsContext;

public class Sprite {
    public Vector position;
    public Vector velocity;
    public Image image;
    public Rectangle boundary;

    public Sprite() {
        position = new Vector(0, 0);
        velocity = new Vector(0, 0);
        boundary = new Rectangle(0, 0, 0, 0);
    }

    public void setImage(String filename) {
        image = new Image(filename);
        boundary.width = image.getWidth();
        boundary.height = image.getHeight();
    }

    public void setPosition(double x, double y) {
        position.set(x, y);

    }
    public Rectangle getBoundary() {
        boundary.x = position.x;
        boundary.y = position.y;
        return boundary;
    }
    public boolean overlaps(Sprite other) {
        return getBoundary().overlaps(other.getBoundary());
    }

    public void render(GraphicsContext context) {
        context.drawImage(image, position.x, position.y);
    }
}
