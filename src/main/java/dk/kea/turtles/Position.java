package dk.kea.turtles;

public record Position(double x, double y) {
    public boolean nearlyEquals(Position other) {
        return x == other.x() && y == other.y();
    }
}
