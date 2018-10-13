package designpattern.structural.adapter;

/**
 * @author Abhishek Kumar Sinha
 *
 */
public class SocketObjectImpl implements SocketAdapter {

    Socket socket = new Socket();

    /*
     * (non-Javadoc)
     * 
     * @see designpattern.behavioral.adapter.SocketAdapter#get3VoltAdapter()
     */
    @Override
    public Volt get3VoltAdapter() {
        Volt volt = socket.getVolt();
        volt.setVolts(convertToVolt(volt, 3));
        return volt;
    }

    /*
     * (non-Javadoc)
     * 
     * @see designpattern.behavioral.adapter.SocketAdapter#get12VoltAdapter()
     */
    @Override
    public Volt get12VoltAdapter() {
        // TODO Auto-generated method stub
        Volt volt = socket.getVolt();
        volt.setVolts(convertToVolt(volt, 12));
        return volt;
    }

    /**
     * Method Description:
     *
     * Conditions handled:
     *
     * 1.
     *
     * 2.
     * 
     * @param volt
     * @param i
     * @return
     */
    private int convertToVolt(Volt volt, int i) {
        int divisor = volt.getVolts() / i;
        return volt.getVolts() / divisor;
    }

    /*
     * (non-Javadoc)
     * 
     * @see designpattern.behavioral.adapter.SocketAdapter#get120VoltAdapter()
     */
    @Override
    public Volt get120VoltAdapter() {
        Volt volt = socket.getVolt();
        volt.setVolts(convertToVolt(volt, 120));
        return volt;
    }

}
