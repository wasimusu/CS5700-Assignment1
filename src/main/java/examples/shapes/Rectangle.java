package examples.shapes;

public class Rectangle {

    private Point Point1, Point2, Point3, Point4;

    // What are all the ways you can declare a rectangle
    // The points are required to be in order
    public Rectangle(Point Point1, Point Point2, Point Point3, Point Point4) throws ShapeException {
        this.Point1 = Point1;
        this.Point2 = Point2;
        this.Point3 = Point3;
        this.Point4 = Point4;
    }

    public double area() throws ShapeException {
        return 0;
    }

    public double getHeight() throws ShapeException{
        return 0;
    }

    public double getWidth() throws ShapeException{
        return 0;
    }

    public void move(double deltaX, double deltaY) throws ShapeException {
        Validator.validateDouble(deltaX, "Invalid X-position");
        Validator.validateDouble(deltaY, "Invalid Y-position");
        Point1.move(deltaX, deltaY);
        Point2.move(deltaX, deltaY);
        Point3.move(deltaX, deltaY);
        Point4.move(deltaX, deltaY);
    }
}
