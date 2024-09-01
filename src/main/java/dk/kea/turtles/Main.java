package dk.kea.turtles;

import javax.swing.*;
import java.awt.*;
import java.time.Duration;

public class Main {
    public static int CANVAS_WIDTH = 800;
    public static int CANVAS_HEIGHT = 800;

    public static void main(String[] args) {
        JFrame frame = setupFrame();
        BufferedImageCanvas canvas = setupCanvas(frame);
        Turtle bob = setupTurtle(canvas);

        Color[] colors = new Color[] {Color.WHITE, Color.RED, Color.GREEN, Color.BLUE, Color.YELLOW };

        for (int i = 0; i < colors.length; i++) {
            bob.teleport(canvasMiddle(), 0);
            bob.color(colors[i]);
            hilbertCurve(bob, 10, 1, i + 1);
        }
    }

    public static void hilbertCurve(Turtle bob, double scale, double parity, int n) {
        if (n < 1)
            return;

        bob.left(parity * 90);
        hilbertCurve(bob, scale, -parity, n - 1);
        bob.forward(scale);
        bob.right(parity * 90);
        hilbertCurve(bob, scale, parity, n - 1);
        bob.forward(scale);
        hilbertCurve(bob, scale, parity, n - 1);
        bob.right(parity * 90);
        bob.forward(scale);
        hilbertCurve(bob, scale, - parity, n - 1);
        bob.left(parity * 90);
    }

    public static JFrame setupFrame() {
        JFrame frame = new JFrame();
        frame.setTitle("Turtle Graphics");
        frame.setSize(CANVAS_WIDTH, CANVAS_HEIGHT);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        SwingUtilities.invokeLater(() -> frame.setVisible(true));

        return frame;
    }

    public static BufferedImageCanvas setupCanvas(JFrame frame) {
        BufferedImageCanvas canvas = new BufferedImageCanvas(CANVAS_WIDTH, CANVAS_HEIGHT);
        frame.add(canvas);
        return canvas;
    }

    public static Turtle setupTurtle(BufferedImageCanvas canvas) {
        var bobSpeed = Duration.ofMillis(10);
        var bobPosition = canvasMiddle();
        return new Turtle(canvas, bobSpeed, Color.WHITE, bobPosition);
    }

    public static Position canvasMiddle() {
        double middleX = ((double) CANVAS_WIDTH) / 2;
        double middleY = ((double) CANVAS_HEIGHT) / 2;
        return new Position(middleX, middleY);
    }
}
