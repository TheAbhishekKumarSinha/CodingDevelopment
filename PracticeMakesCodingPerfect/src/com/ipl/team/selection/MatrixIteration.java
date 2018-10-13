package com.ipl.team.selection;

import java.util.Scanner;

/**
 * @author Abhishek Kumar Sinha
 *
 */
public class MatrixIteration {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String line = scan.nextLine();
        int[][] arr = new int[5][5];
        String arrs[] = line.split(" ");
        for (int i = 0; i < 5; i++) {
            for (int k = 0; k < 5; k++)
                arr[i][k] = Integer.parseInt(arrs[(5 * i) + k]);
        }
        printNormal(arr);
        iterateMatrixInZigZag(arr, 5);
        scan.close();

    }

    /**
     * Method Description:
     *
     * Conditions handled:
     *
     * 1.
     *
     * 2.
     * 
     * @param arr
     */
    private static void printNormal(int[][] arr) {
        // TODO Auto-generated method stub
        for (int i = 0; i < 5; i++) {
            for (int k = 0; k < 5; k++) {
                System.out.print(arr[i][k] + "\t");
            }
            System.out.println("");
        }
    }

    /**
     * Method Description:
     *
     * Conditions handled:
     *
     * 1.
     *
     * 2.
     * 
     * @param arr
     */
    private static void iterateMatrixInZigZag(int[][] arr, int n) {
        // TODO Auto-generated method stub
        System.out.println("");
        for (int i = 0; i < n; i++) {
            int k = 0;
            int l = i;
            while (k >= 0 && l >= 0 && k < n && l < n) {
                System.out.print(arr[k][l] + " ");
                k++;
                l--;
            }
            System.out.println("");
        }

        for (int i = 1; i < n; i++) {
            int k = i;
            int l = n - 1;
            while (k >= 0 && l >= 0 && k < n && l < n) {
                System.out.print(arr[k][l] + " ");
                k++;
                l--;
            }
            System.out.println("");
        }
    }
}
