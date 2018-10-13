package designpattern.creational.abstractfactorypattern;

/**
 * @author Abhishek Kumar Sinha
 *
 */
public interface ComputerFactory {
    public Computer getNewComputer(int ram, int rom, int cpuVerison);

    public String toString();
}
