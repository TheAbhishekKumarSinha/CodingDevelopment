package com.concurrent.advancedconcurrency;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author Abhishek Kumar Sinha
 *
 */
public class ProducerConsumer {

    Lock lock = new ReentrantLock();
    Condition isEmpty = lock.newCondition();
    Condition isFull = lock.newCondition();

    List<Integer> buffer = new ArrayList<Integer>();

    class Producer implements Callable<String> {

        /*
         * (non-Javadoc)
         * 
         * @see java.util.concurrent.Callable#call()
         */
        @Override
        public String call() throws Exception {
            // TODO Auto-generated method stub

            int count = 0;
            while (count++ < 50) {
                try {
                    lock.lock();
                    while (isFull(buffer)) {
                        isFull.await();
                    }
                    buffer.add(1);
                    isEmpty.signalAll();
                }
                finally {
                    lock.unlock();
                }
            }
            return "Produced";
        }
    }

    /**
     * Method Description:
     *
     * Conditions handled:
     *
     * 1.
     *
     * 2.
     * 
     * @param buffer
     * @return
     */
    private boolean isFull(List<Integer> buffer) {
        // TODO Auto-generated method stub
        return buffer.size() >= 5 ? true : false;
    }

    /**
     * Method Description:
     *
     * Conditions handled:
     *
     * 1.
     *
     * 2.
     * 
     * @param buffer
     * @return
     */
    private boolean isEmpty(List<Integer> buffer) {
        return buffer.size() == 0 ? true : false;
    }

    class Consumer implements Callable<String> {

        /*
         * (non-Javadoc)
         * 
         * @see java.util.concurrent.Callable#call()
         */
        @Override
        public String call() throws Exception {
            // TODO Auto-generated method stub
            int count = 0;
            while (count++ < 50) {
                try {
                    lock.lock();
                    while (isEmpty(buffer)) {
                        isEmpty.await();
                    }
                    buffer.remove(buffer.size() - 1);
                    isFull.signalAll();
                }
                finally {
                    lock.unlock();
                }

            }
            return "Consumed";
        }

    }

    public static void main(String[] args) {
        List<Callable<String>> producerConsumerCallables = new ArrayList<Callable<String>>();
        ProducerConsumer producerConsumer = new ProducerConsumer();
        List<Producer> producers = new ArrayList<>();
        List<Consumer> consumers = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            Producer producer = producerConsumer.new Producer();
            Consumer consumer = producerConsumer.new Consumer();

            producers.add(producer);
            consumers.add(consumer);
        }

        producerConsumerCallables.addAll(producers);
        producerConsumerCallables.addAll(consumers);

        ExecutorService executorService = Executors.newFixedThreadPool(8);

        try {
            List<Future<String>> futures = executorService.invokeAll(producerConsumerCallables);
            futures.forEach(future -> {
                try {
                    System.out.println(future.get());
                }
                catch (InterruptedException exception) {
                    // TODO Auto-generated catch block
                    exception.printStackTrace();
                }
                catch (ExecutionException exception) {
                    // TODO Auto-generated catch block
                    exception.printStackTrace();
                }
            });
        }
        catch (InterruptedException exception) {
            // TODO Auto-generated catch block
            exception.printStackTrace();
        }
        finally {
            executorService.shutdown();
        }

    }
}
