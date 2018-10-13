package com.concurrent.advancedconcurrency;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author Abhishek Kumar Sinha
 *
 */
class RWMapDemo {

    private static Map<Integer, String> readWriteMap = new HashMap<Integer, String>();

    private static ReadWriteLock readWriteLock = new ReentrantReadWriteLock(true);
    private static Lock readLock = readWriteLock.readLock();
    private static Lock writeLock = readWriteLock.writeLock();

    public static void put(Integer key, String value) {
        try {
            try {
                Thread.currentThread().sleep(1000);
            }
            catch (InterruptedException exception) {
                // TODO Auto-generated catch block
                exception.printStackTrace();
            }
            System.out.println("Inside Put" + get(1));
            writeLock.lock();
            readWriteMap.put(key, value);
        }
        finally {
            writeLock.unlock();

        }
    }

    public static String get(Integer key) {
        try {
            readLock.lock();
            return readWriteMap.get(key);
        }
        finally {
            readLock.unlock();
        }

    }

    public static int getSize() {
        try {
            readLock.lock();
            return readWriteMap.size();
        }
        finally {
            readLock.unlock();
        }

    }

}

class ReadHashMap implements Runnable {
    Random rand = new Random();
    RWMapDemo rwDemo = null;

    ReadHashMap(RWMapDemo rwDemo) {
        this.rwDemo = rwDemo;
    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.currentThread().sleep(1000);
            }
            catch (InterruptedException exception) {
                // TODO Auto-generated catch block
                exception.printStackTrace();
            }
            String value = rwDemo.get(1);
            System.out.println(Thread.currentThread() + "Read Value" + value);
        }

    }

}

class WriteHashMap implements Runnable {
    Random rand = new Random();
    RWMapDemo rwDemo = null;

    WriteHashMap(RWMapDemo rwDemo) {
        this.rwDemo = rwDemo;
    }

    @Override
    public void run() {
        while (true) {
            System.out.println(Thread.currentThread().getName() + "adding " + "Abhishek:" + Thread.currentThread().getName());
            rwDemo.put(1, "Abhishek:" + Thread.currentThread().getName());
            try {
                Thread.currentThread().sleep(200);
            }
            catch (InterruptedException exception) {
                // TODO Auto-generated catch block
                exception.printStackTrace();
            }

        }

    }

}

public class ReadWriteLockDemo {
    public static void main(String[] args) {
        RWMapDemo rwDemo = new RWMapDemo();
        ExecutorService executor = Executors.newFixedThreadPool(10);
        for (int i = 0; i < 2; i++)
            executor.submit(new WriteHashMap(rwDemo));

        try {
            Thread.currentThread().sleep(2000);
        }
        catch (InterruptedException exception) {
            // TODO Auto-generated catch block
            exception.printStackTrace();
        }
        for (int i = 0; i < 4; i++)
            executor.submit(new ReadHashMap(rwDemo));
    }

}
