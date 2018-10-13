package code.java.practice.javaexamples;

/**
 * @author Abhishek Kumar Sinha
 *
 */
public interface InterfaceInJava {
    public int fun() throws ClassNotFoundException;

}

interface InterfaceB {
    public int fun() throws Exception;
}

abstract class abc {
    int d = 0;

    abc(int d) {
        this.d = d;
    }

    abc() {

    }

    public abstract int fun() throws ClassNotFoundException;

}

class MainClass extends abc implements InterfaceInJava, InterfaceB {

    public String getStuff() {
        return "one";
    }

    /*
     * (non-Javadoc)
     * 
     * @see code.java.practice.javaexamples.InterfaceB#fun()
     */

    @Override
    public int fun() throws ClassNotFoundException {
        // TODO Auto-generated method stub
        return 0;
    }

    public static void main(String[] args) {
        InterfaceB B = new MainClass();
        InterfaceInJava inter = new MainClass();
        /*
         * Hashtable<String, String=""> a = new Hashtable<String, String>(); a.put("c", "d");
         * a.put(10, "d"); a.put("d", 10.22);
         */
        final int x;
        x = 20;
        System.out.println(x);
        try {
            B.fun();
            inter.fun();
        }
        catch (Exception exception) {
            // TODO Auto-generated catch block
            exception.printStackTrace();
        }

    }
}
