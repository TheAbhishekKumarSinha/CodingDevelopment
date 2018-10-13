package geeksforgeek.practice;
import java.util.Scanner;

public class Staircase {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int noOfIteration = scan.nextInt();
		for(int i =0; i<noOfIteration;i++) {
			int noOfBlocks = scan.nextInt();
			int noOfBlocksUsed = 0;
			int block =0;
			int height =0;
			while(noOfBlocks> noOfBlocksUsed) {
				noOfBlocksUsed += ++block;
				if(noOfBlocks>= noOfBlocksUsed)
					height++;
			}
			System.out.println("");
			System.out.println(height);
		}scan.close();
		
		
	}
}
