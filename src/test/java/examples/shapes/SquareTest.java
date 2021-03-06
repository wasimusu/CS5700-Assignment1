package examples.shapes;

import org.junit.Test;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

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

        assert p1.equalsTo(s1.getPoint1());
        assert p2.equalsTo(s1.getPoint2());
        assert p3.equalsTo(s1.getPoint3());
        assert p4.equalsTo(s1.getPoint4());

        Point p5 = new Point(-2, -2);
        Point p6 = new Point(-2, -8);
        Point p7 = new Point(-8, -8);
        Point p8 = new Point(-8, -2);

        Square r2 = new Square(p5, p6, p7, p8);

        assertEquals(r2.area(), 36, 0);
        assertEquals(r2.getLength(), 6, 0);

        assert p1.equalsTo(s1.getPoint1());
        assert p2.equalsTo(s1.getPoint2());
        assert p3.equalsTo(s1.getPoint3());
        assert p4.equalsTo(s1.getPoint4());
    }

    @Test
    public void testInvalidConstruction() throws ShapeException {
        Point p1 = new Point(0, 0);
        Point p2 = new Point(8, 0);
        Point p3 = new Point(8, 4);
        Point p4 = new Point(0, 4);

        // Testing if Square accepts rectangles
        try {
            Square s1 = new Square(p1, p2, p3, p4);
            fail("Expected exception not thrown");
        } catch (ShapeException e) {
            assertEquals("All sides are not equal", e.getMessage());
        }

        // Testing lines with zero length in a square
        Point zero = new Point(0, 0);
        try {
            Square s1 = new Square(zero, zero, zero, zero);
            fail("Expected exception not thrown");
        } catch (ShapeException e) {
            assertEquals("A line must have a length > 0", e.getMessage());
        }

        // Testing null points as vertices
        try {
            new Square(null, null, null, null);
            fail("Expected exception not thrown");
        } catch (ShapeException e) {
            assertEquals("Invalid vertex or vertices", e.getMessage());
        }

        try {
            new Square(null, p2, p3, p4);
            fail("Expected exception not thrown");
        } catch (ShapeException e) {
            assertEquals("Invalid vertex or vertices", e.getMessage());
        }

        try {
            new Square(p1, null, p3, p4);
            fail("Expected exception not thrown");
        } catch (ShapeException e) {
            assertEquals("Invalid vertex or vertices", e.getMessage());
        }
    }

    @Test
    public void render() throws Exception {
        // Test by manual inspection
        String outputFilename = "square.png";

        // Construct the bufferedImage of one of the predefined image types
        BufferedImage bufferedImage = new BufferedImage(400, 400, BufferedImage.TYPE_INT_RGB);

        // create a graphics which can be used to draw into buffered image
        Graphics2D graphics = bufferedImage.createGraphics();
        graphics.setColor(Color.white);

        // Generate set of squares and render them
        for (int i = 1; i <= 11; i++) {
            Point p1 = new Point(0, 0);
            Point p2 = new Point(40 * i, 0);
            Point p3 = new Point(40 * i, 40 * i);
            Point p4 = new Point(0, 40 * i);

            Square square = new Square(p1, p2, p3, p4);
            square.render(graphics);
        }
        // Save as PNG and release resource
        File file = new File(outputFilename);
        ImageIO.write(bufferedImage, "png", file);
        graphics.dispose();
    }


}
