package abhi.multithread;

import java.util.ArrayList;
import java.util.TreeSet;

public class IDPattern {
    private static TreeSet<Integer> output = null;

    public static void main(String[] args) {
        String s = "IDDDI";

        output = new TreeSet();

        ArrayList<Integer> numbers = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {

            int counter = i + 1;
            int number = 0;
            if (counter <= s.length() - 1 && s.charAt(counter) == 'D' && (counter - 1) >= 0 && s.charAt(counter - 1) == 'I') {
                number = output.size() > 0 ? output.last() + 1 : 2;
                while (counter <= s.length() - 1 && s.charAt(counter) != 'I') {
                    number++;
                    counter++;
                }
                // number++;
            }
            else if (counter <= s.length() - 1 && s.charAt(counter) == 'D' && (counter - 1) == 0 && s.charAt(counter - 1) == 'D') {
                number = output.size() > 0 ? output.last() + 1 : 2;
                while (counter <= s.length() - 1 && s.charAt(counter) != 'I') {
                    number++;
                    counter++;
                }
            }
            else if (s.charAt(i) == 'I') {
                number = output.size() > 0 ? output.last() : 1;
                number++;
            }

            else if (s.charAt(i) == 'D') {
                number = output.size() > 0 ? output.last() : 2;
                while (output.contains(number)) {
                    number--;
                }
            }

            else {
                System.out.println("Invalid Input");
                return;
            }
            if (i == 0 && s.charAt(i) == 'I') {
                numbers.add(number - 1);
                numbers.add(number);
                output.add(number - 1);
                output.add(number);
            }
            else if (i == 0 && s.charAt(i) == 'D') {
                numbers.add(number);
                numbers.add(number - 1);
                output.add(number);
                output.add(number - 1);
            }
            else {
                numbers.add(number);
                output.add(number);
            }
        }

        for (Integer i : numbers) {
            System.out.print(i);
        }
    }

}
