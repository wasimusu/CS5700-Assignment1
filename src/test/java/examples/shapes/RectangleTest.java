package examples.shapes;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.fail;

public class RectangleTest {

    @Test
    public void testValidConstruction() throws ShapeException {
        Point p1 = new Point(0, 0);
        Point p2 = new Point(4, 0);
        Point p3 = new Point(4, 6);
        Point p4 = new Point(0, 6);
        Rectangle r1 = new Rectangle(p1, p2, p3, p4);

        assert p1.equalsTo(r1.getPoint1());
        assert p2.equalsTo(r1.getPoint2());
        assert p3.equalsTo(r1.getPoint3());
        assert p4.equalsTo(r1.getPoint4());

        assertEquals(6, r1.getLength(), 0);
        assertEquals(4, r1.getBreadth(), 0);
        assertEquals(24, r1.area(), 0);

        Point p5 = new Point(0.4, 0);
        Point p6 = new Point(-3.6, 0);
        Point p7 = new Point(-3.6, -8.5);
        Point p8 = new Point(0.4, -8.5);
        Rectangle r2 = new Rectangle(p5, p6, p7, p8);

        assert p5.equalsTo(r2.getPoint1());
        assert p6.equalsTo(r2.getPoint2());
        assert p7.equalsTo(r2.getPoint3());
        assert p8.equalsTo(r2.getPoint4());

        assertEquals(8.5, r2.getLength(), 0);
        assertEquals(4, r2.getBreadth(), 0);
        assertEquals(34, r2.area(), 0);

    }

    @Test
    public void testInvalidConstruction() throws ShapeException {
        Point p1 = new Point(0, 0);
        Point p2 = new Point(4, 0);
        Point p3 = new Point(4, 4);
        Point p4 = new Point(0, 4);

        try {
            new Rectangle(null, null, null, null);
            fail("Expected exception not thrown");
        } catch (ShapeException e) {
            assertEquals("Invalid vertex or vertices", e.getMessage());
        }

        try {
            new Rectangle(null, p2, p3, p4);
            fail("Expected exception not thrown");
        } catch (ShapeException e) {
            assertEquals("Invalid vertex or vertices", e.getMessage());
        }

        try {
            new Rectangle(p1, null, p3, p4);
            fail("Expected exception not thrown");
        } catch (ShapeException e) {
            assertEquals("Invalid vertex or vertices", e.getMessage());
        }
    }


    @Test
    public void testArea() throws ShapeException {
        Point p1 = new Point(0, 0);
        Point p2 = new Point(4, 0);
        Point p3 = new Point(4, 4);
        Point p4 = new Point(0, 4);
        Rectangle r1 = new Rectangle(p1, p2, p3, p4);
        assertEquals(r1.area(), 16, 0);
        assertEquals(r1.getBreadth(), 4, 0);
        assertEquals(r1.getLength(), 4, 0);

        Point p5 = new Point(-2, -2);
        Point p6 = new Point(-2, -8);
        Point p7 = new Point(-4, -8);
        Point p8 = new Point(-4, -2);
        Rectangle r2 = new Rectangle(p5, p6, p7, p8);
        assertEquals(r2.area(), 12, 0);
        assertEquals(r2.getLength(), 6, 0);
        assertEquals(r2.getBreadth(), 2, 0);
    }

    @Test
    public void testGetLength() {
    }

    @Test
    public void testGetBreadth() {
    }

    @Test
    public void testMove() throws ShapeException {
        Point p5 = new Point(-2, -2);
        Point p6 = new Point(-2, -8);
        Point p7 = new Point(-4, -8);
        Point p8 = new Point(-4, -2);

        Rectangle r2 = new Rectangle(p5, p6, p7, p8);
        r2.move(0.5, 0.5);
        assert r2.getPoint1().equalsTo(new Point(-1.5, -1.5));
        assert r2.getPoint2().equalsTo(new Point(-1.5, -7.5));
        assert r2.getPoint3().equalsTo(new Point(-3.5, -7.5));
        assert r2.getPoint4().equalsTo(new Point(-3.5, -1.5));

        try {
            r2.move(Double.POSITIVE_INFINITY, 1);
            fail("Expected exception not thrown");
        } catch (ShapeException e) {
            assertEquals("Invalid delta-x value", e.getMessage());
        }

        try {
            r2.move(Double.NEGATIVE_INFINITY, 1);
            fail("Expected exception not thrown");
        } catch (ShapeException e) {
            assertEquals("Invalid delta-x value", e.getMessage());
            // ignore
        }

        try {
            r2.move(Double.NaN, 1);
            fail("Expected exception not thrown");
        } catch (ShapeException e) {
            assertEquals("Invalid delta-x value", e.getMessage());
        }

        try {
            r2.move(1, Double.POSITIVE_INFINITY);
            fail("Expected exception not thrown");
        } catch (ShapeException e) {
            assertEquals("Invalid delta-y value", e.getMessage());
        }

        try {
            r2.move(1, Double.NEGATIVE_INFINITY);
            fail("Expected exception not thrown");
        } catch (ShapeException e) {
            assertEquals("Invalid delta-y value", e.getMessage());
        }

        try {
            r2.move(1, Double.NaN);
            fail("Expected exception not thrown");
        } catch (ShapeException e) {
            assertEquals("Invalid delta-y value", e.getMessage());
        }

    }
}
