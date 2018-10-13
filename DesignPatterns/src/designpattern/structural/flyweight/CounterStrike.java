package designpattern.structural.flyweight;

import java.util.Random;

/**
 * @author Abhishek Kumar Sinha
 *
 */
public class CounterStrike {

    private static final String playerType[] = { "Terrorist", "CounterTerrorist" };

    private static final String weaponType[] = { "AK-47", "Maverick", "Gut Knife", "Desert Eagle" };

    public static void main(String[] args) {

        for (int i = 0; i < 10; i++) {
            Player p = null;
            p = PlayerFactory.getPlayers(getRandomPlayerType());
            System.out.println(p.hashCode());
            p.assignWeapon(getRandomWeapon());
            System.out.println(p.mission());
        }
    }

    /**
     * Method Description:
     *
     * Conditions handled:
     *
     * 1.
     *
     * 2.
     * 
     * @return
     */
    private static String getRandomWeapon() {
        Random rand = new Random();
        return weaponType[rand.nextInt(weaponType.length)];
    }

    /**
     * Method Description:
     *
     * Conditions handled:
     *
     * 1.
     *
     * 2.
     * 
     * @return
     */
    private static String getRandomPlayerType() {
        Random rand = new Random();
        return playerType[rand.nextInt(playerType.length)];

    }

}
