package geeksforgeek.practice;
/*package whatever //do not write package name here */

import java.util.*;
import java.lang.*;
import java.io.*;
/*Davis who has number of scanners in his shop select only two scanners to scan the documents of a customer.
 *  When a customer comes to his shop he knows three parameters S1, S2 and N.  S1 and S2 are the time taken by
 *   scanner 1 and scanner 2 to scan one document respectively And N is the number of documents given by the 
 *   customer. As he is suppose to entertain a number of customers, he wants to calculate the minimum time to 
 *   scan all the N documents using those two scanners.

Input:
The first line of input contains an integer T denoting the number of test cases. Then T test cases follow. 
Each test case contains three space separated integers S1, S2 and N.

Output:
In new line, print the minimum time required.

Constraints:
1<=T<=500
1<=S1,S2,N<=106

Example:
Input:
2
2 4 2
1 2 2
Output:
4
2*/
public class TwoScanners {
	public static void main (String[] arg) {
		Scanner scan = new Scanner(System.in);
		int noofArguments = Integer.parseInt(scan.nextLine());
		for (int i=0;i<noofArguments;i++){
			String line = scan.nextLine();
			String[] arguments = line.split(" ");
			int firstScannerTime = Integer.parseInt(arguments[0]);
			int secondScannerTime =Integer.parseInt(arguments[1]);
			int noOfDocument =Integer.parseInt(arguments[2]);
			boolean firstScannerLessTime = firstScannerTime<secondScannerTime?true:false;
			if (!(firstScannerLessTime )){
				int temp = firstScannerTime;
				firstScannerTime=secondScannerTime;
				secondScannerTime= temp;
				firstScannerLessTime= true;
			}
			int totalTime = 0;
			int FirstScannerTimers = 0;
			int SecondScannerTimers =0;
			if(firstScannerLessTime){
				FirstScannerTimers += firstScannerTime;
			}else{
				SecondScannerTimers += secondScannerTime; 
			}
			noOfDocument--;
			while(noOfDocument!=0){

				if((FirstScannerTimers +firstScannerTime)<=SecondScannerTimers + secondScannerTime ){
					FirstScannerTimers += firstScannerTime;
					noOfDocument--;
				}
				else{
					SecondScannerTimers += secondScannerTime;
					noOfDocument--;
				}
			}
			if(FirstScannerTimers>=SecondScannerTimers){
				System.out.println(FirstScannerTimers);
			}else{
				System.out.println(SecondScannerTimers);
			}

		}
	}


}

