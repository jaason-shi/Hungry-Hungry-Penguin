package ca.bcit.comp2522.termproject.penguinpursuit;

public class Rectangle {
    public double x;
    public double y;
    public double width;
    public double height;

    public Rectangle(double x, double y, double width, double height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

//  four cases; left of other rect, right of other rect, above other rect, below other rect
    public boolean intersects(Rectangle other) {
        boolean noOverlap = this.x + this.width < other.x ||
                other.x + other.width < this.x ||
                this.y + this.height < other.y ||
                other.y + other.height < this.y;
        return !noOverlap;
    }
}
