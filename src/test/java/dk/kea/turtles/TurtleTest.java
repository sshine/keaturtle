package dk.kea.turtles;

import org.junit.Assert;
import org.junit.Test;

import java.awt.Color;
import java.time.Duration;

public class TurtleTest {
    @Test
    public void testIdentity() {
        Turtle bob = new Turtle(null, Color.WHITE, Duration.ofMillis(10), 0, 0);

        Assert.assertEquals(bob.getPosition(), new Position(0, 0));
        Assert.assertTrue(bob.getPosition().nearlyEquals(new Position(0, 0)));
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
    }
}
