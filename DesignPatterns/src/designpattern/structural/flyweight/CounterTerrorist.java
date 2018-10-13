package designpattern.structural.flyweight;

/**
 * @author Abhishek Kumar Sinha
 *
 */
public class CounterTerrorist implements Player {

    public static String TASK;

    private String weapon;

    public CounterTerrorist() {
        TASK = "DIFFUSE BOMB";

    }

    @Override
    public String mission() {
        // TODO Auto-generated method stub
        return "Counter Terrorist Player with Weapon: " + this.weapon + " has mission to " + this.TASK;
    }

    /*
     * (non-Javadoc)
     * 
     * @see designpattern.structural.flyweight.Player#assignWeapon()
     */
    @Override
    public void assignWeapon(String weapon) {
        this.weapon = weapon;
    }
}
