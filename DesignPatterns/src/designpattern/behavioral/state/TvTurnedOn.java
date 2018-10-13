package designpattern.behavioral.state;

/**
 * @author Abhishek Kumar Sinha
 *
 */
public class TvTurnedOn implements State {

    /*
     * (non-Javadoc)
     * 
     * @see designpattern.behavioral.state.State#doAction()
     */
    @Override
    public void doAction() {
        System.out.println("TV is turned On");

    }

}
