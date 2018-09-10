package examples.shapes;

import sun.security.provider.SHA;

public class Square extends Rectangle {

    public Square(Point a, Point b, Point c, Point d) throws ShapeException {
        super(a, b, c, d);
        if (length != breadth)
            throw new ShapeException("All sides are not equal");
    }
}
