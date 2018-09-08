package examples.shapes;

import java.awt.*;

public class Ellipse {
    private Point center;
    private double majorRadius, minorRadius;

    public Ellipse(Point center, double majorRadius, double minorRadius) throws ShapeException {
        // Validate
        Validator.validateDouble(majorRadius, "Invalid value for majorRadius");
        Validator.validateDouble(minorRadius, "Invalid value for minorRadius");
        Validator.validatePositiveDouble(minorRadius, "Negative values not accepted for minorRadius");
        Validator.validatePositiveDouble(majorRadius, "Negative values not accepted for majorRadius");

        // Construct
        this.center = center;
        this.majorRadius = majorRadius;
        this.minorRadius = minorRadius;
    }

    public Ellipse(double x, double y, double majorRadius, double minorRadius) throws ShapeException {
        // Validate
        Validator.validateDouble(x, "Invalid position for x");
        Validator.validateDouble(y, "Invalid position for y");
        Validator.validateDouble(majorRadius, "Invalid value for majorRadius");
        Validator.validateDouble(minorRadius, "Invalid value for minorRadius");

        // Construct
        center = new Point(x, y);
        this.majorRadius = majorRadius;
        this.minorRadius = minorRadius;
    }

    public void move(double deltaX, double deltaY) throws ShapeException {
        center.move(deltaX, deltaY);
    }

    public double area() throws ShapeException {
        return Math.PI*majorRadius*minorRadius;
    }

    public void rotate(double clockwiseAngle) throws ShapeException {
        Validator.validateDouble(clockwiseAngle, "Not a valid value for rotation");
        double angle = clockwiseAngle % 360;
    }

}
