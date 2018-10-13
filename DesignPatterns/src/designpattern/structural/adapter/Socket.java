package designpattern.structural.adapter;

/**
 * @author Abhishek Kumar Sinha
 *
 */
public class Socket {
    public Volt getVolt() {
        return new Volt(120);
    }
}
