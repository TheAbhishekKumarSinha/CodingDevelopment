package designpattern.behavioral.state;

/**
 * @author Abhishek Kumar Sinha
 *
 */
public class TVRemote {
    public static void main(String[] args) {
        State tvSwitchOn = new TvTurnedOn();

        TvContext context = new TvContext(tvSwitchOn);
        context.doAction();

        State tvSwitchOff = new TvTurnOff();
        context = new TvContext(tvSwitchOff);
        context.doAction();

    }
}
