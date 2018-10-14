package examples.shapes;
import java.awt.*;
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
        String string = "Composite:" + String.valueOf(this.composites.size())+System.lineSeparator();
        for (Shapes shape : composites) {
            string = string.concat(shape.toString()+System.lineSeparator());
        }
        return string;
    }

    public void render(Graphics2D graphics) {
        // Iterate through all the shapes and render them individually
        for (Shapes shape : composites) {
            shape.render(graphics);
        }
    }

    public CompositeShape(String string) throws ShapeException{
        // Expecting only parameters
        // x, y, majorRadius, minorRadius
        String[] strings = string.split(",");
    }

}
