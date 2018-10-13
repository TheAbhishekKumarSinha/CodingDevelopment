package designpattern.behavioral.observer;

/**
 * @author Abhishek Kumar Sinha
 *
 */
public class ObserverPatternTest {

    public static void main(String[] args) {
        // create subject
        MyTopic topic = new MyTopic();

        Observer observer1 = new TopicSubcriber("Observer 1");
        Observer observer2 = new TopicSubcriber("Observer 2");
        Observer observer3 = new TopicSubcriber("Observer 3");

        topic.register(observer1);
        topic.register(observer2);
        topic.register(observer3);

        observer1.setSubject(topic);
        observer2.setSubject(topic);
        observer3.setSubject(topic);

        observer1.update();
        observer2.update();
        observer3.update();

        topic.postMessage("Messages: I Resigned");
    }

}
