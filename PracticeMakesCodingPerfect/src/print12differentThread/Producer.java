package print12differentThread;

import java.util.List;

/**
 * @author Abhishek Kumar Sinha
 *
 */
public class Producer implements Runnable {

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Runnable#run()
     */

    List<String> arr = null;

    PrintEvenOdd print = null;

    Producer(PrintEvenOdd print) {

        this.print = print;

    }

    @Override
    public void run() {

        int increment = 1;
        while (true) {
            if (increment >= 101)
                break;
            try {
                increment = print.print(increment, "ODD");
                System.out.println("Printed Value Producer:" + increment);
            }
            catch (InterruptedException exception) {
                // TODO Auto-generated catch block
                exception.printStackTrace();
            }

        }
    }

}
