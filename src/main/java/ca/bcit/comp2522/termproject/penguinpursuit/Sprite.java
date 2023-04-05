package ca.bcit.comp2522.termproject.penguinpursuit;

import javafx.scene.image.Image;
import javafx.scene.canvas.GraphicsContext;

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
        boundary.x = position.x;
        boundary.y = position.y;
        return boundary;
    }

    public boolean intersects(Sprite other) {
        return this.getBoundary().intersects(other.getBoundary());
    }

    public void render(GraphicsContext context) {
        context.drawImage(image, position.x, position.y);
    }
}
