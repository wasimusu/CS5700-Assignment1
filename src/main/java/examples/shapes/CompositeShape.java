package examples.shapes;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;


public class CompositeShape implements Shapes {
    private ArrayList<Shapes> composites;

    public CompositeShape() throws Exception {
        composites = new ArrayList<Shapes>();
    }

    public void addShape(Shapes shape) throws Exception {
        composites.add(shape);
    }

    public void removeShape(Shapes shape) throws Exception {
        composites.remove(shape);
    }

    public void move(double deltaX, double deltaY) throws ShapeException {
        // Iterate through all the shapes and move them
        for (Shapes shape : composites) {
            shape.move(deltaX, deltaY);
        }
    }

    public double area() throws ShapeException {
        double totalArea = 0;
        // Iterate through all the shapes and add their area to the total
        for (Shapes shape : composites) {
            totalArea += shape.area();
        }
        return totalArea;
    }

    @Override
    public String toString() {
        String string = "Composite:" + String.valueOf(this.composites.size()) + System.lineSeparator();
        for (Shapes shape : composites) {
            string = string.concat(shape.toString() + System.lineSeparator());
        }
        return string;
    }

    public void render(Graphics2D graphics) {
        // Construct the bufferedImage of one of the predefined image types
//        int width = 800;
//        int height = 800;
//        BufferedImage bufferedImage = new BufferedImage(width,height,BufferedImage.TYPE_INT_RGB);

        // create a graphics which can be used to draw into buffered image
//        Graphics2D graphics = bufferedImage.createGraphics();
        graphics.setColor(Color.white);

        // Iterate through all the shapes and render them individually
        for (Shapes shape : composites) {
            shape.render(graphics);
        }

        // Save the rendered image
        // Save as PNG
//        File file = new File("image.png");
//        ImageIO.write(graphics,"png",file);
//        graphics.dispose();

    }

}
