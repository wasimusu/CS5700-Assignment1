package examples.shapes;

import java.awt.*;

public class Circle extends Ellipse {
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
