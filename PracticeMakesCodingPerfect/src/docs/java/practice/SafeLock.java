package docs.java.practice;

import java.util.Random;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author Abhishek Kumar Sinha
 *
 */

class Friend implements Runnable {
    String friendName;
    private Lock lock = new ReentrantLock();
    Friend bower;

    /**
     * @param string
     */
    public Friend(String friendName) {
        this.friendName = friendName;
    }

    protected String getFriendName() {
        return friendName;
    }

    protected void setFriendName(String friendName) {
        this.friendName = friendName;
    }

    protected Friend getBowee() {
        return bower;
    }

    protected void setBowee(Friend bower) {
        this.bower = bower;
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Runnable#run()
     */
    @Override
    public void run() {

        Random random = new Random();
        for (int i = 0; i < 20; i++) {
            try {
                Thread.sleep(random.nextInt(10));
            }
            catch (InterruptedException e) {
            }
            this.bow(bower);
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
     * @param bowee2
     */
    private void bow(Friend bower) {
        // TODO Auto-generated method stub

        if (impendingBow(bower)) {
            try {
                System.out.println(this.getFriendName() + " has bowed to " + bower.getFriendName());
                bower.bowBack(this);
            }
            finally {
                this.lock.unlock();
                bower.lock.unlock();
            }
        }
        else {
            System.out.println(this.getFriendName() + " was bowing to " + bower.getFriendName() + "but saw was bowing to him");
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
     * @param friend
     */
    private void bowBack(Friend friend) {

        System.out.println(this.getFriendName() + " has bowed to " + bower.getFriendName());

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
     * @param bowee2
     */
    private boolean impendingBow(Friend bower) {
        boolean myLock = false;
        boolean yourLock = false;
        try {
            myLock = this.lock.tryLock();
            yourLock = bower.lock.tryLock();

        }
        finally {
            if (!(myLock && yourLock)) {
                if (myLock) {
                    this.lock.unlock();
                }
                if (yourLock)
                    bower.lock.unlock();

            }
        }
        return myLock && yourLock;
    }

}

public class SafeLock {

    public static void main(String[] args) {
        final Friend alphonse = new Friend("Alphonse");
        final Friend gaston = new Friend("Gaston");
        alphonse.setBowee(gaston);
        gaston.setBowee(alphonse);
        new Thread(alphonse).start();
        new Thread(gaston).start();
    }

}
