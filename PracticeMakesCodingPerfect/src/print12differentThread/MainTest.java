package print12differentThread;

/**
 * @author Abhishek Kumar Sinha
 *
 */
public class MainTest {

    public static void main(String[] args) throws InterruptedException {

        PrintEvenOdd print = new PrintEvenOdd();
        Producer cons = new Producer(print);
        Consumer prod = new Consumer(print);

        Thread threadProducer = new Thread(prod);
        Thread threadConsumer = new Thread(cons);
        threadProducer.start();

        threadConsumer.start();

    }
}
