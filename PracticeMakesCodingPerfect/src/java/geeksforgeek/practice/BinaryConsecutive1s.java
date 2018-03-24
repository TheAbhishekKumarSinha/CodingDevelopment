package java.geeksforgeek.practice;

import java.util.Scanner;

public class BinaryConsecutive1s {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int noOfTestCases = Integer.parseInt(scan.nextLine());
		for(int testCaseCounter =0;testCaseCounter<noOfTestCases ;testCaseCounter++) {

			int n=scan.nextInt();
			int maxNumber = 0;
			while(n!=0) {
				maxNumber += Math.pow(2, n);
			}
			int count = convertNumberIntoBinary(maxNumber);
			System.out.println(count);
		}
		scan.close();
	}

	private static int convertNumberIntoBinary(int n) {
		long binaryNumber = 0;
		int digit=0;
		int count =0;
		boolean isPrevOne =false;
		for(int i =0;i<n;i++) {
			int num=i;
			while(num!=0) {
				digit = n%2;
				if(isPrevOne && digit==1)
					break;
				if(digit==1)
					isPrevOne=true;
				else
					isPrevOne=false;
				n=n/2;
				binaryNumber =binaryNumber*10+digit;
			}
			count++;
		}
		
		
		return count;
	}


}
