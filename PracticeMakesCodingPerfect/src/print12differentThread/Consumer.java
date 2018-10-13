package print12differentThread;

/**
 * @author Abhishek Kumar Sinha
 *
 */
public class Consumer implements Runnable {

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Runnable#run()
     * 
     * Consumer
     */

    PrintEvenOdd print = null;

    Consumer(PrintEvenOdd print) {

        this.print = print;

    }

    @Override
    public void run() {

        int increment = 2;
        while (true) {

            if (increment >= 102) {
                break;
            }
            try {
                increment = print.print(increment, "EVEN");
                System.out.println("Printed Value Consumer:" + increment);
            }
            catch (InterruptedException exception) {
                // TODO Auto-generated catch block
                exception.printStackTrace();
            }

        }

    }

}
