package designpattern.creational.abstractfactorypattern;

/**
 * @author Abhishek Kumar Sinha
 *
 */
public class PCComputerFactory implements ComputerFactory {

    Computer pc = null;

    /*
     * (non-Javadoc)
     * 
     * @see designpattern.abstractfactorypattern.ComputerFactory#getNewComputer(int, int, int)
     */
    @Override
    public Computer getNewComputer(int ram, int rom, int cpuVersion) {
        pc = new PC(ram, cpuVersion, rom);
        return pc;
    }

    @Override
    public String toString() {
        return pc.toString();
    }
}
