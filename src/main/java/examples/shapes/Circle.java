package examples.shapes;

import java.awt.*;

public class Circle extends Ellipse {
    private Point center;
    private double radius;

    public Circle(Point center, double radius) throws ShapeException {
        super(center, radius, radius);
        assert majorRadius == minorRadius;
        Validator.validatePositiveDouble(radius, "Invalid radius");
    }

    public Circle(double x, double y, double radius) throws ShapeException {
        super(x, y, radius, radius);
        assert majorRadius == minorRadius;
        Validator.validatePositiveDouble(radius, "Invalid radius");
    }

    public double getRadius() throws ShapeException {
        return super.getmajorRadius();
    }
}

//    public Circle(double x, double y, double radius) throws ShapeException {
//        super(x, y, radius, radius);
//        Validator.validatePositiveDouble(radius, "Invalid radius");
//        this.majorRadius = radius;
//        this.minorRadius = radius;
//        this.center = new Point(x, y);
//    }
//
//    public Circle(Point center, double radius) throws ShapeException {
//        super(center, radius, radius);
//        Validator.validatePositiveDouble(radius, "Invalid radius");
//        this.majorRadius = radius;
//        this.minorRadius = radius;
//        this.center = center;
//    }
