package examples.shapes;

import org.junit.Test;

import static org.junit.Assert.*;

public class FileIOTest {

    @Test
    public void readWriteShape() throws Exception {
        Point p1 = new Point(0, 0);
        Point p2 = new Point(4, 0);
        Point p3 = new Point(4, 4);
        Point p4 = new Point(0, 4);

        Point p5 = new Point(4, 6);
        Point p6 = new Point(0, 6);

        Rectangle rectangle = new Rectangle(p1, p2, p5, p6);
        Square square = new Square(p1, p2, p3, p4);
        Triangle triangle = new Triangle(p1, p2, p3);
        Line line = new Line(p1, p5);
        Ellipse ellipse = new Ellipse(10, 10, 50, 40);
        Circle circle = new Circle(20, 20, 40);

        String imageFilename = "image.jpg";
        String compositeFilename = "composite.jpg";
        EmbedImage embedImage = new EmbedImage(imageFilename, 10, 10, 200, 200);

        CompositeShape compositeShape = new CompositeShape();
        compositeShape.addShape(triangle);
        compositeShape.addShape(rectangle);
        compositeShape.addShape(square);
        compositeShape.addShape(line);
        compositeShape.addShape(ellipse);
        compositeShape.addShape(circle);

        CompositeShape nextCompositeShape = new CompositeShape();
        compositeShape.addShape(embedImage);
        nextCompositeShape.addShape(rectangle);
        nextCompositeShape.addShape(circle);
        compositeShape.addShape(nextCompositeShape);

        double area = compositeShape.area();
        System.out.println("Computed area of the composite shape is :" + area);

        String filename = "test.txt";
        FileIO file = new FileIO();
        file.writeShape(filename, compositeShape);

        CompositeShape readCompositeShape = null;
        readCompositeShape = file.readShape(filename);
        System.out.println("\nRead Object from file: \n" + readCompositeShape.toString());
        System.out.println("\nExpected Object from file: \n" + compositeShape.toString());
        assert readCompositeShape.toString().equals(compositeShape.toString());
    }
}