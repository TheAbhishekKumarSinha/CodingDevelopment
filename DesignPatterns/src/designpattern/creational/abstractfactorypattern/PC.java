package designpattern.creational.abstractfactorypattern;

/**
 * @author Abhishek Kumar Sinha
 *
 */
public class PC implements Computer {

    int ram;
    int cpuVersion;
    int rom;

    boolean isGraphicsCardEnabled;
    boolean isExtendableRam;

    public boolean isExtendableRam() {
        return isExtendableRam;
    }

    public void setExtendableRam(boolean isExtendableRam) {
        this.isExtendableRam = isExtendableRam;
    }

    public boolean isGraphicsCardEnabled() {
        return isGraphicsCardEnabled;
    }

    public void setGraphicsCardEnabled(boolean isGraphicsCardEnabled) {
        this.isGraphicsCardEnabled = isGraphicsCardEnabled;
    }

    /**
     * @param ram
     * @param cpuVersion
     * @param rom
     */
    public PC(int ram, int cpuVersion, int rom) {
        super();
        this.ram = ram;
        this.cpuVersion = cpuVersion;
        this.rom = rom;
    }

    /*
     * (non-Javadoc)
     * 
     * @see designpattern.factorypattern.Computer#getRam()
     */
    @Override
    public int getRam() {
        // TODO Auto-generated method stub
        return ram;
    }

    /*
     * (non-Javadoc)
     * 
     * @see designpattern.factorypattern.Computer#setRam(int)
     */
    @Override
    public void setRam(int ram) {
        this.ram = ram;

    }

    /*
     * (non-Javadoc)
     * 
     * @see designpattern.factorypattern.Computer#getCpuVersion()
     */
    @Override
    public int getCpuVersion() {
        // TODO Auto-generated method stub
        return cpuVersion;
    }

    /*
     * (non-Javadoc)
     * 
     * @see designpattern.factorypattern.Computer#setCpuVersion(int)
     */
    @Override
    public void setCpuVersion(int cpuVersion) {
        this.cpuVersion = cpuVersion;

    }

    /*
     * (non-Javadoc)
     * 
     * @see designpattern.factorypattern.Computer#getRom()
     */
    @Override
    public int getRom() {
        // TODO Auto-generated method stub
        return rom;
    }

    /*
     * (non-Javadoc)
     * 
     * @see designpattern.factorypattern.Computer#setRom(int)
     */
    @Override
    public void setRom(int rom) {
        this.rom = rom;

    }

    @Override
    public String toString() {
        return "Computer Specifications: PC with" + this.ram + this.cpuVersion + this.rom;
    }

    class innerclass extends Computer.ComputerBuilder {

    }

}
