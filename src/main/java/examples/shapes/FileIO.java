package examples.shapes;

// Implement a serializer and deserializer
// reads composite shapes
// saves composite shapes

import java.io.*;

public class FileIO {

    public String readShape(String filename) throws Exception {
        // Filename
        File file = new File(filename);

        // buffer for file reader
        BufferedReader br = new BufferedReader(new FileReader(file));

        String line;
        String shape ="";
        // Split by line and then split by space
        while ((line = br.readLine()) != null)
            shape = shape.concat(line);

        // Parse the input
        return shape;

    }

    public void writeShape(String filename, String shape) throws Exception {
        try (Writer writer = new BufferedWriter(new OutputStreamWriter(
                new FileOutputStream(filename), "utf-8"))) {
            writer.write(shape);
        }
    }

    public static void main(String[] args) throws Exception {
        // Filename
        String filename = "D:/test.txt";
        FileIO reader = new FileIO();
        reader.readShape(filename);
        reader.writeShape("D:/newshape.txt","This is me saving my new shape");
    }
}