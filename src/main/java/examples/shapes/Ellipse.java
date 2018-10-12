package examples.shapes;

import java.awt.*;

/**
 * Ellipse
 * <p>
 * This class represents Ellipse objects that can be moved and scales.  Users of a Ellipse can also get its area.
 */
@SuppressWarnings("WeakerAccess")
public class Ellipse implements Shapes {
    protected Point center;
    protected double majorRadius;
    protected double minorRadius;

    /**
     * Constructor with x-y Location for center
     *
     * @param x           The x-location of the center of the Ellipse -- must be a valid double
     * @param y           The y-location of the center of the Ellipse
     * @param majorRadius The majorRadius of the Ellipse -- must be greater or equal to zero.
     * @throws ShapeException The exception thrown if the x, y, or z are not valid
     */
    public Ellipse(double x, double y, double majorRadius, double minorRadius) throws ShapeException {
        Validator.validatePositiveDouble(majorRadius, "Invalid majorRadius");
        Validator.validatePositiveDouble(minorRadius, "Invalid minorRadius");
        center = new Point(x, y);
        this.majorRadius = majorRadius;
        this.minorRadius = minorRadius;
    }

    /**
     * Constructor with a Point for center
     *
     * @param center      The x-location of the center of the Ellipse -- must be a valid point
     * @param majorRadius The majorRadius of the Ellipse -- must be greater or equal to zero.
     * @throws ShapeException The exception thrown if the x, y, or z are not valid
     */
    public Ellipse(Point center, double majorRadius, double minorRadius) throws ShapeException {
        Validator.validatePositiveDouble(majorRadius, "Invalid majorRadius");
        Validator.validatePositiveDouble(minorRadius, "Invalid minorRadius");
        if (center == null)
            throw new ShapeException("Invalid center point");

        this.center = center;
        this.majorRadius = majorRadius;
        this.minorRadius = minorRadius;
    }

    public Ellipse() throws ShapeException {
        this.center = new Point(0, 0);
        this.majorRadius = 1;
        this.minorRadius = 1;
    }

    /**
     * @return The center of the Ellipse
     */
    public Point getCenter() {
        return center;
    }

    /**
     * @return The majorRadius of the Ellipse
     */
    public double getmajorRadius() {
        return majorRadius;
    }

    public double getminorRadius() {
        return minorRadius;
    }

    /**
     * Move the Ellipse
     *
     * @param deltaX a delta change for the x-location of center of the Ellipse
     * @param deltaY a delta change for the y-location of center of the Ellipse
     * @throws ShapeException Exception thrown if either the delta x or y are not valid doubles
     */
    public void move(double deltaX, double deltaY) throws ShapeException {
        center.move(deltaX, deltaY);
    }

    /**
     * Scale the Ellipse
     *
     * @param scaleFactor a non-negative double that represents the percentage to scale the Ellipse.
     *                    0>= and <1 to shrink.
     *                    >1 to grow.
     * @throws ShapeException Exception thrown if the scale factor is not valid
     */
    public void scale(double scaleFactor) throws ShapeException {
        Validator.validatePositiveDouble(scaleFactor, "Invalid scale factor");
        majorRadius *= scaleFactor;
        minorRadius *= scaleFactor;
    }

    /**
     * @return The area of the Ellipse.
     */
    public double area() {
        return Math.PI * majorRadius * minorRadius;
    }

    @Override
    public String toString() {
        return "Ellipse:" +
                String.valueOf(this.center.getX()) + "," +
                String.valueOf(this.center.getY()) + "," +
                String.valueOf(this.majorRadius) + "," +
                String.valueOf(this.minorRadius);
    }

    public Ellipse(String string) throws ShapeException {
        // Expecting only parameters
        // x, y, majorRadius, minorRadius
        String[] strings = string.split(",");
        double x = Double.valueOf(strings[0]);
        double y = Double.valueOf(strings[1]);
        this.majorRadius = Double.valueOf(strings[2]);
        this.minorRadius = Double.valueOf(strings[3]);
        this.center = new Point(x, y);
        System.out.println("Created a new ellipse with area : "+this.area());
    }

    public void render(Graphics2D graphics) {
        int majorRadius = (int) (this.majorRadius);
        int minorRadius = (int) (this.minorRadius);
        int x = (int) this.center.getX() - majorRadius;
        int y = (int) this.center.getY() - minorRadius;
        graphics.drawOval(x, y, majorRadius * 2, minorRadius * 2);
    }

}
