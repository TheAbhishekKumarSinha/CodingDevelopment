package java.geeksforgeek.practice;
import java.util.HashMap;
import java.util.Scanner;
import java.util.SortedSet;
import java.util.TreeSet;


public class MaximumZero {	
	public static void main (String[] args) {
	Scanner scan = new Scanner(System.in);
	int noOfTestCase = Integer.parseInt(scan.nextLine());
	try{
		for(int i =0;i<noOfTestCase;i++) {
			int ArraySize = Integer.parseInt(scan.nextLine());
			int count = 0;
			String[] noArray= new String[ArraySize];

			noArray = scan.nextLine().split(" ");

			findMaxZeroOccured(noArray);

		}	
	}catch(ArrayIndexOutOfBoundsException e){
		System.out.println("Invalid Input");
	}finally{
		scan.close();
	}
}
private static void findMaxZeroOccured(String[] noArray) {
	HashMap<Integer,SortedSet<Integer>> count = new HashMap<>();
	int highestCount = 0;
	for( String array:noArray){
		int countwe =0;
		for (int i = 0; i < array.length(); i++) {
			if (array.charAt(i) == '0') {
				countwe++;
			}
		}
		SortedSet<Integer> strings = count.get(countwe);
		if(strings ==null || strings.isEmpty()){
			strings = new TreeSet<>();	
		}
		if(countwe>0)
		    strings.add(Integer.parseInt(array));

		count.put(countwe,strings);
		highestCount = countwe>highestCount?countwe:highestCount;
	}
	SortedSet<Integer> maxSet= count.get(highestCount);
	int highestNumber = (highestCount>0)?maxSet.last():-1;
	System.out.println(highestNumber);

}		


}
