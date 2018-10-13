package designpattern.behavioral.observer;

/**
 * @author Abhishek Kumar Sinha
 *
 */
public interface Observer {

    public void update();

    public void setSubject(Subject s);
}
