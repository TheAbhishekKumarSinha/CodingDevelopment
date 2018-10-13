package abhi.multithread.deadlock;

/**
 * @author Abhishek Kumar Sinha
 *
 */

enum Color {
    Red, blue, green;
}

public class SwitchEnum {
    public static void main(String[] args) {
        for (Color c : Color.values()) {
            getThoughtoftheday(c);
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
     * @param c
     */
    private static void getThoughtoftheday(Color c) {
        switch (c) {
            case Red:
                System.out.println("Red Colour");
                break;
            case blue:
                System.out.println("Blue Colour");
                break;
            case green:
                System.out.println("Green Colour");
                break;
        }

    }

}
