package examples.shapes;

import java.io.*;


class SerialTest {
    public static void main(String[] args) throws ShapeException, IOException {
        Point center = new Point(1, 1);
        Circle object = new Circle(center, 5);
        String filename = "file.ser";

        // Serialization
        try {
            //Saving of object in a file
            FileOutputStream file = new FileOutputStream(filename);
            ObjectOutputStream out = new ObjectOutputStream(file);

            // Method for serialization of object
            out.writeObject(object);

            out.close();
            file.close();

            System.out.println("Object has been serialized");

        } catch (IOException ex) {
            System.out.println("IOException is caught" + ex.fillInStackTrace());
        }


        // Deserialization
        try {
            // Reading the object from a file
            FileInputStream file = new FileInputStream(filename);
            ObjectInputStream in = new ObjectInputStream(file);

            // Method for deserialization of object
            Circle object1 = (Circle) in.readObject();

            in.close();
            file.close();

            System.out.println("Object has been deserialized ");
            System.out.println("a = " + object1.getCenter().getX() + "\t" + object1.getCenter().getY());
            System.out.println("b = " + object1.getRadius());
        } catch (IOException ex) {
            System.out.println("IOException :" + ex.fillInStackTrace());
        } catch (ClassNotFoundException ex) {
            System.out.println(ex.fillInStackTrace());
        }

    }
}