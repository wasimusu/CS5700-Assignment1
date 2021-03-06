package examples.shapes;

import java.awt.*;

public class Rectangle implements Shapes {

    protected Point Point1, Point2, Point3, Point4;
    protected double length, breadth;

    // What are all the ways you can declare a rectangle
    // The points are required to be in order
    public Rectangle(Point Point1, Point Point2, Point Point3, Point Point4) throws ShapeException {
        this.Point1 = Point1;
        this.Point2 = Point2;
        this.Point3 = Point3;
        this.Point4 = Point4;

        if (Point1 == null || Point2 == null || Point3 == null || Point4 == null)
            throw new ShapeException("Invalid vertex or vertices");

        this.computeLengthBreadth(); // assert rectangle properties to make sure this is a valid rectangle

    }

    private void computeLengthBreadth() throws ShapeException {
        // Check if the points make a valid rectangle
        Line l1 = new Line(this.Point1, this.Point2);
        Line l2 = new Line(this.Point2, this.Point3);
        Line l3 = new Line(this.Point3, this.Point4);
        Line l4 = new Line(this.Point4, this.Point1);
        Line diagonal = new Line(this.Point2, this.Point4);

        // Compute the length of sides
        double length1 = l1.computeLength();
        double length2 = l2.computeLength();
        double length3 = l3.computeLength();
        double length4 = l4.computeLength();
        double length_diag = diagonal.computeLength();

        // Determine length and breadth
        this.length = Math.max(length1, length2);
        this.breadth = Math.min(length1, length2);

        // compare the length of opposite sides and pythagoras test
        assert length1 == length3;
        assert length2 == length4;
        assert Math.sqrt(Math.pow(length1, 2) + Math.pow(length2, 2)) == length_diag;
    }

    public double area() {
        return this.length * this.breadth;
    }

    public double getLength() {
        return length;
    }

    public double getBreadth() {
        return breadth;
    }

    // Return the vertices of the rectangle
    public Point getPoint1() {
        return Point1;
    }

    public Point getPoint2() {
        return Point2;
    }

    public Point getPoint3() {
        return Point3;
    }

    public Point getPoint4() {
        return Point4;
    }

    // Moves the rectangle dy deltaX, deltaY
    public void move(double deltaX, double deltaY) throws ShapeException {
        Point1.move(deltaX, deltaY);
        Point2.move(deltaX, deltaY);
        Point3.move(deltaX, deltaY);
        Point4.move(deltaX, deltaY);
    }

    public void render(Graphics2D graphics) {
        int x = (int) this.getPoint1().getX();
        int y = (int) this.getPoint1().getY();
        int length = (int) this.getLength();
        int breadth = (int) this.getBreadth();
        graphics.drawRect(x, y, length, breadth);
    }

    @Override
    public String toString() {
        return "Rectangle:" +
                String.valueOf(this.getPoint1().getX()) + "," +
                String.valueOf(this.getPoint1().getY()) + "," +
                String.valueOf(this.getPoint2().getX()) + "," +
                String.valueOf(this.getPoint2().getY()) + "," +
                String.valueOf(this.getPoint3().getX()) + "," +
                String.valueOf(this.getPoint3().getY()) + "," +
                String.valueOf(this.getPoint4().getX()) + "," +
                String.valueOf(this.getPoint4().getY());
    }

    public Rectangle(String string) throws Exception {
        // Expecting only parameters
        if (string.toLowerCase().contains("rectangle:"))
            string = string.split(":")[1];

        String[] strings = string.split(",");
        this.Point1 = new Point(Double.valueOf(strings[0]), Double.valueOf(strings[1]));
        this.Point2 = new Point(Double.valueOf(strings[2]), Double.valueOf(strings[3]));
        this.Point3 = new Point(Double.valueOf(strings[4]), Double.valueOf(strings[5]));
        this.Point4 = new Point(Double.valueOf(strings[6]), Double.valueOf(strings[7]));
        this.computeLengthBreadth(); // assert rectangle properties to make sure this is a valid rectangle
        System.out.println("Created a new Rectangle with area : " + this.area());
    }
}
