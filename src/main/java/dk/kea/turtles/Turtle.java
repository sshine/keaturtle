package dk.kea.turtles;

import java.awt.*;
import java.time.Duration;

public class Turtle {
    private TurtleCanvas canvas;
    private Duration drawSpeed;
    private Color color;
    private double x, y, angle;
    private boolean isDrawing;

    public Turtle(TurtleCanvas canvas, Duration drawSpeed, Color color, Position startPosition) {
        this.canvas = canvas;
        this.drawSpeed = drawSpeed;
        this.color = color;
        this.x = startPosition.x();
        this.y = startPosition.y();
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

        // TODO: Testing can be problematic because a canvas with a JPanel is required to exist.

        if (this.isDrawing && this.canvas != null) {
            this.canvas.drawLine(this.color, old_x, old_y, this.x, this.y);
            if (this.drawSpeed.isPositive()) {
                try {
                    Thread.sleep(this.drawSpeed);
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

    public void teleport(Position position, double angle) {
        this.teleport(position.x(), position.y(), angle);
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

    public Position getPosition() {
        return new Position(this.x, this.y);
    }

    public double getAngle() {
        return this.angle;
    }
}
