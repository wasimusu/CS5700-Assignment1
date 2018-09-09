package examples.shapes;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class RectangleTest {

    @Test
    public void testValidConstruction() throws ShapeException {
        Point p1 = new Point(0, 0);
        Point p2 = new Point(4, 0);
        Point p3 = new Point(4, 4);
        Point p4 = new Point(0, 4);
        Rectangle r1 = new Rectangle(p1, p2, p3, p4);
    }

    @Test
    public void testInvalidConstruction() throws ShapeException {
    }

    @Test
    public void testArea() throws ShapeException {
        Point p1 = new Point(0, 0);
        Point p2 = new Point(4, 0);
        Point p3 = new Point(4, 4);
        Point p4 = new Point(0, 4);
        Rectangle r1 = new Rectangle(p1, p2, p3, p4);
        assertEquals(r1.area(), 16,0);
        assertEquals(r1.getBreadth(), 4, 0);
        assertEquals(r1.getLength(), 4, 0);

        Point p5 = new Point(-2, -2);
        Point p6 = new Point(-2, -8);
        Point p7 = new Point(-4, -8);
        Point p8 = new Point(-4, -2);
        Rectangle r2 = new Rectangle(p5, p6, p7, p8);
        assertEquals(r2.area(), 12,0);
        assertEquals(r2.getLength(), 6, 0);
        assertEquals(r2.getBreadth(), 2, 0);
    }

    @Test
    public void testGetLength() throws ShapeException {
    }

    @Test
    public void testGetBreadth() throws ShapeException {

    }

    @Test
    public void testMove() throws ShapeException {
        Point p5 = new Point(-2, -2);
        Point p6 = new Point(-2, -8);
        Point p7 = new Point(-4, -8);
        Point p8 = new Point(-4, -2);
        Rectangle r2 = new Rectangle(p5, p6, p7, p8);
        r2.move(0.5,0.5);
    }
}
