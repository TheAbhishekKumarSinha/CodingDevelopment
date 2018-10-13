package geeksforgeek.practice;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class stringAppend {
	public static void main (String[] args) throws NumberFormatException, IOException {
    	StringBuilder builder = null;
    	BufferedReader bf= new BufferedReader(new InputStreamReader(System.in));
    	int noOfTestCase = Integer.parseInt(bf.readLine());
    	
    	for(int i =0;i<noOfTestCase ; i++){
    		int count =0;
    		builder =new StringBuilder();
    	    String[] abc = bf.readLine().split(" ");
    	    while(abc[0].length()>count||abc[1].length()>count){
    	        if(abc[0].length()>count){
    	            builder.append(abc[0].charAt(count));
    	        }
    	        if(abc[1].length()>count){
    	            builder.append(abc[1].charAt(count));
    	        }
    	        count++;
    	    }System.out.println(builder.toString());
    	}
	}
}
