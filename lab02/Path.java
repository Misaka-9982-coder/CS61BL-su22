/** A class that represents a path via pursuit curves. */
public class Path {

    // TODO
    private Point curr, next;
    public Path(double x, double y) {
        curr = new Point();
        next = new Point(x, y);
    }
    public double getCurrX() {
        return curr.getX();
    }
    public double getCurrY() {
        return curr.getY();
    }
    public double getNextX() {
        return next.getX();
    }
    public double getNextY() {
        return next.getY();
    }
    public void setCurrentPoint(Point point) {
        curr = point;
    }
    public void iterate(double x, double y) {
        curr = next;
        next = new Point(curr.getX() + x, curr.getY() + y);
    }
    public Point getCurrentPoint() {
        return curr;
    }
}
