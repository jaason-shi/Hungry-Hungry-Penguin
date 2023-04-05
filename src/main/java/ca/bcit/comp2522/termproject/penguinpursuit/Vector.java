package ca.bcit.comp2522.termproject.penguinpursuit;

/**
 * The Vector class.
 *
 * @author Natalie Yu and Jason Shi
 * @version 2023-04
 */
public class Vector {

    /**
     * The x-coordinate of the vector.
     */
    public double xCoordinate;

    /**
     * The y-coordinate of the vector.
     */
    public double yCoordinate;

    /**
     * The Vector constructor that creates a new Vector object with specified coordinates.
     * @param xCoordinate the x-coordinate of the vector
     * @param yCoordinate the y-coordinate of the vector
     */
    public Vector(double xCoordinate, double yCoordinate) {
        this.set(xCoordinate, yCoordinate);
    }

    /**
     * Sets the coordinates of the vector.
     * @param xCoordinate the x-coordinate of the vector
     * @param yCoordinate the y-coordinate of the vector
     */
    public void set(double xCoordinate, double yCoordinate) {
        this.xCoordinate = xCoordinate;
        this.yCoordinate = yCoordinate;
    }

    /**
     * Adds the displacement of movements to the coordinates of the vector.
     * @param dx the displacement of movement in the x-direction
     * @param dy the displacement of movement in the y-direction
     */
    public void add(double dx, double dy) {
        this.xCoordinate += dx;
        this.yCoordinate += dy;
    }

    /**
     * Adds the coordinates of another vector to the coordinates of this vector.
     * @param other the other Vector object to add to this vector
     */
    public void add(Vector other) {
        this.add(other.xCoordinate, other.yCoordinate);
    }

    /**
     * Multiplies the coordinates of the vector by a constant.
     * @param m the constant to multiply the coordinates of the vector by
     */
    public void multiply(double m) {
        this.xCoordinate *= m;
        this.yCoordinate *= m;
    }
}
