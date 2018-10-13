package designpattern.structural.flyweight;

import java.util.HashMap;

/**
 * @author Abhishek Kumar Sinha
 *
 */
public class PlayerFactory {

    String playerType[] = { "Terrorist", "CounterTerrorist" };

    String weaponType[] = { "AK-47", "Maverick", "Gut Knife", "Desert Eagle" };

    private static HashMap<String, Player> hm = new HashMap<>();

    public static Player getPlayers(String type) {
        Player p = null;

        if (hm.containsKey(type))
            return p = hm.get(type);
        else {
            if (type.equals("CounterTerrorist")) {
                p = new CounterTerrorist();
            }
            else {
                p = new Terrorist();
            }

            hm.put(type, p);
        }
        return p;

    }
}
