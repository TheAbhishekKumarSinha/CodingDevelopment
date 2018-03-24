package code.geeksforgeek.practice;

import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Scanner;

public class SizeOfCandle {
	static int birthdayCakeCandles(int n, int[] ar) {
		HashMap<Integer,Integer> hm = new HashMap<>();
		 for(int ar_i = 0; ar_i < n; ar_i++){
	           if(hm.containsKey(ar[ar_i])) {
	        	  hm.put(ar[ar_i],hm.get(ar[ar_i])+1);
	           }else
	        	   hm.put(ar[ar_i],1);
	        }
		 int max=0;
		 for(Entry<Integer,Integer> entry : hm.entrySet()) {
			 max=max>entry.getKey()?max:entry.getKey();
		 }
		 return hm.get(max);
		 
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] ar = new int[n];
        for(int ar_i = 0; ar_i < n; ar_i++){
            ar[ar_i] = in.nextInt();
        }
        int result = birthdayCakeCandles(n, ar);
        System.out.println(result);
    }
}
