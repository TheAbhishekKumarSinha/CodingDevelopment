package designpattern.behavioral.state;

/**
 * @author Abhishek Kumar Sinha
 *
 */
public class TvContext implements State {
    State state = null;

    /**
     * @param state
     */
    public TvContext(State state) {
        super();
        this.state = state;
    }

    @Override
    public void doAction() {
        this.state.doAction();
    }

}
