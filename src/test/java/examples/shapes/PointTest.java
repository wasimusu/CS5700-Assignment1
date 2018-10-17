package examples.shapes;

import org.junit.Test;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;

import static org.junit.Assert.*;

public class PointTest {

    @Test
    public void testValidConstruction() throws Exception {
        Point p1 = new Point(1, 2);
        assertEquals(1, p1.getX(), 0);
        assertEquals(2, p1.getY(), 0);

        p1 = new Point(1.111, 2.222);
        assertEquals(1.111, p1.getX(), 0);
        assertEquals(2.222, p1.getY(), 0);
    }

    @Test
    public void testInvalidConstruction() {

        try {
            new Point(1, Double.POSITIVE_INFINITY);
            fail("Expected exception not thrown");
        } catch (Exception e) {
            assertEquals("Invalid y-location", e.getMessage());
        }

        try {
            new Point(1, Double.NEGATIVE_INFINITY);
            fail("Expected exception not thrown");
        } catch (Exception e) {
            assertEquals("Invalid y-location", e.getMessage());
        }

        try {
            new Point(1, Double.NaN);
            fail("Expected exception not thrown");
        } catch (Exception e) {
            assertEquals("Invalid y-location", e.getMessage());
        }

        try {
            new Point(Double.POSITIVE_INFINITY, 1);
            fail("Expected exception not thrown");
        } catch (Exception e) {
            assertEquals("Invalid x-location", e.getMessage());
        }

        try {
            new Point(Double.NEGATIVE_INFINITY, 1);
            fail("Expected exception not thrown");
        } catch (Exception e) {
            assertEquals("Invalid x-location", e.getMessage());
        }

        try {
            new Point(Double.NaN, 1);
            fail("Expected exception not thrown");
        } catch (Exception e) {
            assertEquals("Invalid x-location", e.getMessage());
        }

    }

    @Test
    public void testMoveX() throws Exception {
        Point p1 = new Point(1, 2);

        p1.move(10, 0);
        assertEquals(11, p1.getX(), 0);
        assertEquals(2, p1.getY(), 0);

        p1.move(0.1234, 0);
        assertEquals(11.1234, p1.getX(), 0);
        assertEquals(2, p1.getY(), 0);

        p1.move(-20, 0);
        assertEquals(-8.8766, p1.getX(), 0);
        assertEquals(2, p1.getY(), 0);

        p1.move(0, 0);
        assertEquals(-8.8766, p1.getX(), 0);
        assertEquals(2, p1.getY(), 0);

        try {
            p1.move(Double.POSITIVE_INFINITY, 0);
            fail("Expected exception not thrown");
        } catch (Exception e) {
            assertEquals("Invalid delta-x value", e.getMessage());
        }

        try {
            p1.move(Double.NEGATIVE_INFINITY, 0);
            fail("Expected exception not thrown");
        } catch (Exception e) {
            assertEquals("Invalid delta-x value", e.getMessage());
        }

        try {
            p1.move(Double.NaN, 0);
            fail("Expected exception not thrown");
        } catch (Exception e) {
            assertEquals("Invalid delta-x value", e.getMessage());
        }

    }

    @Test
    public void testMoveY() throws Exception {
        Point p1 = new Point(1, 2);

        p1.move(0, 10);
        assertEquals(1, p1.getX(), 0);
        assertEquals(12, p1.getY(), 0);

        p1.move(0, 0.1234);
        assertEquals(1, p1.getX(), 0);
        assertEquals(12.1234, p1.getY(), 0);

        p1.move(0, -20);
        assertEquals(1, p1.getX(), 0);
        assertEquals(-7.8766, p1.getY(), 0);

        p1.move(0, 0);
        assertEquals(1, p1.getX(), 0);
        assertEquals(-7.8766, p1.getY(), 0);

        try {
            p1.move(0, Double.POSITIVE_INFINITY);
            fail("Expected exception not thrown");
        } catch (Exception e) {
            assertEquals("Invalid delta-y value", e.getMessage());
        }

        try {
            p1.move(0, Double.NEGATIVE_INFINITY);
            fail("Expected exception not thrown");
        } catch (Exception e) {
            assertEquals("Invalid delta-y value", e.getMessage());
        }

        try {
            p1.move(0, Double.NaN);
            fail("Expected exception not thrown");
        } catch (Exception e) {
            assertEquals("Invalid delta-y value", e.getMessage());
        }

    }

