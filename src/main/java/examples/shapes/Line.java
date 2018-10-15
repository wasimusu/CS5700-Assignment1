package examples.shapes;

import java.awt.*;

/**
 * Line
 * <p>
 * This class represents line objects that can be moved.  Users of a line can also get its length and slope.
 */
@SuppressWarnings("WeakerAccess")
public class Line implements Shapes {

    private Point Point1;
    private Point Point2;

    /**
     * Constructor based on x-y Locations
     *
     * @param x1 The x-location of first point -- must be a valid double.
     * @param y1 The y-location of first point -- must be a valid double.
     * @param x2 The x-location of second point -- must be a valid double.
     * @param y2 The y-location of second point -- must be a valid double.
     * @throws ShapeException Exception throw if any parameter is invalid
     */
    public Line(double x1, double y1, double x2, double y2) throws ShapeException {
        Point1 = new Point(x1, y1);
        Point2 = new Point(x2, y2);

        if (computeLength() < 0.00000001)
            throw new ShapeException("A line must have a length > 0");
    }

    /**
     * @param Point1 The first point -- must not be null
     * @param Point2 The second point -- must not b e null
     * @throws ShapeException Exception throw if any parameter is invalid
     */
    public Line(Point Point1, Point Point2) throws ShapeException {
        if (Point1 == null || Point2 == null)
            throw new ShapeException("Invalid Point");

        this.Point1 = Point1;
        this.Point2 = Point2;

        if (computeLength() < 0.00000001)
            throw new ShapeException("A line must have a length > 0");
    }

    /**
     * @return The first point
     */
    public Point getPoint1() {
        return Point1;
    }

    /**
     * @return The second point
     */
    public Point getPoint2() {
        return Point2;
    }

    /**
     * Move a line
     *
     * @param deltaX The delta x-location by which the line should be moved -- must be a valid double
     * @param deltaY The delta y-location by which the line should be moved -- must be a valid double
     * @throws ShapeException Exception throw if any parameter is invalid
     */
    public void move(double deltaX, double deltaY) throws ShapeException {
        Point1.move(deltaX, deltaY);
        Point2.move(deltaX, deltaY);
    }

    public double area(){
        return 0;
    }
    /**
     * @return The length of the line
     */
    public double computeLength() {
        return Math.sqrt(Math.pow(Point2.getX() - Point1.getX(), 2) +
                Math.pow(Point2.getY() - Point1.getY(), 2));
    }

    /**
     * @return The slope of the line
     */
    public double computeSlope() {
        return (Point2.getY() - Point1.getY()) / (Point2.getX() - Point1.getX());
    }

    public void render(Graphics2D graphics) {
        int x1 = (int) (this.Point1.getX());
        int y1 = (int) (this.Point1.getY());
        int x2 = (int) (this.Point2.getX());
        int y2 = (int) (this.Point2.getY());
        graphics.drawLine(x1, y1, x2, y2);
    }

    @Override
    public String toString() {
        return "Line:" +
                String.valueOf(this.getPoint1().getX()) + "," +
                String.valueOf(this.getPoint1().getY()) + "," +
                String.valueOf(this.getPoint2().getX()) + "," +
                String.valueOf(this.getPoint2().getY());
    }

    public Line(String string) throws ShapeException {
        // Expecting only parameters
        // x1, y1, x2, y2

        if (string.toLowerCase().contains("line:"))
            string = string.split(":")[1];

        String[] strings = string.split(",");
        this.Point1 = new Point(Double.valueOf(strings[0]), Double.valueOf(strings[1]));
        this.Point2 = new Point(Double.valueOf(strings[2]), Double.valueOf(strings[3]));
    }
}
