package examples.shapes;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TriangleTest {

    @Test
    public void testValidConstruction() throws ShapeException {
        Point p1 = new Point(0, 0);
        Point p2 = new Point(4, 0);
        Point p3 = new Point(4, 4);
        Point p4 = new Point(0, 4);

        Triangle t1 = new Triangle(p1, p2, p3);
        Triangle t2 = new Triangle(p1, p2, p4);

        assertEquals(t1.area(), 8, 0);
        assertEquals(t2.area(), 8, 0);

        Point p5 = new Point(-2, -2);
        Point p6 = new Point(-2, -8);
        Point p7 = new Point(-4, -8);
        Point p8 = new Point(-4, -2);

        Triangle t3 = new Triangle(p5, p6, p7);
        Triangle t4 = new Triangle(p5, p6, p8);

        System.out.println("Area : " + t3.area());
        System.out.println("Area : " + t4.area());
        assertEquals(t3.area(), 6, 0);
        assertEquals(t4.area(), 6, 0);
    }

    @Test
    public void testInvalidConstruction() throws ShapeException {

    }

    @Test
    public void testArea() throws ShapeException {

    }

    @Test
    public void testMove() throws ShapeException {

    }
}
