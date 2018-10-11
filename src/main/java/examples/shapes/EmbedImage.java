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
}
