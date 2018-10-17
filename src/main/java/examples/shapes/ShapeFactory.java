package examples.shapes;

public class ShapeFactory {

    public CompositeShape create(String string) throws Exception {
        CompositeShape compositeShape = new CompositeShape();
        string = string.toLowerCase();
        String[] shapes = string.split(System.getProperty("line.separator"));

        for (int i = 1; i < shapes.length; i++) {
            System.out.println("Parsing : "+shapes[i]);
            String identifier = shapes[i].split(":")[0];
            String shape = shapes[i].split(":")[1];
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
                Ellipse ellipse = new Ellipse(shape);
                compositeShape.addShape(ellipse);
            }

            if (identifier.equals("line")) {
                System.out.println("Line" + shape);
                Line line = new Line(shape);
                compositeShape.addShape(line);
            }

            if (identifier.equals("embedimage")) {
                System.out.println("Line" + shape);
                EmbedImage embedImage= new EmbedImage(shape);
                compositeShape.addShape(embedImage);
            }

            if (identifier.equals("composite")) {
                int itemCount = Integer.valueOf(shapes[i].split(":")[1]);
                String nestedComposite = "";
                for (int j = 0; j <= itemCount; j++) {
                    System.out.println("Nested : " + shapes[i + j]);
                    nestedComposite = nestedComposite.concat(shapes[i + j] + System.lineSeparator());
                }
                ShapeFactory factory = new ShapeFactory();
                compositeShape.addShape(factory.create(nestedComposite));
                i += itemCount;
            }
        }

        return compositeShape;
    }
}
