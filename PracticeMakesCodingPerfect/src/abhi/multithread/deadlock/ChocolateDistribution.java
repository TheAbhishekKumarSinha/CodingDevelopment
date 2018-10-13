package abhi.multithread.deadlock;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author Abhishek Kumar Sinha
 *
 */
public class ChocolateDistribution {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String s = bf.readLine().trim();
        int noOfTestCases = Integer.parseInt(s);
        int counter = 0;
        while (noOfTestCases > 0) {
            for (int i = 0; i < noOfTestCases; i++) {
                String input = bf.readLine().trim();
                String[] testlines = input.split(" ");
                int numberofperson = Integer.parseInt(testlines[0]);
                int boxes = Integer.parseInt(testlines[1]);
                input = bf.readLine().trim();
                testlines = input.split(" ");
                int sum = 0;
                for (int j = 0; j < numberofperson; j++) {
                    sum = sum + Integer.parseInt(testlines[j]);
                }
                if (sum % boxes == 0) {
                    System.out.println(sum / boxes);
                    noOfTestCases--;
                    continue;
                }

                int firstNumberHit = 0, secondNumberHit = 0, lastHit = 0;
                int personCount = 0;
                int sumBackSub = sum, sumFrontSub = sum;
                while (sumFrontSub % boxes != 0 && (personCount != numberofperson - 1)) {
                    sumFrontSub -= Integer.parseInt(testlines[personCount]);
                    personCount++;

                }
                if (sumFrontSub % boxes == 0) {
                    firstNumberHit = sumFrontSub / boxes;
                }
                personCount = numberofperson - 1;
                while (sumBackSub % boxes != 0 && (personCount != 0)) {
                    sumBackSub -= Integer.parseInt(testlines[personCount]);
                    personCount--;
                }
                if (sumBackSub % boxes == 0) {
                    secondNumberHit = sumBackSub / boxes;
                }

                int sumSubBothWays = sum;
                int backPersonCount = numberofperson - 1;
                int frontPersonCount = 0;
                while (sumSubBothWays % boxes != 0 && ((frontPersonCount < numberofperson) && backPersonCount > 0)) {
                    if ((sumSubBothWays - Integer.parseInt(testlines[backPersonCount])) % boxes == 0) {
                        sumSubBothWays -= Integer.parseInt(testlines[backPersonCount]);
                        backPersonCount--;
                    }
                    else if ((sumSubBothWays - Integer.parseInt(testlines[frontPersonCount])) % boxes == 0) {
                        sumSubBothWays -= Integer.parseInt(testlines[frontPersonCount]);
                        frontPersonCount++;

                    }
                    else {
                        sumSubBothWays -= (Integer.parseInt(testlines[frontPersonCount])
                                + Integer.parseInt(testlines[backPersonCount]));
                        frontPersonCount++;
                        backPersonCount--;

                    }
                }
                if (sumSubBothWays % boxes == 0) {
                    lastHit = sumSubBothWays / boxes;
                }
                if (firstNumberHit >= secondNumberHit && firstNumberHit >= lastHit) {
                    System.out.println(firstNumberHit);
                }
                else if (secondNumberHit >= lastHit && firstNumberHit <= secondNumberHit) {
                    System.out.println(secondNumberHit);
                }
                else if (lastHit >= firstNumberHit && lastHit >= secondNumberHit) {
                    System.out.println(lastHit);
                }
                else {
                    System.out.println(0);
                }

                noOfTestCases--;
            }

        }

    }
}
