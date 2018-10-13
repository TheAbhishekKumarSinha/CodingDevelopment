package designpattern.structural.composite;

/**
 * @author Abhishek Kumar Sinha
 *
 */
public class Circle implements Shape {

    /*
     * (non-Javadoc)
     * 
     * @see designpattern.behavioral.composite.Shape#draw(java.lang.String)
     */
    @Override
    public void draw(String color) {
        System.out.println("Drawing Circle with color: " + color);

    }

}
