package code.geeksforgeek.practice;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RichieRichMaxPalindrome {

	static String richieRich(String s, int n, int k){
		int i =0;
		int counter =0;
		StringBuilder builder =new StringBuilder(s);
		StringBuilder builder1 =new StringBuilder(s);
		List<Integer> changeIndex = new ArrayList<>();

		StringBuilder palindromeString = builder1.reverse();
		int middleIndex = n%2==1?(n-1)/2:n/2;
		while(i!=middleIndex){
			char aa = builder.charAt(i);
			char bb = palindromeString.charAt(i);
			String a = String.valueOf(aa);
			String b = String.valueOf(bb);
			int stackElement = Integer.parseInt(b);
			int abcd =Integer.parseInt(a);
			if(stackElement!=abcd){

				char elementToPut = stackElement>abcd?bb:aa;
				if(stackElement>abcd){
					builder.setCharAt(i,elementToPut );
					palindromeString.setCharAt(n-1-i,elementToPut );
				}
				else{
					builder.setCharAt(n-1-i,elementToPut );
					palindromeString.setCharAt(i,elementToPut );
				}
				changeIndex.add(i);
				counter++;

			}i++;
		}
		//System.out.println(palindromeString.toString());
		i=0;
		Integer[] stockArr = new Integer[changeIndex.size()];
		stockArr = changeIndex.toArray(stockArr);
		int index=0;
		if(counter<=k ){
			while(counter<k && i!=middleIndex ){
				if( changeIndex.size()>0 && changeIndex.size()<index && stockArr[index]==i ){
					if((builder.charAt(i)!='9') && counter+1<=k) {
						counter++;
						builder.setCharAt(i,'9');
						builder.setCharAt(n-1-i, '9');
					}
					
					index++;
				} else if(counter+2<=k && builder.charAt(i)!='9'){
					counter+=2;
					builder.setCharAt(i,'9');
					builder.setCharAt(n-1-i, '9');
				}


				i++;
			}
		}
		if(n%2==1 && counter+1<=k){
			builder.setCharAt(n/2,'9');
			counter++;
		}
		if(counter>k){
			return "-1";
		}
		return builder.toString();
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int k = in.nextInt();
		String s = in.next();
		String result = richieRich(s, n, k);
		BufferedWriter bw = null;
		FileWriter fw = null;
		try {
			fw = new FileWriter("d:\\filename.txt");
			bw = new BufferedWriter(fw);
			bw.write(result);
			System.out.println(result);
		}catch(Exception e){
			e.printStackTrace();
		}
		in.close();
	}
}
