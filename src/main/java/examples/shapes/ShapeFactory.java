package examples.shapes;

import java.util.HashMap;

public class ShapeFactory {

    public void create(String string) throws Exception {
        CompositeShape compositeShape = new CompositeShape();
        if (string.equals("circle")) {
            Ellipse circle = new Ellipse("circle");
            compositeShape.addShape(circle);
        }
        if (string.equals("rectangle")) {
            Rectangle r1 = new Rectangle("rectangle");
            compositeShape.addShape(r1);
        }

    }

    public static void main(String[] args) throws Exception {
        ShapeFactory shapeFactory = new ShapeFactory();
        shapeFactory.create("circle");
        shapeFactory.create("rectangle");
    }
}
