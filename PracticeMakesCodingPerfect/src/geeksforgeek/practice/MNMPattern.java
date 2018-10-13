package geeksforgeek.practice;

import java.util.ArrayList;
import java.util.TreeSet;

public class MNMPattern {
    private static TreeSet<Integer> output = null;

    public static void main(String[] args) {
        String s = "IDID";

        output = new TreeSet();

        ArrayList<Integer> numbers = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {

            int counter = i + 1;
            int number = 0;
            if (s.charAt(counter) == 'D' && (counter - 1) > 0 && s.charAt(counter - 1) == 'I') {
                number = output.size() > 0 ? output.last() + 2 : 2;
                while (s.charAt(counter) != 'I') {
                    number++;
                    counter++;
                }
                number++;
            }
            else if (s.charAt(counter) == 'D' && (counter - 1) > 0 && s.charAt(counter - 1) == 'D') {
                number = output.last() - 1;
            }
            else if (s.charAt(counter) == 'I') {
                number = output.size() > 0 ? output.last() + 1 : 1;
                number++;
            }

            else if (s.charAt(counter) == 'D') {
                number = output.size() > 0 ? output.last() + 2 : 2;
                while (s.charAt(counter) != 'I') {
                    number++;
                    counter++;
                }
                number++;
            }

            else {
                System.out.println("Invalid Input");
            }
            if (i == 0 && s.charAt(counter) == 'I') {
                numbers.add(number - 1);
                numbers.add(number);
            }
            else if (i == 0 && s.charAt(counter) == 'D') {
                numbers.add(number);
                numbers.add(number - 1);
            }
            else {
                numbers.add(number);
            }
        }

        for (Integer i : output) {
            System.out.println(i);
        }
    }

}
