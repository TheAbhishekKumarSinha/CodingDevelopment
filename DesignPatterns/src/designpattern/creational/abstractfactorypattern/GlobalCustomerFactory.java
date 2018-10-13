package designpattern.creational.abstractfactorypattern;

/**
 * @author Abhishek Kumar Sinha
 *
 */

public class GlobalCustomerFactory {

    /**
     * Method Description:
     *
     * Conditions handled:
     *
     * 1.
     *
     * 2.
     */
    public static ComputerFactory getnewComputer(int ram, int rom, int cpuVersion, String Type) {
        ComputerFactory comFactory = null;
        if (COMPUTERTYPE.valueOf(Type) == COMPUTERTYPE.SERVER) {
            comFactory = new ServerFactory();
            comFactory.getNewComputer(ram, rom, cpuVersion);
        }
        else {
            comFactory = new PCComputerFactory();
            comFactory.getNewComputer(ram, rom, cpuVersion);
        }
        return comFactory;
    }

}
