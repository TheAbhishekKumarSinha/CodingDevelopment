package designpattern.behavioral.memento;

/**
 * @author Abhishek Kumar Sinha
 *
 */
public class FileWriterCareTaker {
    private Object obj;

    public void save(MementoHelperUtil util) {
        this.obj = util.save();
    }

    public void undo(MementoHelperUtil util) {
        util.undo(obj);
    }
}
