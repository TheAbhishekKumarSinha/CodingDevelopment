package designpattern.structural.decorator;

/**
 * @author Abhishek Kumar Sinha
 *
 */
public class SportsCar extends CarDecorator {

    /**
     * 
     */
    public SportsCar(Car c) {
        super(c);
        // TODO Auto-generated constructor stub
    }

    @Override
    public void assemble() {
        super.assemble();
        System.out.println(" Adding features of Sports Car.");
    }

}
