package designpattern.creational.abstractfactorypattern;

/**
 * @author Abhishek Kumar Sinha
 *
 */
public class Customer {
    public static void main(String[] args) {

        ComputerFactory compFactory = GlobalCustomerFactory.getnewComputer(1, 12, 15, "COMPUTER");
        System.out.println(compFactory.toString());
        compFactory = GlobalCustomerFactory.getnewComputer(1, 12, 15, "SERVER");
        System.out.println(compFactory.toString());

    }
}
