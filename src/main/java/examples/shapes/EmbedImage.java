package examples.shapes;

import javafx.scene.image.Image;

import java.io.File;

public class EmbedImage {
    private CompositeShape compositeShape;
    private Image image;
    private File file;

    public EmbedImage(CompositeShape shapes, Image image, File file) {
        this.compositeShape = shapes; // could be simple shape or composite shape
        this.image = image;
        this.file = file;
    }

    public void render() {

    }
}
