package examples.shapes;

import java.awt.*;
import java.util.HashMap;

public class EmbedImage {
    private Point point;
    private UserImage userImage;
    private String filename;
    private static HashMap<String, UserImage> stringImageHashMap = new HashMap<String, UserImage>();

    public EmbedImage(String filename, double x, double y) throws Exception {
        point = new Point(x, y);
        this.filename = filename;
        this.userImage = stringImageHashMap.get(filename);

        // If this object did not exist before, instantiate a new object
        if (this.userImage == null) {
            this.userImage = new UserImage(this.filename);
            stringImageHashMap.put(filename, this.userImage);
            System.out.println("New object instantiated");
        }
    }

    public void render(Graphics2D graphics) {
        this.userImage.render(graphics, this.point.getX(), this.point.getY());
    }

    @Override
    public String toString() {
        return "EmbedImage:" +
                this.filename + "," +
                this.point.getX() + "," +
                this.point.getY();
    }
    
    public EmbedImage(String string) throws ShapeException {
        // Expecting only parameters
        String[] strings = string.split(",");
        this.filename = strings[0];
        int x = Integer.valueOf(strings[1]);
        int y = Integer.valueOf(strings[2]);
        this.point = new Point(x, y);
    }
}
