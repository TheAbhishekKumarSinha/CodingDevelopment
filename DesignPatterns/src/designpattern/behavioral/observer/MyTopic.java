package designpattern.behavioral.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Abhishek Kumar Sinha
 *
 */
public class MyTopic implements Subject {

    public boolean isChanged;
    public List<Observer> observer;

    public String message;
    public final Object MUTEX = new Object();

    public MyTopic() {
        observer = new ArrayList<Observer>();
    }

    /*
     * (non-Javadoc)
     * 
     * @see designpattern.behavioral.observer.Subject#register(designpattern.behavioral.observer.
     * Observer)
     */
    @Override
    public void register(Observer o) {
        if (o == null) {
            throw new NullPointerException("Observer is null");
        }
        synchronized (MUTEX) {
            observer.add(o);
        }

    }

    /*
     * (non-Javadoc)
     * 
     * @see designpattern.behavioral.observer.Subject#unregister(designpattern.behavioral.observer.
     * Observer)
     */
    @Override
    public void unregister(Observer o) {
        synchronized (MUTEX) {
            observer.remove(o);
        }

    }

    /*
     * (non-Javadoc)
     * 
     * @see designpattern.behavioral.observer.Subject#setUpdate()
     */

    /*
     * (non-Javadoc)
     * 
     * @see designpattern.behavioral.observer.Subject#notifyObserver()
     */
    @Override
    public void notifyObserver() {
        List<Observer> observerLocal = null;
        if (!isChanged)
            return;
        observerLocal = new ArrayList<>(observer);
        for (Observer ob : observerLocal) {
            ob.update();
        }

    }

    /*
     * (non-Javadoc)
     * 
     * @see designpattern.behavioral.observer.Subject#getUpdate(designpattern.behavioral.observer.
     * Observer)
     */
    @Override
    public String getUpdate(Observer topicSubcriber) {
        // TODO Auto-generated method stub
        return this.message;
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
     * @param string
     */
    public void postMessage(String message) {
        System.out.println("Message Posted :" + message);
        this.message = message;
        this.isChanged = true;
        this.notifyObserver();

    }

}
