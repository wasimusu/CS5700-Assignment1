package examples.shapes;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ShapeFactoryTest {
    @Test
    public void testCreate() throws Exception {
        Point p1 = new Point(0, 0);
        Point p2 = new Point(40, 0);
        Point p3 = new Point(40, 40);
        Point p4 = new Point(0, 40);

        Point p5 = new Point(40, 60);
        Point p6 = new Point(0, 60);

        Rectangle rectangle = new Rectangle(p1, p2, p5, p6);
        Square square = new Square(p1, p2, p3, p4);
        Triangle triangle = new Triangle(p1, p2, p3);
        Line line = new Line(p1, p5);
        Ellipse ellipse = new Ellipse(100, 100, 50, 40);
        Circle circle = new Circle(200, 200, 40);

        CompositeShape compositeShape = new CompositeShape();
        compositeShape.addShape(triangle);
        compositeShape.addShape(rectangle);
        compositeShape.addShape(square);
        compositeShape.addShape(ellipse);
        compositeShape.addShape(circle);
        compositeShape.addShape(line);

        String shapeString = compositeShape.toString();
        ShapeFactory factory = new ShapeFactory();
        CompositeShape shapeFromString = factory.create(shapeString);

        System.out.println("Triangle : " + triangle.area());
        System.out.println("Rectangle : " + rectangle.area());
        System.out.println("Square : " + square.area());
        System.out.println("Ellipse : " + ellipse.area());
        System.out.println("Circle : " + circle.area());
        System.out.println("Line : " + line.area());

        assertEquals(compositeShape.area(), shapeFromString.area(), 0.5);
    }
}