package code.amdocs.solution;

import java.util.TreeSet;

/**
 * @author Abhishek Kumar Sinha
 *
 */
public class ThreadTest {
    public static void main(String[] args) {
        Thread b = new big(new small());
        b.start();

        TreeSet t1 = new TreeSet<>();

        TreeSet t2 = new TreeSet<>();
        for (int i = 604; i < 649; i++) {
            if (i % 2 == 0) {
                t1.add(i);
            }
        }
        t2 = (TreeSet) t1.subSet(606, 613);
        // t2.add(e)
    }

}

class big extends Thread {
    /**
     * 
     */
    public big(Runnable ren) {
        // TODO Auto-generated constructor stub
        super(ren);
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Thread#run()
     */
    @Override
    public void run() {
        // TODO Auto-generated method stub
        System.out.println("Big");
    }
}

class small extends Thread {
    /**
     * 
     */
    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Thread#run()
     */
    @Override
    public void run() {
        // TODO Auto-generated method stub
        System.out.println("small");
    }
}