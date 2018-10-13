package designpattern.structural.composite;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Abhishek Kumar Sinha
 *
 */
public class Drawing implements Shape {

    /*
     * (non-Javadoc)
     * 
     * @see designpattern.behavioral.composite.Shape#draw(java.lang.String)
     */
    @Override
    public void draw(String color) {
        for (Shape s : shape) {
            s.draw(color);
        }

    }

    List<Shape> shape = new ArrayList<>();

    public void add(Shape s) {
        shape.add(s);
    }

    public void remove(Shape s) {
        shape.remove(s);
    }

    public void clear() {
        System.out.println("Clearing all drawings");
        shape.clear();
    }
}
