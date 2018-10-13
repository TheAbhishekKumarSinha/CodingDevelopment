package intervie;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class Stats {

    static class Tick {
        private int count = 0;
        private double price = 0;

        public synchronized int getCount() {
            return count;
        }

        public synchronized void setCount(int count) {
            this.count = count;
        }

        public synchronized double getPrice() {
            return price;
        }

        public synchronized void setPrice(double price) {
            this.price = price;
        }

        /**
         * @param count
         * @param price
         */
        public Tick(int count, double price) {
            this.count = count;
            this.price = price;
        }

        public synchronized double average() {
            return this.price / this.count;
        }

    }

    public static class Readwrite {
        private Map<String, Tick> map = new HashMap<>();

        private ReadWriteLock readWriteLock = new ReentrantReadWriteLock();

        Lock readLock = readWriteLock.readLock();
        Lock writeLock = readWriteLock.writeLock();

        public void putNewPrice(String symbol, double price) {
            writeLock.lock();
            Tick tick = null;
            if (map.containsKey(symbol)) {
                tick = map.get(symbol);
                tick.setCount(tick.getCount() + 1);
                tick.setPrice(tick.getPrice() + price);
            }
            else {
                tick = new Tick(1, price);
            }
            map.put(symbol, tick);
            writeLock.unlock();
        }

        public double getAveragePrice(String symbol) {
            readLock.lock();

            double d = map.get(symbol).average();

            readLock.unlock();

            return d;
        }

        public int getTickCount(String symbol) {
            readLock.lock();

            int d = map.get(symbol).getCount();

            readLock.unlock();

            return d;
        }

    }
}