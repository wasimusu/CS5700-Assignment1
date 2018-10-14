package examples.shapes;

public class ShapeFactory {

    public CompositeShape create(String string) throws Exception {
        CompositeShape compositeShape = new CompositeShape();
        string = string.toLowerCase();
        String[] shapes = string.split(System.getProperty("line.separator"));

        for (String shape : shapes) {
            String identifier = shape.split(":")[0];
            shape = shape.split(":")[1];
            if (identifier.equals("rectangle")) {
                System.out.println("Rectangle " + shape);
                Rectangle rectangle = new Rectangle(shape);
                compositeShape.addShape(rectangle);
            }

            if (identifier.equals("triangle")) {
                System.out.println("Triangle " + shape);
                Triangle triangle = new Triangle(shape);
                compositeShape.addShape(triangle);
            }

            if (identifier.equals("ellipse")) {
                System.out.println("Ellipse" + shape);
                Ellipse ellipse= new Ellipse(shape);
                compositeShape.addShape(ellipse);
            }

            if (identifier.equals("line")) {
                System.out.println("Line" + shape);
                Line line = new Line(shape);
                compositeShape.addShape(line);
            }
        }


        return compositeShape;
    }

    public static void main(String[] args) throws Exception {
        ShapeFactory shapeFactory = new ShapeFactory();
        shapeFactory.create("circle: 10 10 20 20");
        shapeFactory.create("rectangle 1 1 1 4 4 1 1 4");
    }
}
