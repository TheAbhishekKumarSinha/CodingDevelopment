package code.geeksforgeek.practice;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class HackerRankRadioStation {


	static int hackerlandRadioTransmitters(int[] x, int k) {

		Arrays.sort(x);
		int startIndex =0;
		int count =0;
		int arrayCounter =0;
		int prevNumber =0;
		float a = 1.0f;
		double d= 1.0d;
		while(arrayCounter <=x.length-1 && startIndex<=x[x.length-1]) {
			int number = x[arrayCounter]+k;
			int minNumber = x[arrayCounter];

			while(arrayCounter <=x.length-1) {
				if(x[arrayCounter]==number) {
					count++;
					prevNumber = number;
					System.out.println(number);
					startIndex=number+k;
					int indxs = arrayCounter;
					while(indxs<x.length-1 && x[indxs]<=startIndex) {
						indxs++;
					}
					startIndex = x[indxs];
					if(x[x.length-1]!=startIndex)
						arrayCounter = indxs;
					else 
						arrayCounter++;
					break;
				}
				else if(x[arrayCounter]>number) {
					arrayCounter--;
					while(x[arrayCounter]<number)
						number--;
					if(number == x[x.length-1]) {
						count++;
					}
				}
				else{
					if(number>x[x.length-1]) {
						while(number>x[x.length-1]) {
							number--;

						}
						if((number - prevNumber)>=k)
							arrayCounter=x.length-1;
						else
							arrayCounter=x.length;
					}
					else {
						arrayCounter++;
					}
				}

			}
		}
		return count;
	}

	public static void main(String... args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int k = in.nextInt();
		int[] x = new int[n];
		for(int x_i = 0; x_i < n; x_i++){
			x[x_i] = in.nextInt();
		}
		int result = hackerlandRadioTransmitters(x, k);
		System.out.println(result);
		in.close();
	}
}
