package abhi.multithread;

import java.util.ArrayList;
import java.util.Scanner;

public class PatternMNM {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int noOfTestCases = Integer.parseInt(scan.nextLine());
        for (int i = 0; i < noOfTestCases; i++) {
            String pattern = scan.nextLine().trim();
            ArrayList<Integer> abcd = new ArrayList<>();
            int Mins = convertPatternToNumbers(pattern, abcd);
            int min = 0;
            for (Integer minsss : abcd) {
                min = min < minsss ? min : minsss;
            }
            int intNumberToBeAdded = 1 - (min);
            int intNumber = 0;
            for (int anc : abcd) {
                intNumber = intNumber * 10;
                anc = anc + intNumberToBeAdded;
                intNumber = intNumber + anc;
            }
            System.out.println(intNumber);
        }

        scan.close();
    }

    private static int convertPatternToNumbers(String pattern, ArrayList<Integer> abcd) {
        int firstNumber = 0;
        int secondNumber = 0;
        int minNumber = 0;
        for (int i = 0; i < pattern.length(); i++) {
            char a = pattern.charAt(i);
            firstNumber = secondNumber;
            switch (a) {
                case 'D':
                    secondNumber = firstNumber - 1;
                    if (((i + 1) < pattern.length()) && pattern.charAt(i + 1) == 'I') {
                        /*
                         * int j=i+1; while(j<pattern.length() && pattern.charAt(j) == 'I') { j++;
                         * secondNumber++; }
                         */
                    }
                    else {
                        while (abcd.contains(secondNumber)) {
                            secondNumber--;
                        }
                    }

                    abcd.add(firstNumber);
                    break;
                case 'I':
                    secondNumber++;
                    while (abcd.contains(firstNumber)) {
                        firstNumber = firstNumber + 1;
                    }

                    if (((i + 1) < pattern.length()) && pattern.charAt(i + 1) == 'D') {
                        while (abcd.contains(secondNumber))
                            secondNumber++;
                        int j = i + 1;
                        while (j < pattern.length() && pattern.charAt(j) == 'D') {
                            j++;
                            secondNumber++;
                        }
                        // secondNumber=firstNumber-1;
                    }
                    else {
                        secondNumber = firstNumber + 1;
                    }
                    abcd.add(firstNumber);

                    while (abcd.contains(secondNumber)) {
                        secondNumber = secondNumber + 1;
                    }

                    break;
            }
        }
        abcd.add(secondNumber);
        return minNumber;
    }

}
