package designpattern.structural.adapter;

/**
 * @author Abhishek Kumar Sinha
 *
 */
public class Volt {
    private int volts;

    public int getVolts() {
        return volts;
    }

    public void setVolts(int volts) {
        this.volts = volts;
    }

    /**
     * @param volts
     */
    public Volt(int volts) {
        super();
        this.volts = volts;
    }

}
