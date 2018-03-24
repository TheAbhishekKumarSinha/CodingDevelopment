package code.java.practice.javaexamples;

/**
 * @author Abhishek Kumar Sinha
 *
 */
interface ExceptionInInterfaces {

    public static void Functions() {
        int a = 0;
        System.out.println(a);
    }

    /**
     * Method Description:
     */
    public void functionsss() throws RuntimeException;

}

public class ExceptionInInterface implements ExceptionInInterfaces {
    public static void main() {

    }

    /*
     * (non-Javadoc)
     * 
     * @see code.java.practice.javaexamples.ExceptionInInterfaces#functions()
     */

    // public void functionsss() throws IOException { Compile Time exception
    // if the exception is not
    // declared in parent
    // class then child class can only declare unchecked exception

    // public void functionsss() throws Exception { Compile Time exception
    // if the runtime exception is
    // declared in parent
    // class then child class can only declare child exception or same exception or no exception

    @Override
    public void functionsss() throws ArrayIndexOutOfBoundsException {
        throw new RuntimeException();
    }

}
