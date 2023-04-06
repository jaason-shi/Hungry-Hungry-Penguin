package ca.bcit.comp2522.termproject.penguinpursuit;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

/**
 * The Vector class.
 *
 * @author Natalie Yu and Jason Shi
 * @version 2023-04
 */
public class Wall extends Rectangle {
    /**
     * Creates a new Wall object with specified coordinates and dimensions.
     *
     * @param x the x-coordinate of the top-left corner of the rectangle
     * @param y the y-coordinate of the top-left corner of the rectangle
     * @param width the width of the rectangle
     * @param height the height of the rectangle
     */
    public Wall(final double x, final double y, final double width, final double height) {
        super(x, y, width, height);
        setFill(Color.BLACK);
    }
}
