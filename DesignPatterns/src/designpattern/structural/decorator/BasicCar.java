package designpattern.structural.decorator;

/**
 * @author Abhishek Kumar Sinha
 *
 */
public class BasicCar implements Car {

    public BasicCar() {

    }

    /*
     * (non-Javadoc)
     * 
     * @see designpattern.structural.decorator.Car#assemble()
     */
    @Override
    public void assemble() {
        System.out.println("Basic Car Created");

    }

}
