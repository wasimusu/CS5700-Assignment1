package examples.shapes;

public class Triangle {
    private Point Point1, Point2, Point3;

    // constructor for declaring triangle using three Points
    public Triangle(Point Point1, Point Point2, Point Point3) throws ShapeException {
        this.Point1 = Point1;
        this.Point2 = Point2;
        this.Point3 = Point3;

        // Test for invalid triangles
        // Check for invalid triangles
        // Zero area triangle
        // Single Line Triangle
    }

    public void move(double deltaX, double deltaY) throws ShapeException {
        Point1.move(deltaX, deltaY);
        Point2.move(deltaX, deltaY);
        Point3.move(deltaX, deltaY);
    }

    // compute area of triangle
    public double area() throws ShapeException {
        double x1 = Point1.getX();
        double x2 = Point2.getX();
        double x3 = Point3.getX();
        double y1 = Point1.getY();
        double y2 = Point2.getY();
        double y3 = Point3.getY();
        return (x1 * (y2 - y3) + x2 * (y3 - y1) + x3 * (y1 - y2)) / 2.0;
    }

    // rotate a triangle
}
