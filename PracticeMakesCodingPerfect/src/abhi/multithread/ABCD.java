package abhi.multithread;

/**
 * @author Abhishek Kumar Sinha
 *
 * 
 */
class A {
    int b;

    A() {
        b = 10;
    }

    public void print() {
        System.out.println("Parent " + b);
    }

}

class B extends A {
    int b;

    B() {
        b = 15;
    }

    public void print() {
        System.out.println("Child  " + b);
    }

    public void run() {
        System.out.println("child run");
    }
}

public class ABCD {
    public static void main(String[] args) {
        A a = new B();
        System.out.println(a.b);
        a.b = 25;
        System.out.println(a.b);
        a.print();
        // a.run();
    }
}
