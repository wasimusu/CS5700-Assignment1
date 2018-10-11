package examples.shapes;

public class Circle extends Ellipse {

    public Circle(Point center, double radius) throws ShapeException {
        Validator.validatePositiveDouble(radius, "Invalid radius");
        if (center == null)
            throw new ShapeException("Invalid center point");

        this.majorRadius = radius;
        this.minorRadius = radius;
        this.center = center;
    }

    public Circle(double x, double y, double radius) throws ShapeException {
        Validator.validatePositiveDouble(radius, "Invalid radius");
        this.majorRadius = radius;
        this.minorRadius = radius;
        this.center = new Point(x, y);
    }

    public double getRadius(){
        return super.getmajorRadius();
    }


}
