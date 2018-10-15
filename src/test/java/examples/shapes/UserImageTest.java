package examples.shapes;

import org.junit.Test;

import java.awt.*;
import java.awt.image.BufferedImage;

public class UserImageTest {

    @Test
    public void render() throws Exception {
        // Test by manual inspection

        UserImage userImage = new UserImage("image.png");
        // Construct the bufferedImage of one of the predefined image types
        BufferedImage bufferedImage = new BufferedImage(400, 400, BufferedImage.TYPE_INT_RGB);

        // create a graphics which can be used to draw into buffered image
        Graphics2D graphics = bufferedImage.createGraphics();
        graphics.setColor(Color.white);

        userImage.render(graphics, 0, 0);
    }
}