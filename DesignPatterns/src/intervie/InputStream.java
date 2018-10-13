package intervie;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * @author Abhishek Kumar Sinha
 *
 */
public class InputStream {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Student s1 = new Student(211, "ravi", 22);// creating object
        // writing object into file
        FileOutputStream f = new FileOutputStream("D:\\abcd.txt");
        ObjectOutputStream out = new ObjectOutputStream(f);
        out.writeObject(s1);
        out.flush();

        out.close();
        f.close();
        System.out.println("success");
        boolean b = Boolean.parseBoolean("true");

        ObjectInputStream in = new ObjectInputStream(new FileInputStream("D:\\abcd.txt"));
        Student s = (Student) in.readObject();
        System.out.println(s.id + " " + s.name + " " + s.age);
        in.close();
    }
}
