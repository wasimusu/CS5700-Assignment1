package examples.shapes;

import org.junit.Test;

import java.io.File;

import static org.junit.Assert.*;

public class FileIOTest {

    @Test
    public void writeReadShape() throws Exception{
        String shape = "Composite / Shape1 / Shape2";
        String filename = "D:/test_shape.txt";
        FileIO fileIO = new FileIO();
        fileIO.writeShape(filename, shape);
        String readShape = fileIO.readShape(filename);
        System.out.println(readShape);
        System.out.println(shape);
        assertEquals(readShape, shape);
    }
}