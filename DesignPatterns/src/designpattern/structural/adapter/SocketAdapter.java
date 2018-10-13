package designpattern.structural.adapter;

/**
 * @author Abhishek Kumar Sinha
 *
 */
public interface SocketAdapter {

    public Volt get3VoltAdapter();

    public Volt get12VoltAdapter();

    public Volt get120VoltAdapter();

}
