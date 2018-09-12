package examples.shapes;

public interface Shapes {
    public void move(double deltaX, double deltaY) throws ShapeException;
    public double area() throws ShapeException;
}
