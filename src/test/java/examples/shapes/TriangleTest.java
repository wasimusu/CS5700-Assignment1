package examples.shapes;

import org.junit.Test;

import static org.junit.Assert.*;

public class TriangleTest {

    @Test
    public void testValidConstruction() throws ShapeException {
        Point p1 = new Point(0, 0);
        Point p2 = new Point(4, 0);
        Point p3 = new Point(4, 4);
        Point p4 = new Point(0, 4);

        Triangle t1 = new Triangle(p1, p2, p3);
        Triangle t2 = new Triangle(p1, p2, p4);

        assertEquals(t1.area(), 8, 0.0000001);
        assertEquals(t2.area(), 8, 0.0000001);

        Point p5 = new Point(-2, -2);
        Point p6 = new Point(-2, -8);
        Point p7 = new Point(-4, -8);
        Point p8 = new Point(-4, -2);

        Triangle t3 = new Triangle(p5, p6, p7);
        Triangle t4 = new Triangle(p5, p6, p8);

        assertEquals(t3.area(), 6, 0.00000001);
        assertEquals(t4.area(), 6, 0.00000001);
    }

    @Test
    public void testInvalidConstruction() throws ShapeException {
        Point p1 = new Point(0, 0);
        Point p2 = new Point(4, 0);
        Point p3 = new Point(4, 4);

        try {
            new Triangle(null, p2, p3);
            fail("Expected exception not thrown");
        } catch (ShapeException e) {
            assertEquals("Invalid vertex", e.getMessage());
        }

        try {
            new Triangle(p1, p1, p3);
            fail("Expected exception not thrown");
        } catch (ShapeException e) {
            assertEquals("A line must have a length > 0", e.getMessage());
        }

    }

    @Test
    public void testMove() throws ShapeException {
        Point p1 = new Point(0, 0);
        Point p2 = new Point(4, 0);
        Point p3 = new Point(4, 4);

        Triangle t1 = new Triangle(p1, p2, p3);
        t1.move(0.5, 0.5);

        assert t1.getPoint1().equalsTo(new Point(0.5, 0.5));
        assert t1.getPoint2().equalsTo(new Point(4.5, 0.5));
        assert t1.getPoint3().equalsTo(new Point(4.5, 4.5));

        Point p4 = new Point(4, 0);
        Point p5 = new Point(0, 0);
        Point p6 = new Point(0, 4);

        Triangle t2 = new Triangle(p4, p5, p6);
        t2.move(-0.5, -0.5);

        assert t2.getPoint1().equalsTo(new Point(3.5, -0.5));
        assert t2.getPoint2().equalsTo(new Point(-0.5, -0.5));
        assert t2.getPoint3().equalsTo(new Point(-0.5, 3.5));

        try {
            t2.move(Double.POSITIVE_INFINITY, 1);
            fail("Expected exception not thrown");
        } catch (ShapeException e) {
            assertEquals("Invalid delta-x value", e.getMessage());
        }

        try {
            t2.move(Double.NEGATIVE_INFINITY, 1);
            fail("Expected exception not thrown");
        } catch (ShapeException e) {
            assertEquals("Invalid delta-x value", e.getMessage());
            // ignore
        }

        try {
            t2.move(Double.NaN, 1);
            fail("Expected exception not thrown");
        } catch (ShapeException e) {
            assertEquals("Invalid delta-x value", e.getMessage());
        }

        try {
            t2.move(1, Double.POSITIVE_INFINITY);
            fail("Expected exception not thrown");
        } catch (ShapeException e) {
            assertEquals("Invalid delta-y value", e.getMessage());
        }

        try {
            t2.move(1, Double.NEGATIVE_INFINITY);
            fail("Expected exception not thrown");
        } catch (ShapeException e) {
            assertEquals("Invalid delta-y value", e.getMessage());
        }

        try {
            t2.move(1, Double.NaN);
            fail("Expected exception not thrown");
        } catch (ShapeException e) {
            assertEquals("Invalid delta-y value", e.getMessage());
        }

    }
}
