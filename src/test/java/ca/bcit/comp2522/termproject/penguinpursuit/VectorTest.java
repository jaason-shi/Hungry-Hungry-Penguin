package ca.bcit.comp2522.termproject.penguinpursuit;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class VectorTest {

    @Test
    void add() {
        Vector vector1 = new Vector(1, 2);
        Vector vector2 = new Vector(3, 4);
        vector1.add(vector2);
        assertEquals(4, vector1.xCoordinate);
        assertEquals(6, vector1.yCoordinate);
    }

    @Test
    void multiply() {
        Vector vector = new Vector(1, 2);
        vector.multiply(3);
        assertEquals(3, vector.xCoordinate);
        assertEquals(6, vector.yCoordinate);
    }
}