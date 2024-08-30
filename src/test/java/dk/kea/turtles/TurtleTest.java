package dk.kea.turtles;

import org.junit.Assert;
import org.junit.Test;

import java.awt.Color;
import java.time.Duration;

public class TurtleTest {
    @Test
    public void testIdentity() {
        Turtle bob = new Turtle(null, Color.WHITE, Duration.ofMillis(10), 0, 0);

        Assert.assertEquals(new Position(0, 0), bob.getPosition());
        Assert.assertTrue(bob.getPosition().nearlyEquals(
                new Position(0, 0), 0.001));
    }

    @Test
    public void testBasicMovement() {
        // TODO: Test that .forward() and .back() work together
        // TODO: Test that .left() and .right() work together
        // TODO: Test that walking in a 90 angle square brings us back
    }

    @Test
    public void testComplexMovement() {
        // TODO: Test that moving in a hexagonal shape (forward 100, left 60) x 6 brings us back
        // TODO: Deal with floating-point problems

        Turtle bob = new Turtle(null, Color.WHITE, Duration.ofMillis(10), 0, 0);
        assertMovesInSquare(bob, 100);
        assertMovesInSquare(bob, -100);
        assertMovesInSquare(bob, 0);
    }

    public static void assertMovesInSquare(Turtle t, double distance) {
        t.forward(distance);
        t.left(90);

        t.forward(distance);
        t.left(90);

        t.forward(distance);
        t.left(90);

        t.forward(distance);
        t.left(90);

        Position actual = t.getPosition();
        Position expected = new Position(0, 0);
        double epsilon = 0.001;
        Assert.assertTrue(actual.nearlyEquals(expected, epsilon));
    }
}
