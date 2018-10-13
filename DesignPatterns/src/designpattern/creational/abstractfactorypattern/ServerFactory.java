package designpattern.creational.abstractfactorypattern;

/**
 * @author Abhishek Kumar Sinha
 *
 */
public class ServerFactory implements ComputerFactory {

    Computer server = null;

    /*
     * (non-Javadoc)
     * 
     * @see designpattern.abstractfactorypattern.ComputerFactory#getNewComputer(int, int, int)
     */
    @Override
    public Computer getNewComputer(int ram, int rom, int cpuVersion) {
        // TODO Auto-generated method stub
        return server = new Server(ram, cpuVersion, rom);

    }

    @Override
    public String toString() {
        return server.toString();
    }
}
