package examples.shapes;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.io.File;
import java.io.IOException;

public class SaveImage {
    public static void main(String[] args) throws Exception{
        int width = 400;
        int height = 400;

        File imageFile = new File("selfie.jpg");
        BufferedImage image = ImageIO.read(imageFile);

        // Construct the bufferedImage of one of the predefined image types
        BufferedImage bufferedImage = new BufferedImage(width,height,BufferedImage.TYPE_INT_RGB);

        // create a graphics which can be used to draw into buffered image
        Graphics2D graphics = bufferedImage.createGraphics();
        graphics.setColor(Color.white);

//        graphics.drawRect(40,40,400,300);
//        graphics.drawImage(image, 80,80,100,300,null);
        // Release graphics resource

        Circle circle = new Circle(200, 200, 220);
        Ellipse circle1 = new Ellipse(200, 200, 200, 50);
        Circle circle2 = new Circle(200, 200, 100);
        circle.render(graphics);
        circle1.render(graphics);
        circle2.render(graphics);
        // Save as PNG
        File file = new File("image.png");
        ImageIO.write(bufferedImage,"png",file);

        graphics.dispose();

    }
}
