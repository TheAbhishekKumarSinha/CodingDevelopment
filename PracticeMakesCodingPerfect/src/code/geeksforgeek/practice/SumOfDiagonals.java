package code.geeksforgeek.practice;

import java.util.Scanner;

public class SumOfDiagonals {

	static int diagonalDifference(int[][] a) {
		int size = a.length;
		int iIndex =0;
		int jIndex =0;
		int sum1 = 0;
		int sum2 = 0;
		while(size!=0) {
			sum1 = sum1+a[iIndex][jIndex];
			iIndex++;
			jIndex++;
			size--;
		}
		iIndex=0;
		jIndex = a.length-1;
		size =a.length;
		while(size!=0) {
			sum2 = sum2+a[iIndex][jIndex];
			iIndex++;
			jIndex--;
			size--;
		}
        return Math.abs(sum1-sum2);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[][] a = new int[n][n];
        for(int a_i = 0; a_i < n; a_i++){
            for(int a_j = 0; a_j < n; a_j++){
                a[a_i][a_j] = in.nextInt();
            }
        }
        int result = diagonalDifference(a);
        System.out.println(result);
        in.close();
    }
}
/*Given a square matrix of size , calculate the absolute difference between the sums of its diagonals.

Input Format

The first line contains a single integer, . The next  lines denote the matrix's rows, with each line containing space-separated integers describing the columns.

Constraints

Output Format

Print the absolute difference between the two sums of the matrix's diagonals as a single integer.

Sample Input

3

11 	2 	4
4 	5 	6
10 	8 	-12
Sample Output

15
Explanation

The primary diagonal is:

11
   5
     -12
Sum across the primary diagonal: 11 + 5 - 12 = 4

The secondary diagonal is:

     4
   5
10
Sum across the secondary diagonal: 4 + 5 + 10 = 19 
Difference: |4 - 19| = 15

Note: |x| is absolute value function*/