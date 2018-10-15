package examples.shapes;

// Implement a serializer and deserializer
// reads composite shapes
// saves composite shapes

import java.awt.image.BufferedImage;
import java.io.*;

public class FileIO {

    public CompositeShape readShape(String filename) throws Exception {
        // Filename
        File file = new File(filename);

        // buffer for file reader
        BufferedReader br = new BufferedReader(new FileReader(file));

        String line;
        String shape ="";
        // Split by line and then split by space
        while ((line = br.readLine()) != null)
            shape = shape.concat(line+System.lineSeparator());

        // Parse the input
        ShapeFactory shapeObject = new ShapeFactory();
        CompositeShape compositeShape = shapeObject.create(shape);
        return compositeShape;
    }

    public void writeShape(String filename, CompositeShape shape) throws Exception {
        try (Writer writer = new BufferedWriter(new OutputStreamWriter(
                new FileOutputStream(filename), "utf-8"))) {
            writer.write(shape.toString());
        }
    }

}