package ca.bcit.comp2522.termproject.penguinpursuit;

/**
 * The Rectangle class.
 *
 * @author Jason Shi and Natalie Yu
 * @version 2023-04
 */
public class Rectangle {

    /**
     * The x-coordinate of the top-left corner of the rectangle.
     */
    public double xCoordinate;

    /**
     * The y-coordinate of the top-left corner of the rectangle.
     */
    public double yCoordinate;

    /**
     * The width of the rectangle.
     */
    public double width;

    /**
     * The height of the rectangle.
     */
    public double height;

    /**
     * The Rectangle constructor that creates a new Rectangle object with specified coordinates and dimensions.
     *
     * @param xCoordinate the x-coordinate of the top-left corner of the rectangle
     * @param yCoordinate the y-coordinate of the top-left corner of the rectangle
     * @param width the width of the rectangle
     * @param height the height of the rectangle
     */
    public Rectangle(final double xCoordinate, final double yCoordinate, final double width, final double height) {
        this.xCoordinate = xCoordinate;
        this.yCoordinate = yCoordinate;
        this.width = width;
        this.height = height;
    }

    /**
     * Returns true if this rectangle intersects with another rectangle.
     *
     * @param other the other Rectangle object to check for an intersection with
     * @return true if this rectangle intersects with another rectangle, false otherwise
     */
    public boolean intersects(final Rectangle other) {
        boolean noOverlap = this.xCoordinate + this.width < other.xCoordinate
                || other.xCoordinate + other.width < this.xCoordinate
                || this.yCoordinate + this.height < other.yCoordinate
                || other.yCoordinate + other.height < this.yCoordinate;
        return !noOverlap;
    }
}
