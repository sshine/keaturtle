package dk.kea.turtles;

public record Position(double x, double y) {
    public boolean nearlyEquals(Position other, double epsilon) {
        double delta_x = Math.abs(this.x() - other.x());
        double delta_y = Math.abs(this.y() - other.y());

        return delta_x < epsilon && delta_y < epsilon;
    }
}
