package code.geeksforgeek.practice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class MinMaxSum {
	static void miniMaxSum(int[] arr) {
		int counter =0;

		ArrayList<Long> lo= new ArrayList<Long>();
		for(int arr_J = 0; arr_J < 5; arr_J++){
			Long sum=0L;
			for(int arr_i = 0; arr_i < 5; arr_i++){
				if(arr_i!=counter) {
					sum=sum+arr[arr_i];
				}
			}lo.add(Long.valueOf(sum));
			counter++;}
		Collections.sort(lo);
		System.out.print(lo.get(0)+" "+lo.get(lo.size()-1));
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int[] arr = new int[5];
		for(int arr_i = 0; arr_i < 5; arr_i++){
			arr[arr_i] = in.nextInt();
		}
		miniMaxSum(arr);
		in.close();
	}
}
