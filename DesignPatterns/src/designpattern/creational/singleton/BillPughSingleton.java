package designpattern.creational.singleton;

/**
 * @author Abhishek Kumar Sinha
 *
 */
public class BillPughSingleton {

    private BillPughSingleton() {

    }

    private static class SingletonHelper {

        private static final BillPughSingleton INSTANCE = new BillPughSingleton();
    }

    public static BillPughSingleton getInstance() {
        return SingletonHelper.INSTANCE;
    }
}
