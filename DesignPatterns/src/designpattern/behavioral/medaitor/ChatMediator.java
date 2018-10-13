package designpattern.behavioral.medaitor;

/**
 * @author Abhishek Kumar Sinha
 *
 */
public interface ChatMediator {

    public void sendMessage(String msg, User user);

    void addUser(User user);
}
