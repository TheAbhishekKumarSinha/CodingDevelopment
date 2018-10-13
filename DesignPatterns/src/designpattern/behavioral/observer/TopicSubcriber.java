package designpattern.behavioral.observer;

/**
 * @author Abhishek Kumar Sinha
 *
 */
public class TopicSubcriber implements Observer {

    private Subject s;
    private String name;

    public TopicSubcriber(String nm) {
        this.name = nm;
    }

    /*
     * (non-Javadoc)
     * 
     * @see designpattern.behavioral.observer.Observer#update()
     */
    @Override
    public void update() {
        String message = s.getUpdate(this);
        if (message == null) {
            System.out.println("No Message Consumed");
        }
        else {
            System.out.println(name + ":: Consuming message::" + message);
        }
    }

    @Override
    public void setSubject(designpattern.behavioral.observer.Subject s) {
        this.s = s;

    }

}
