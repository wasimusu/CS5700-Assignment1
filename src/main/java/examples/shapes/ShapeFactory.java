package examples.shapes;

public class ShapeFactory {

    public void create(String string) throws Exception {
        CompositeShape compositeShape = new CompositeShape();
        string = string.toLowerCase();

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
        shapeFactory.create("circle: 10 10 20 20");
        shapeFactory.create("rectangle 1 1 1 4 4 1 1 4");
    }
}
