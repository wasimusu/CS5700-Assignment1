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
        String string = "Composite:" + String.valueOf(this.composites.size())+"\n";
        for (Shapes shape : composites) {
            string = string.concat(shape.toString()+"\n");
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

    public static void main(String[] args) throws Exception {
        Point p1 = new Point(0, 0);
        Point p2 = new Point(4, 0);
        Point p3 = new Point(4, 4);
        Point p4 = new Point(0, 4);
        Rectangle rectangle = new Rectangle(p1, p2, p3, p4);
        Triangle triangle = new Triangle(p1, p2, p3);
        CompositeShape compositeShape = new CompositeShape();
        compositeShape.addShape(triangle);
        compositeShape.addShape(rectangle);
        double area = compositeShape.area();
        System.out.println("Computed area of the composite shape is :" + area);
    }
}
