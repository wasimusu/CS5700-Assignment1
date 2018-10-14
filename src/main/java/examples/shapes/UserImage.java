package examples.shapes;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;

public class UserImage {

    private BufferedImage bufferedImage;
    private File file;

    public UserImage(String filename) throws Exception {
        this.file = new File(filename);
        this.bufferedImage = ImageIO.read(file);
    }

    public void render(Graphics2D graphics, double x, double y){
        // render image
        graphics.drawImage(this.bufferedImage, 0, 0, null);
    }
}
