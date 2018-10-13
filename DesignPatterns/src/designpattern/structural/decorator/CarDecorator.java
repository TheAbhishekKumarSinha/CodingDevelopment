package designpattern.structural.decorator;

/**
 * @author Abhishek Kumar Sinha
 *
 */
public class CarDecorator implements Car {

    /*
     * (non-Javadoc)
     * 
     * @see designpattern.structural.decorator.Car#assemble()
     */

    protected Car car;

    /**
     * @param car
     */
    public CarDecorator(Car car) {
        super();
        this.car = car;
    }

    @Override
    public void assemble() {
        this.car.assemble();

    }

}
