package ca.bcit.comp2522.termproject.penguinpursuit;

import javafx.scene.image.Image;
import javafx.scene.canvas.GraphicsContext;
import java.util.ArrayList;

/**
 * The Sprite class.
 *
 * @author Natalie Yu and Jason Shi
 * @version 2023-04
 */
public class Sprite {

    /**
     * The position of the sprite.
     */
    public Vector position;

    /**
     * The speed of the sprite.
     */
    public Vector speed;

    /**
     * The image of the sprite.
     */
    public Image image;

    /**
     * The boundary of the sprite.
     */
    public Rectangle boundary;

    /**
     * Creates a new instance of Sprite with specified coordinates, speed, and boundaries.
     */
    public Sprite() {
        position = new Vector(0, 0);
        speed = new Vector(0, 0);
        boundary = new Rectangle(0, 0, 0, 0);
    }

    /**
     * Sets the image of the sprite.
     *
     * @param fileName the name of the image file
     */
    public void setImage(final String fileName) {
        image = new Image(fileName);
        boundary.width = image.getWidth();
        boundary.height = image.getHeight();
    }

    /**
     * Gets the boundary of the sprite.
     *
     * @return the boundary of the sprite as a Rectangle
     */
    public Rectangle getBoundary() {
        boundary.xCoordinate = position.xCoordinate;
        boundary.yCoordinate = position.yCoordinate;
        return boundary;
    }

    /**
     * Checks if the sprite intersects with another sprite.
     *
     * @param other the other sprite to check for intersection
     * @return true if the sprites intersect, else false
     */
    public boolean intersects(final Sprite other) {
        return this.getBoundary().intersects(other.getBoundary());
    }

    /**
     * Renders the sprite on a graphics context.
     *
     * @param context context to render the sprite on
     */
    public void render(final GraphicsContext context) {
        context.drawImage(image, position.xCoordinate, position.yCoordinate);
    }

    /**
     * Checks if the sprite intersects with any of the sprites in a list.
     *
     * @param others the list of sprites to check for intersection
     * @return true if the sprite intersects with any of the sprites in the list, else false
     */
    public boolean intersectsAny(final ArrayList<Sprite> others) {
        for (Sprite other : others) {
            if (this.intersects(other)) {
                return true;
            }
        }
        return false;
    }
}
