package dk.kea.turtles;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.awt.Color;
import java.time.Duration;
import java.util.List;

public class TurtleTest {
    private final Position origo = new Position(0, 0);
    private Turtle turtle;

    // Remember: JUnit can run an initializing @Before function before every @Test

    @Before
    public void setupDefaultTurtle() {
        this.turtle = defaultTurtle();
    }

    // When you don't use a @Before method, static generators are *very* convenient!

    public Turtle defaultTurtle() {
        TurtleCanvas canvas = new TurtleCanvas(800, 800);
        return new Turtle(canvas, Duration.ofMillis(10), Color.WHITE, this.origo);
    }

    @Test
    public void testIdentity() {
        // Testing with equality will only sometimes work (when there are no rounding errors):

        Assert.assertEquals(new Position(0, 0), turtle.getPosition());

        // Using a so-called epsilon test will also work when there are rounding errors:

        Position actual = turtle.getPosition();
        Position expected = new Position(0, 0);
        double epsilon = 0.001;
        Assert.assertTrue(expected.nearlyEquals(actual, epsilon));
    }

    // These are classic unit tests: Run a single function
    @Test
    public void testBasicMovement() {
        // TODO: Test that .forward() works
        {
            Turtle bob = defaultTurtle();
            bob.forward(100);
            assertNearlyEquals(bob.getPosition(), new Position(100, 0), 0.001);
        }

        {
            Turtle bob = defaultTurtle();
            bob.forward(0);
            assertNearlyEquals(new Position(0, 0), bob.getPosition(), 0.001);
        }

        {
            Turtle bob = defaultTurtle();
            bob.forward(-100);
            assertNearlyEquals(new Position(-100, 0), bob.getPosition(), 0.001);
        }

        // TODO: Test that .backward() works
        for (int distance : List.of(-100, 0, 100)) {
            Turtle bob = defaultTurtle();
            bob.back(distance);
            assertNearlyEquals(new Position(-distance, 0), bob.getPosition(), 0.001);
        };

        // TODO: Test that .left() works
        // TODO: Test that .right() works
        for (double degrees = -720; degrees < 720; degrees += 5) {
            Turtle bobLeft = defaultTurtle();
            bobLeft.left(degrees);
            Assert.assertEquals(-degrees, bobLeft.getAngle(), 0.001);

            Turtle bobRight = defaultTurtle();
            bobRight.right(degrees);
            Assert.assertEquals(degrees, bobRight.getAngle(), 0.001);
        }
    }

    @Test
    public void testCombinedMovement() {
        // TODO: Test that .left() and .forward() work
        {
            Turtle bob = defaultTurtle();
            bob.left(90);
            bob.forward(100);
            assertNearlyEquals(new Position(0, -100), bob.getPosition(), 0.001);
        }

        // TODO: Test that .right() and .forward() work
        {
            Turtle bob = defaultTurtle();
            bob.right(90);
            bob.forward(100);
            assertNearlyEquals(new Position(0, 100), bob.getPosition(), 0.001);
        }

        // TODO: Test that .left() and .back() work
        {
            Turtle bob = defaultTurtle();
            bob.left(90);
            bob.back(100);
            assertNearlyEquals(new Position(0, 100), bob.getPosition(), 0.001);
        }

        // TODO: Test that .right() and .back() work
        {
            Turtle bob = defaultTurtle();
            bob.right(90);
            bob.back(100);
            assertNearlyEquals(new Position(0, -100), bob.getPosition(), 0.001);
        }
    }

    @Test
    public void testComplexMovement() {
        // TODO: Test that moving in a square shape (forward 100, left 90) x 4 brings us back
        assertMovePolygon(defaultTurtle(), 4);

        // TODO: Test that moving in a hexagonal shape (forward 100, left 60) x 6 brings us back
        assertMovePolygon(defaultTurtle(), 6);
    }

    public static void assertMovePolygon(Turtle t, int edges) {
        Position before = t.getPosition();
        for (int i = 0; i < edges; i++) {
            t.forward(100);
            t.left(360 / edges);
        }
        Position after = t.getPosition();
        assertNearlyEquals(before, after, 0.001);
    }

    public static void assertNearlyEquals(Position expected, Position actual, double epsilon) {
        if (!expected.nearlyEquals(actual, epsilon)) {
            throw new AssertionError(String.format("\nExpected :%s\nActual   :%s\nEpsilon  :%f", expected, actual, epsilon));
        }
    }
}
