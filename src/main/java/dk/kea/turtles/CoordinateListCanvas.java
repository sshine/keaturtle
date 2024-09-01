package dk.kea.turtles;

import java.awt.*;
import java.util.ArrayList;

public class CoordinateListCanvas implements TurtleCanvas {
    private ArrayList<Line> lines;

    public CoordinateListCanvas() {
        this.lines = new ArrayList<>();
    }

    @Override
    public void drawLine(Color color, double x1, double y1, double x2, double y2) {
        this.lines.add(new Line(new Position(x1, x2), new Position(y1, y2)));
    }

    public record Line(Position from, Position to) {}
}
