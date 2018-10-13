package print12differentThread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author Abhishek Kumar Sinha
 *
 */
public class PrintEvenOdd {

    /**
     * 
     */

    Lock lock = new ReentrantLock();

    private Condition evenTurn = lock.newCondition();
    private Condition oddTurn = lock.newCondition();

    public PrintEvenOdd() {
    }

    boolean isOddPrinted = false;
    boolean isEvenPrinted = true;

    public int print(int number, String evenOrOdd) throws InterruptedException {
        lock.lock();
        if (evenOrOdd.equals("EVEN")) {
            if (isOddPrinted) {
                Thread.sleep(200);
                System.out.println(number);
                isOddPrinted = false;
                isEvenPrinted = true;
                number = number + 2;
                if (number <= 100)
                    evenTurn.signal();
                lock.unlock();

            }
            else {
                if (number <= 100)
                    oddTurn.await();

            }
        }
        else {
            if (isEvenPrinted) {
                Thread.sleep(100);
                System.out.println(number);
                isOddPrinted = true;
                isEvenPrinted = false;
                number = number + 2;
                if (number <= 100)
                    oddTurn.signal();
                lock.unlock();

            }
            else {
                if (number <= 100)
                    evenTurn.await();

            }
        }
        return number;
    }

}
