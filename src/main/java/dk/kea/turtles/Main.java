package dk.kea.turtles;

import javax.swing.*;
import java.awt.*;
import java.time.Duration;

public class Main {
    public static int CANVAS_WIDTH = 800;
    public static int CANVAS_HEIGHT = 800;

    public static void main(String[] args) {
        JFrame frame = setupFrame();
        TurtleCanvas canvas = setupCanvas(frame);
        Turtle bob = setupTurtle(canvas);

        // TODO: Start coding here!

        for (int i = 0; i < 8; i++) {
            bob.forward(100);
            bob.left(90 + 45);
            bob.forward(30);
            bob.left(90 + 45);
            bob.forward(45);
            bob.left(90 + 45);
            bob.forward(30);
        }
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
}