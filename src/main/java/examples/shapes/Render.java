package examples.shapes;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Render extends JPanel {
//    public void paint(Graphics g) {
//        g.drawRect(10, 10, 200, 300);
//    }

    public static void main(String[] args) throws Exception{
//        JFrame frame = new JFrame("Welcome to JavaTutorial.net");
//        frame.getContentPane().add(new Render());
//        frame.setSize(600, 400);
//        frame.setVisible(true);
//        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        frame.setResizable(false);

        File imageFile = new File("/template.jpg");
        BufferedImage img = ImageIO.read(imageFile);

        Graphics graph = img.createGraphics();
        graph.setColor(Color.BLACK);
        graph.drawRect(10,10,200,300);
        graph.dispose();

        ImageIO.write(img, "jpg", new File("/template.jpg"));
    }
}