    @Test
    public void testMove() throws Exception {
        Point p1 = new Point(1, 2);

        p1.move(10, 20);
        assertEquals(11, p1.getX(), 0);
        assertEquals(22, p1.getY(), 0);

        p1.move(0.222, 0.333);
        assertEquals(11.222, p1.getX(), 0);
        assertEquals(22.333, p1.getY(), 0);

        p1.move(-0.222, -0.333);
        assertEquals(11, p1.getX(), 0);
        assertEquals(22, p1.getY(), 0);

        p1.move(-20, -30);
        assertEquals(-9, p1.getX(), 0);
        assertEquals(-8, p1.getY(), 0);

        try {
            p1.move(1, Double.POSITIVE_INFINITY);
            fail("Expected exception not thrown");
        } catch (Exception e) {
            assertEquals("Invalid delta-y value", e.getMessage());
        }

        try {
            p1.move(1, Double.NEGATIVE_INFINITY);
            fail("Expected exception not thrown");
        } catch (Exception e) {
            assertEquals("Invalid delta-y value", e.getMessage());
        }

        try {
            p1.move(1, Double.NaN);
            fail("Expected exception not thrown");
        } catch (Exception e) {
            assertEquals("Invalid delta-y value", e.getMessage());
        }

        try {
            p1.move(Double.POSITIVE_INFINITY, 1);
            fail("Expected exception not thrown");
        } catch (Exception e) {
            assertEquals("Invalid delta-x value", e.getMessage());
        }

        try {
            p1.move(Double.NEGATIVE_INFINITY, 1);
            fail("Expected exception not thrown");
        } catch (Exception e) {
            assertEquals("Invalid delta-x value", e.getMessage());
        }

        try {
            p1.move(Double.NaN, 1);
            fail("Expected exception not thrown");
        } catch (Exception e) {
            assertEquals("Invalid delta-x value", e.getMessage());
        }

    }

    @Test
    public void testClone() throws ShapeException {
        Point p1 = new Point(-123.45, -23.45);
        assertEquals(-123.45, p1.getX(), 0);
        assertEquals(-23.45, p1.getY(), 0);

        Point p2 = p1.copy();
        assertNotSame(p1, p2);
        assertEquals(p1.getX(), p2.getX(), 0);
        assertEquals(p1.getY(), p2.getY(), 0);
    }

    @Test
    public void testEqualsTo() throws ShapeException {
        Point p1 = new Point(-123.45, -23.45);
        Point p2 = p1.copy();
        assert p1.equalsTo(p2);

        Point p3 = new Point(0.5, -23.45);
        Point p4 = new Point(0.5, -23.45);
        assert p3.equalsTo(p4);

        p4.move(0.4, 0);
        assert !p3.equalsTo(p4);

        p1.move(0.2, 0.1);
        assert !p1.equalsTo(p2);
    }

    @Test
    public void stringConstructorTest() throws ShapeException {
        Point p1 = new Point(-123.45, -23.45);
        Point p2 = new Point(p1.toString());
        assert p2.equalsTo(p1);
    }

    @Test
    public void renderTest() throws Exception {
        // Test by manual inspection

        Point point = new Point(20, 20);

        // Construct the bufferedImage of one of the predefined image types
        BufferedImage bufferedImage = new BufferedImage(40, 40, BufferedImage.TYPE_INT_RGB);
        // create a graphics which can be used to draw into buffered image
        Graphics2D graphics = bufferedImage.createGraphics();
        graphics.setColor(Color.white);

        point.render(graphics);
    }

    @Test
    public void areaTest() throws Exception {
        Point point = new Point(20, 20);
        assertEquals(point.area(), 0, 0);
    }

    @Test
    public void render() throws Exception {
        // Test by manual inspection
        String outputFilename = "point.png";

        // Construct the bufferedImage of one of the predefined image types
        BufferedImage bufferedImage = new BufferedImage(400, 400, BufferedImage.TYPE_INT_RGB);

        // create a graphics which can be used to draw into buffered image
        Graphics2D graphics = bufferedImage.createGraphics();
        graphics.setColor(Color.white);

        // generate set of points to render and render them
        for (int i = 1; i <= 400; i++) {
            Point point1 = new Point(i, i);
            Point point2 = new Point(i, 400 - i);
            point1.render(graphics);
            point2.render(graphics);
        }

        // Save as PNG and release resource
        File file = new File(outputFilename);
        ImageIO.write(bufferedImage, "png", file);
        graphics.dispose();
    }


}