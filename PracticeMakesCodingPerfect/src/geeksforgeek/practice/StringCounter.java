package geeksforgeek.practice;
import java.util.Scanner;

public class StringCounter {
	public static void main (String[] args) {
		Scanner scan = new Scanner(System.in);
		int noOfTestCases = Integer.parseInt(scan.nextLine());
		for (int i =0;i<noOfTestCases;i++){
			String stringWithoutSpaces = scan.nextLine();
			char charToSearch = scan.nextLine().charAt(0);
			int counter = Integer.parseInt(scan.nextLine());
			int lastIndex = stringWithoutSpaces.lastIndexOf(charToSearch);
			int firstIndex = stringWithoutSpaces.indexOf(charToSearch);
			boolean indexFound = false;
			int count =0;
			if(firstIndex >=0 && counter>0 ){
				for(int j=firstIndex;j<=lastIndex;j++){
					if(stringWithoutSpaces.charAt(j)==charToSearch){
						count++;
					}
					if(count==counter){
						if(stringWithoutSpaces.length()!=j+1){
							System.out.println(stringWithoutSpaces.substring(j+1,stringWithoutSpaces.length()));
							indexFound = true; 
						}

						break;
					}
				}
			}
			if(counter==0){
				System.out.println(stringWithoutSpaces);
			}
			if(!indexFound && counter>0 ){
				System.out.println("Empty string");
			}

		}

		//code
	}
}
