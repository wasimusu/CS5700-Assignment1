package examples.shapes;

public class Triangle {
    private Point Point1, Point2, Point3;

    // constructor for declaring triangle using three Points
    public Triangle(Point Point1, Point Point2, Point Point3) throws ShapeException {
        if (Point1 == null || Point2 == null || Point3 == null)
            throw new ShapeException("Invalid vertex");

        this.Point1 = Point1;
        this.Point2 = Point2;
        this.Point3 = Point3;

        Line l1 = new Line(Point1, Point2);
        Line l2 = new Line(Point2, Point3);
        Line l3 = new Line(Point3, Point1);

        double length1 = l1.computeLength();
        double length2 = l2.computeLength();
        double length3 = l3.computeLength();

        assert length1 + length2 > length3;
        // If the sum of two sides is equal to the third side, the area of triangle is 0
    }

    public void move(double deltaX, double deltaY) throws ShapeException {
        Point1.move(deltaX, deltaY);
        Point2.move(deltaX, deltaY);
        Point3.move(deltaX, deltaY);
    }

    // compute area of triangle
    public double area() {
        // Accurate
        double x1 = Point1.getX();
        double x2 = Point2.getX();
        double x3 = Point3.getX();
        double y1 = Point1.getY();
        double y2 = Point2.getY();
        double y3 = Point3.getY();
        double area = (x1 * (y2 - y3) + x2 * (y3 - y1) + x3 * (y1 - y2)) / 2.0;

        return Math.abs(area);
    }

    // Returns vertices of the triangles
    public Point getPoint1() {
        return Point1;
    }

    public Point getPoint2() {
        return Point2;
    }

    public Point getPoint3() {
        return Point3;
    }

    // Optional : rotate a triangle
}
