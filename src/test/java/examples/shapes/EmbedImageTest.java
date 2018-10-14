package examples.shapes;

import org.junit.Test;

import static org.junit.Assert.*;

public class EmbedImageTest {

    @Test
    public void constructorTest() throws Exception {
        String filename = "D:/hey.jpg";
        EmbedImage embedImage1 = new EmbedImage(filename, 10, 10);
        EmbedImage embedImage2 = new EmbedImage(filename, 10, 100);

        String filename1 = "D:/image.jpg";
        EmbedImage embedImage3 = new EmbedImage(filename1, 10, 10);
        EmbedImage embedImage4 = new EmbedImage(filename1, 10, 100);
        EmbedImage embedImage5 = new EmbedImage(filename1, 10, 100);

        assert !embedImage1.toString().equals(embedImage2.toString());
        assert !embedImage3.toString().equals(embedImage4.toString());
        assert embedImage4.toString().equals(embedImage5.toString());
    }

}