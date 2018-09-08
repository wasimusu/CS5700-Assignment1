package examples.shapes;

import java.awt.*;

public class Ellipse {

    public Ellipse() throws ShapeException {

    }

    public void move(double deltaX, double deltaY) throws ShapeException {
        Validator.validateDouble(deltaX, "Invalid x-coordinate");
        Validator.validateDouble(deltaY, "Invalid y-coordinate");
    }

    public double area() throws ShapeException {
        return 0;
    }

    public void rotate(double clockwiseAngle) throws ShapeException{
        Validator.validateDouble(clockwiseAngle, "Not a valid value for rotation");
    }

}
