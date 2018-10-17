package examples.shapes;

import org.junit.Test;

import java.awt.*;
import java.awt.image.BufferedImage;

public class EmbedImageTest {

    @Test
    public void constructorTest() throws Exception {
        String filename = "image.png";
        EmbedImage embedImage1 = new EmbedImage(filename, 10, 10, 40, 40);
        EmbedImage embedImage2 = new EmbedImage(filename, 10, 100, 40, 40);

        String filename1 = "selfie.jpg";
        EmbedImage embedImage3 = new EmbedImage(filename1, 10, 10, 100, 100);
        EmbedImage embedImage4 = new EmbedImage(filename1, 10, 100, 100, 100);
        EmbedImage embedImage5 = new EmbedImage(filename1, 10, 100, 100, 100);

        assert !embedImage1.toString().equals(embedImage2.toString());
        assert !embedImage3.toString().equals(embedImage4.toString());
        assert embedImage4.toString().equals(embedImage5.toString());
    }

    @Test
    public void areaTest() throws Exception {
        String filename = "image.png";
        EmbedImage embedImage = new EmbedImage(filename, 10, 10, 40, 40);
        assert embedImage.area() == 1600;
    }

    @Test
    public void moveTest() throws Exception {
        String filename = "image.png";
        EmbedImage embedImage1 = new EmbedImage(filename, 10, 10, 40, 40);
        embedImage1.move(10, 10);
        assert new Point(20, 20).equalsTo(embedImage1.getStartPoint());
        assert embedImage1.area() == 1600;
    }

    @Test
    public void stringConstructorTest() throws Exception {
        // If strings of two objects are identical the objects are identical
        String filename = "image.png";
        EmbedImage embedImage = new EmbedImage(filename, 10, 10, 40, 40);
        EmbedImage newEmbedImage = new EmbedImage(embedImage.toString());
        assert newEmbedImage.toString().equals(embedImage.toString());
    }

    @Test
    public void startPointTest() throws Exception {
        String filename = "image.png";
        EmbedImage embedImage = new EmbedImage(filename, 10, 10, 40, 40);
        assert new Point(10, 10).equalsTo(embedImage.getStartPoint());
    }

    @Test
    public void render() throws Exception {
        // Test by manual inspection

        String filename = "image.png";
        EmbedImage embedImage = new EmbedImage(filename, 10, 10, 40, 40);
        // Construct the bufferedImage of one of the predefined image types
        BufferedImage bufferedImage = new BufferedImage(400, 400, BufferedImage.TYPE_INT_RGB);

        // create a graphics which can be used to draw into buffered image
        Graphics2D graphics = bufferedImage.createGraphics();
        graphics.setColor(Color.white);

        embedImage.render(graphics);
    }

}