package dk.kea.turtles;

import java.awt.*;
import java.time.Duration;

public class Turtle {
    private TurtleCanvas canvas;
    private Color color;
    private Duration speed;
    private double x, y, angle;
    private boolean isDrawing;

    public Turtle(TurtleCanvas canvas, Color color, Duration speed, double start_x, double start_y) {
        this.canvas = canvas;
        this.color = color;
        this.speed = speed;
        this.x = start_x;
        this.y = start_y;
        this.angle = 0;
        this.isDrawing = true;
    }

    public void left(double degrees) {
        this.angle -= degrees;
    }

    public void right(double degrees) {
        this.angle += degrees;
    }

    public void forward(double distance) {
        double old_x = x;
        double old_y = y;
        x += distance * Math.cos(Math.toRadians(this.angle));
        y += distance * Math.sin(Math.toRadians(this.angle));

        if (this.isDrawing) {
            this.canvas.drawLine(this.color, (int) old_x, (int) old_y, (int) this.x, (int) this.y);
            if (this.speed.isPositive()) {
                try {
                    Thread.sleep(this.speed);
                } catch (InterruptedException e) {
                }
            }
        }
    }

    public void back(double distance) {
        this.forward(-distance);
    }

    public void teleport(double x, double y, double angle) {
        this.x = x;
        this.y = y;
        this.angle = angle;
    }

    public void color(Color color) {
        this.color = color;
    }

    public void stopDrawing() {
        this.isDrawing = false;
    }

    public void startDrawing() {
        this.isDrawing = true;
    }
}
