package code.java.practice.javaexamples;

/**
 * @author abhsinha
 *
 */
interface ExceptionInInterfaces {

    public static void function() {
        int a = 0;
        System.out.println(a);
    }

    /**
     * Method Description:
     */
    public void functionsss();

}

public class ExceptionInInterface implements ExceptionInInterfaces {
    public static void main() {

    }

    /*
     * (non-Javadoc)
     * 
     * @see code.java.practice.javaexamples.ExceptionInInterfaces#functions()
     */
    @Override
    public void functionsss() throws RuntimeException {
        throw new RuntimeException();

    }
}
