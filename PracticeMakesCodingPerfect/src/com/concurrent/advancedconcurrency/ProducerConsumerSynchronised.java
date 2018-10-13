package com.concurrent.advancedconcurrency;

/**
 * @author Abhishek Kumar Sinha
 *
 */
public class ProducerConsumerSynchronised {

    private static Integer count = 0;
    private int counter = 10;
    private final Object monitor = new Object();

    class Producer implements Runnable {

        /*
         * (non-Javadoc)
         * 
         * @see java.lang.Runnable#run()
         */
        @Override
        public void run() {

            synchronized (monitor) {
                while (counter > 0) {
                    try {
                        while (count > 0)
                            monitor.wait();
                        if (counter > 0) {
                            count++;
                            System.out.println("Producer Produced:" + counter);
                            monitor.notify();
                            Thread.sleep(1000);

                        }

                    }
                    catch (InterruptedException exception) {
                        // TODO Auto-generated catch block
                        exception.printStackTrace();
                    }

                }

            }
        }
    }

    class Consumer implements Runnable {

        @Override
        public void run() {

            synchronized (monitor) {
                while (counter > 0) {
                    try {
                        while (count <= 0)
                            monitor.wait();

                        System.out.println("Consumer Consumed: " + counter);
                        counter--;
                        count--;
                        monitor.notify();
                        Thread.sleep(1000);

                    }
                    catch (InterruptedException exception) {
                        // TODO Auto-generated catch block
                        exception.printStackTrace();
                    }
                }

            }

        }

    }

    public static void main(String args[]) {
        ProducerConsumerSynchronised producerConsumerSync = new ProducerConsumerSynchronised();
        Consumer consumer = producerConsumerSync.new Consumer();
        Producer producer = producerConsumerSync.new Producer();
        Thread t1 = new Thread(producer);
        Thread t2 = new Thread(consumer);
        t1.start();
        t2.start();
        try {
            t1.join();
            t2.join();
        }
        catch (InterruptedException exception) {
            // TODO Auto-generated catch block
            exception.printStackTrace();
        }

    }

}
