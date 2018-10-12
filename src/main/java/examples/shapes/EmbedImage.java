package examples.shapes;
import javafx.scene.image.Image;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.HashMap;

public class EmbedImage {
    private Image image;
    private File file;
    private String filename;
    private BufferedImage bufferedImage;
    private static HashMap<String, EmbedImage> filenameEmbedImage = new HashMap<String, EmbedImage>();

    public EmbedImage(Image image, String filename) throws Exception {
        this.filename = filename;
        this.image = image;
        this.file = new File(filename);
        this.bufferedImage = ImageIO.read(this.file);
    }

    public void render(Graphics2D graphics) {
        graphics.drawImage(this.bufferedImage,0,0,null);
    }

    @Override
    public String toString() {
        return "EmbedImage:"+
                this.filename;
    }

    public EmbedImage(String string) throws ShapeException{
        // Expecting only parameters
        String[] strings = string.split(",");
    }

}
