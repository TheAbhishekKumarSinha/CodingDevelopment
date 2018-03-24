package code.java.practice.javaexamples;

/**
 * @author Abhishek Kumar Sinha
 *
 */
public class InheritanceClass {
    public static void main(String[] args) {
        CallParentChildClass();
        CallExceptionInInterfce();
    }

    /**
     * Method Description:
     *
     * Conditions handled:
     *
     * 1.
     *
     * 2.
     */
    private static void CallExceptionInInterfce() {
        ExceptionInInterfaces exce = new ExceptionInInterface();
        exce.functionsss();

    }

    /**
     * Method Description:
     *
     * Conditions handled:
     *
     * 1.
     *
     * 2.
     */
    private static void CallParentChildClass() {
        ParentClass p = new ChildClass();
        ChildClass c = new ChildClass();

        ParentClass pnull = null;

        System.out.println(p.a);
        System.out.println(p.b);
        try {
            System.out.println(p.move());
        }
        catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        // p.parentWatche(); run time exception as child method cannot be referred by reference of
        // parents
        p.parentWatch();
        p.LetsPlay();
        pnull.LetsPlay();

    }
}
