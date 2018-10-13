package designpattern.structural.flyweight;

/**
 * @author Abhishek Kumar Sinha
 *
 */
public class Terrorist implements Player {

    private static String TASK;

    private String weapon;

    public Terrorist() {
        TASK = "PLANT A BOMB";

    }

    /*
     * (non-Javadoc)
     * 
     * @see designpattern.structural.flyweight.Player#mission()
     */
    @Override
    public String mission() {
        // TODO Auto-generated method stub
        return "Terrorist Player with Weapon: " + this.weapon + " has mission to " + TASK;
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
