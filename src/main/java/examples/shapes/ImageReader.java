package examples.shapes;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

// reads images from directories
public class ImageReader {
    public static void main(String[] args) {
        // Filename of the image to be read
        File file = new File("D:/hey.jpg");

        // Declare an initially null container for image
        BufferedImage image = null;

        try {
            // Read image
            image = ImageIO.read(file);

            ImageIO.write(image, "jpg", new File("D:/output.jpg"));

            ImageIO.write(image, "png", new File("D:/output.png"));

            ImageIO.write(image, "bmp", new File("D:/output.bmp"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("Saved image");
    }
}