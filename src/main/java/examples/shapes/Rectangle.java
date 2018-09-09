package examples.shapes;

import java.awt.*;

public class Rectangle {

    protected Point Point1, Point2, Point3, Point4;
    protected double length, breadth;

    // What are all the ways you can declare a rectangle
    // The points are required to be in order
    public Rectangle(Point Point1, Point Point2, Point Point3, Point Point4) throws ShapeException {
        this.Point1 = Point1;
        this.Point2 = Point2;
        this.Point3 = Point3;
        this.Point4 = Point4;

        // Check if the points make a valid rectangle
        Line l1 = new Line(Point1, Point2);
        Line l2 = new Line(Point2, Point3);
        Line l3 = new Line(Point3, Point4);
        Line l4 = new Line(Point4, Point1);
        Line diagonal = new Line(Point2, Point4);

        // Compute the length of sides
        double length1 = l1.computeLength();
        double length2 = l2.computeLength();
        double length3 = l3.computeLength();
        double length4 = l4.computeLength();
        double length_diag = diagonal.computeLength();

        // Determine length and breadth
        length = Math.max(length1, length2);
        breadth = Math.min(length1, length2);

        // compare the length of opposite sides and pythagoras test
        System.out.println("Length 1 : " + length1 + " \tlength3 : " +length3);
        System.out.println("Length 2 : " + length1 + " \tlength4 : " +length3);
        assert length1 == length3;
        assert length2 == length4;
        assert Math.sqrt(Math.pow(length1, 2) + Math.pow(length2, 2)) == length_diag;
    }

    public double area() throws ShapeException {
        return length * breadth;
    }

    public double getLength() throws ShapeException {
        return length;
    }

    public double getBreadth() throws ShapeException {
        return breadth;
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
