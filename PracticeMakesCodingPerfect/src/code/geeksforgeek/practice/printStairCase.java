package code.geeksforgeek.practice;

import java.util.Scanner;

public class printStairCase {
	public static void staircase(int n) {
		for(int i =1;i<=n;i++){
			for(int j=n-1;j>=1;j--){
				System.out.print(" ");
			}
			int num=i;
			while(num!=0) {
				System.out.print("#");
				num--;
				
			}

		}

	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		staircase(n);
		in.close();
	}
}
