package examples.shapes;

import org.junit.Test;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;

import static org.junit.Assert.*;

public class LineTest {

    @Test
    public void testValidConstruction() throws ShapeException {
        Point p1 = new Point(1, 2);
        Point p2 = new Point(4, 10);

        Line myLine = new Line(p1, p2);
        assertSame(p1, myLine.getPoint1());
        assertSame(p2, myLine.getPoint2());

        p1 = new Point(1.4, 2.5);
        p2 = new Point(4.6, 10.7);
        myLine = new Line(p1, p2);
        assertSame(p1, myLine.getPoint1());
        assertSame(p2, myLine.getPoint2());

        myLine = new Line(1, 3.33, 4.444, 5.5555);
        assertEquals(1, myLine.getPoint1().getX(), 0);
        assertEquals(3.33, myLine.getPoint1().getY(), 0);
        assertEquals(4.444, myLine.getPoint2().getX(), 0);
        assertEquals(5.5555, myLine.getPoint2().getY(), 0);
    }

    @Test
    public void testInvalidConstruction() throws Exception {
        Point p1 = new Point(1, 2);
        Point p2 = new Point(4, 10);

        try {
            new Line(p1, null);
            fail("Expected exception not thrown for when the first parameter is null");
        } catch (ShapeException e) {
            assertEquals("Invalid Point", e.getMessage());
        }

        try {
            new Line(null, p2);
            fail("Expected exception not thrown for when the second parameter is null");
        } catch (ShapeException e) {
            assertEquals("Invalid Point", e.getMessage());
        }

        try {
            new Line(Double.POSITIVE_INFINITY, 2, 3, 4);
            fail("Expected exception not thrown");
        } catch (ShapeException e) {
            assertEquals("Invalid x-location", e.getMessage());
        }

        try {
            new Line(1, Double.POSITIVE_INFINITY, 3, 4);
            fail("Expected exception not thrown");
        } catch (Exception e) {
            assertEquals("Invalid y-location", e.getMessage());
        }

        try {
            new Line(1, 2, Double.POSITIVE_INFINITY, 4);
            fail("Expected exception not thrown");
        } catch (Exception e) {
            assertEquals("Invalid x-location", e.getMessage());
        }

        try {
            new Line(1, 2, 3, Double.POSITIVE_INFINITY);
            fail("Expected exception not thrown");
        } catch (ShapeException e) {
            assertEquals("Invalid y-location", e.getMessage());
        }

        try {
            new Line(p1, p1);
            fail("Expected exception not thrown");
        } catch (ShapeException e) {
            assertEquals("A line must have a length > 0", e.getMessage());
        }

        try {
            new Line(1, 2, 1, 2);
            fail("Expected exception not thrown");
        } catch (Exception e) {
            assertEquals("A line must have a length > 0", e.getMessage());
        }
    }

    @Test
    public void testMove() throws ShapeException {
        Line myLine = new Line(1, 2, 4, 10);

        myLine.move(3, 4);
        assertEquals(4, myLine.getPoint1().getX(), 0);
        assertEquals(6, myLine.getPoint1().getY(), 0);
        assertEquals(7, myLine.getPoint2().getX(), 0);
        assertEquals(14, myLine.getPoint2().getY(), 0);

        myLine.move(.4321, .7654);
        assertEquals(4.4321, myLine.getPoint1().getX(), 0);
        assertEquals(6.7654, myLine.getPoint1().getY(), 0);
        assertEquals(7.4321, myLine.getPoint2().getX(), 0);
        assertEquals(14.7654, myLine.getPoint2().getY(), 0);

        myLine.move(-0.4321, -0.7654);
        assertEquals(4, myLine.getPoint1().getX(), 0);
        assertEquals(6, myLine.getPoint1().getY(), 0);
        assertEquals(7, myLine.getPoint2().getX(), 0);
        assertEquals(14, myLine.getPoint2().getY(), 0);
    }

    @Test
    public void testComputeLength() throws ShapeException {

        Line myLine = new Line(1, 2, 4, 10);
        assertEquals(8.544, myLine.computeLength(), 0.001);

        myLine = new Line(1, 2, 1, 3);
        assertEquals(Math.sqrt(1), myLine.computeLength(), 0.001);

        myLine = new Line(3, -2, -4, 10);
        assertEquals(13.892, myLine.computeLength(), 0.001);
    }

    @Test
    public void testComputeSlope() throws ShapeException {
        Line myLine = new Line(2, 2, 4, 10);
        assertEquals(4.0, myLine.computeSlope(), 0.1);

        myLine = new Line(2, 2, 10, 4);
        assertEquals(0.25, myLine.computeSlope(), 0.1);

        myLine = new Line(2, 2, 4, 2);
        assertEquals(0, myLine.computeSlope(), 0.1);

        myLine = new Line(2, 2, 2, 4);
        assertEquals(Double.POSITIVE_INFINITY, myLine.computeSlope(), 0.1);

        myLine = new Line(2, 4, 2, 2);
        assertEquals(Double.NEGATIVE_INFINITY, myLine.computeSlope(), 0.1);
    }

    @Test
    public void render() throws Exception {
        // Test by manual inspection
        String outputFilename = "line.png";

        // Construct the bufferedImage of one of the predefined image types
        BufferedImage bufferedImage = new BufferedImage(400, 400, BufferedImage.TYPE_INT_RGB);

        // create a graphics which can be used to draw into buffered image
        Graphics2D graphics = bufferedImage.createGraphics();
        graphics.setColor(Color.white);

        // Generate set of lines and render them
        for (int i = 1; i <= 10; i++) {
            Point p1 = new Point(0, i*40);
            Point p2 = new Point(400, i*40);
            Point p3 = new Point(i*40, 0);
            Point p4 = new Point(i*40, 400);

            Line line1 = new Line(p1, p2);
            Line line2 = new Line(p3, p4);
            line1.render(graphics);
            line2.render(graphics);
        }
        // Save as PNG and release resource
        File file = new File(outputFilename);
        ImageIO.write(bufferedImage, "png", file);
        graphics.dispose();
    }


}