package designpattern.structural.composite;

/**
 * @author Abhishek Kumar Sinha
 *
 */
public class CompositePatternTest {
    public static void main(String[] args) {
        Shape t = new Triangle();
        Shape c = new Circle();
        Shape r = new Rectangle();

        Drawing d = new Drawing();
        d.add(t);
        d.add(c);
        d.add(r);

        d.draw("Red");

        d.clear();

        d.add(t);
        d.add(c);
        d.add(r);

        d.draw("blue");

    }
}
