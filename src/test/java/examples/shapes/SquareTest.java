package examples.shapes;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SquareTest {

    @Test
    public void testValidConstruction() throws ShapeException {
        Point p1 = new Point(0, 0);
        Point p2 = new Point(4, 0);
        Point p3 = new Point(4, 4);
        Point p4 = new Point(0, 4);
        Square s1 = new Square(p1, p2, p3, p4);
        assertEquals(s1.area(), 16, 0);
        assertEquals(s1.getLength(), 4, 0);

        Point p5 = new Point(-2, -2);
        Point p6 = new Point(-2, -8);
        Point p7 = new Point(-8, -8);
        Point p8 = new Point(-8, -2);
        Square r2 = new Square(p5, p6, p7, p8);
        assertEquals(r2.area(), 36, 0);
        assertEquals(r2.getLength(), 6, 0);
    }

    public void testInvalidConstruction() throws ShapeException {

    }

}
