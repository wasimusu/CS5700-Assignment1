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

        Rectangle rectangle = new Rectangle(p1, p2, p3, p4);
        Triangle triangle = new Triangle(p1, p2, p3);

        CompositeShape compositeShape = new CompositeShape();
        compositeShape.addShape(triangle);
        compositeShape.addShape(rectangle);

        double area = compositeShape.area();
        System.out.println("Computed area of the composite shape is :" + area);

        String filename = "D:/test.txt";
        FileIO file = new FileIO();
        file.writeShape(filename, compositeShape);

        CompositeShape readCompositeShape = null;
        readCompositeShape = file.readShape(filename);
        System.out.println("Read Object : \n" + readCompositeShape.toString());
        assert readCompositeShape.toString().equals(compositeShape.toString());
    }
}