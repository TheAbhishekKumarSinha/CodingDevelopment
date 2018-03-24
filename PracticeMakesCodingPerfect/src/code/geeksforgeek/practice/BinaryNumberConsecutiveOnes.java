package code.geeksforgeek.practice;

import java.util.Scanner;

public class BinaryNumberConsecutiveOnes {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int noOfTestCases = Integer.parseInt(scan.nextLine());
        for (int testCaseCounter = 0; testCaseCounter < noOfTestCases; testCaseCounter++) {
            int count = 1;
            int n = scan.nextInt();
            /*
             * int maxNumber = 0; while(n!=0) { maxNumber += Math.pow(2, n-1); n--; } for(int i
             * =0;i<=maxNumber;i++) { boolean isNotConsequtive = convertNumberIntoBinary(i); if
             * (isNotConsequtive) { count++; System.out.println(i); }
             * 
             * } for(
             */
            String startString = "";
            for (int i = 0; i < n; i++) {
                startString += "0";
            }
            /*
             * while(true) { startString.charAt(index) break; }
             */
            System.out.println(count);
        }
        scan.close();
    }

    /*
     * private static boolean convertNumberIntoBinary(int n) {
     * 
     * long binaryNumber = 0; int digit=0; boolean isPrevOne =false; int num=n; while(num!=0) {
     * digit = num%2; if(isPrevOne && digit==1) return false; if(digit==1) isPrevOne=true; else
     * isPrevOne=false; num=num/2; binaryNumber =binaryNumber*10+digit; } return true;
     * 
     * }
     */

}
