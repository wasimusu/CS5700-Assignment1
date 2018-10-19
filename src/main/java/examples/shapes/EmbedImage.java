package examples.shapes;

import java.awt.*;
import java.util.HashMap;

public class EmbedImage implements Shapes{
    private Point startPoint;
    private int height;
    private int width;
    private UserImage userImage;
    private String filename;
    private static HashMap<String, UserImage> stringImageHashMap = new HashMap<String, UserImage>();

    public EmbedImage(String filename, double x, double y, int height, int width) throws Exception {
        this.startPoint = new Point(x, y);
        this.height = height;
        this.width = width;
        this.filename = filename;
        this.userImage = stringImageHashMap.get(filename);

        // If this object did not exist before, instantiate a new object
        if (this.userImage == null) {
            this.userImage = new UserImage(this.filename);
            stringImageHashMap.put(filename, this.userImage);
            System.out.println("New object instantiated");
        }
    }

    public double area(){
        return this.width*this.height;
    }

    public void move(double deltaX, double deltaY) throws ShapeException{
        this.startPoint.move(deltaX, deltaY);
    }

    public void render(Graphics2D graphics) {
        this.userImage.render(graphics, this.startPoint.getX(), this.startPoint.getY(), this.height, this.width);
    }

    public Point getStartPoint(){
        return this.startPoint;
    }

    @Override
    public String toString() {
        return "EmbedImage:" +
                this.filename + "," +
                this.startPoint.getX() + "," +
                this.startPoint.getY() + "," +
                this.height + "," +
                this.width;
    }

    public EmbedImage(String string) throws ShapeException {
        // Expecting only parameters
        if (string.toLowerCase().contains("embedimage:"))
            string = string.split(":")[1];

        String[] strings = string.split(",");
        this.filename = strings[0];
        double x = Double.valueOf(strings[1]);
        double y = Double.valueOf(strings[2]);
        this.height = Integer.valueOf(strings[3]);
        this.width = Integer.valueOf(strings[4]);
        this.startPoint = new Point(x, y);
    }
}
