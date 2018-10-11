package examples.shapes;

import javafx.scene.image.Image;

public class EmbedImage {
    private CompositeShape compositeShape;
    private Image image;

    public EmbedImage(CompositeShape shapes, Image image) {
        this.compositeShape = shapes; // could be simple shape or composite shape
        this.image = image;
    }

    public void render(){

    }

    @Override
    public String toString() {
        return "EmbedImage:" ;
//                String.valueOf(this.getPoint1().getX()) + "," +
//                String.valueOf(this.getPoint1().getY()) + "," +
//                String.valueOf(this.getPoint2().getX()) + "," +
//                String.valueOf(this.getPoint2().getY()) + "," +
//                String.valueOf(this.getPoint3().getX()) + "," +
//                String.valueOf(this.getPoint3().getY());
    }

    public EmbedImage(String string) throws ShapeException{
        // Expecting only parameters
        // x, y, majorRadius, minorRadius
        String[] strings = string.split(",");
    }
}
