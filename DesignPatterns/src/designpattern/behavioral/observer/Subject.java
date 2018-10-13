package designpattern.behavioral.observer;

/**
 * @author Abhishek Kumar Sinha
 *
 */
public interface Subject {

    public void register(Observer o);

    public void unregister(Observer o);

    public void notifyObserver();

    /**
     * Method Description:
     *
     * Conditions handled:
     *
     * 1.
     *
     * 2.
     * 
     * @param topicSubcriber
     * @return
     */
    public String getUpdate(Observer topicSubcriber);

}
