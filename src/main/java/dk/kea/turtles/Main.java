package dk.kea.turtles;

import javax.swing.*;
import java.awt.*;
import java.time.Duration;
import java.awt.image.BufferedImage;
import java.time.Duration;
import java.awt.image.BufferedImage;
import java.util.stream.IntStream;

public class Main {
    public static int CANVAS_WIDTH = 800;
    public static int CANVAS_HEIGHT = 800;

    public static void main(String[] args) {
        JFrame frame = setupFrame();
        TurtleCanvas canvas = setupCanvas(frame);
        Turtle bob = setupTurtle(canvas);

        double bob_x = ((double) CANVAS_WIDTH) / 2;
        double bob_y = ((double) CANVAS_HEIGHT) / 2;
        int scale = 50;

        S(bob, scale); bob.teleport(bob_x + scale / 2, bob_y, 0);
        i(bob, scale); bob.teleport(bob_x + scale, bob_y, 0);
        m(bob, scale); bob.teleport(bob_x + 2.5 * scale, bob_y, 0);
        o(bob, scale); bob.teleport(bob_x + 3.5 * scale, bob_y, 0);
        n(bob, scale);
    }

    public static JFrame setupFrame() {
        JFrame frame = new JFrame();
        frame.setTitle("Turtle Graphics");
        frame.setSize(CANVAS_WIDTH, CANVAS_HEIGHT);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        SwingUtilities.invokeLater(() -> frame.setVisible(true));

        return frame;
    }

    public static TurtleCanvas setupCanvas(JFrame frame) {
        TurtleCanvas canvas = new TurtleCanvas(CANVAS_WIDTH, CANVAS_HEIGHT);
        frame.add(canvas);
        return canvas;
    }

    public static Turtle setupTurtle(TurtleCanvas canvas) {
        var bob_speed = Duration.ofMillis(100);
        double bob_x = ((double) CANVAS_WIDTH) / 2;
        double bob_y = ((double) CANVAS_HEIGHT) / 2;
        return new Turtle(canvas, Color.WHITE, bob_speed, bob_x, bob_y);
    }

    public static void S(Turtle t, int scale) {
        t.left(90);
        IntStream.range(0, 3).forEach(i -> { t.left(90); t.forward(scale); });
        IntStream.range(0, 2).forEach(i -> { t.right(90); t.forward(scale); });
    }

    public static void i(Turtle t, int scale) {
        t.right(90);
        t.forward(scale / 2);
        t.stopDrawing();
        t.forward(scale / 2);
        t.startDrawing();
        t.forward(scale);
    }

    public static void m(Turtle t, int scale) {
        t.right(90);
        t.stopDrawing();
        t.forward(scale);
        t.startDrawing();
        t.forward(scale);
        t.right(180);
        t.forward(3 * scale / 5);
        t.right(45);
        t.forward(2 * scale / 5);
        t.right(90);
        t.forward(2 * scale / 5);
        t.left(90);
        t.forward(2 * scale / 5);
        t.right(90);
        t.forward(2 * scale / 5);
        t.right(45);
        t.forward(3 * scale / 5);
    }

    public static void o(Turtle t, int scale) {
        t.right(90);
        t.stopDrawing();
        t.forward(scale + 2 * scale / 5);
        t.startDrawing();
        t.left(45);
        IntStream.range(0, 4).forEach(i -> { t.forward(3 * scale / 5); t.left(90); });
    }

    public static void n(Turtle t, int scale) {
        t.right(90);
        t.stopDrawing();
        t.forward(scale);
        t.startDrawing();
        t.forward(scale);
        t.right(180);
        t.forward(3 * scale / 5);
        t.right(45);
        t.forward(2 * scale / 5);
        t.right(45);
        t.forward(2 * scale / 5);
        t.right(45);
        t.forward(2 * scale / 5);
        t.right(45);
        t.forward(3 * scale / 5);
    }
}
