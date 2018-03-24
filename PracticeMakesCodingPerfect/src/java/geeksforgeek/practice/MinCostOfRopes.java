package java.geeksforgeek.practice;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.Stack;

public class MinCostOfRopes {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int noOfTestCases = Integer.parseInt(scan.nextLine());
		for(int testCaseCounter =0;testCaseCounter<noOfTestCases ;testCaseCounter++) {

			int n=scan.nextInt();
			PriorityQueue<Integer> pq=new PriorityQueue<Integer>();
			for(int i=0;i<n;++i)
				pq.add(scan.nextInt());
			int s=0;
			while(pq.size()>=2 )
			{
				int x=pq.poll();
				int y=pq.poll();
				pq.add(x+y);
				s+=(x+y);
			}
			System.out.println(s);
		}

		scan.close();

	}

	private static int minimumCostForConnectingRopes(String[] ropes) {
		Stack<Integer> numberStack = new Stack<Integer>();
		Stack<Integer> sumStack = new Stack<Integer>();
		ArrayList<Integer> hs = new ArrayList<>();
		for(String rope:ropes)
			hs.add(Integer.parseInt(rope));
		Collections.sort(hs);
		int sum = 0;
		for(Integer in: hs) {
			sum=sum+in;
			if(sum>in) {
				sumStack.push(sum);
			}
		}
		int sums =0;
		while(!sumStack.isEmpty()) {
			sums+=sumStack.pop();
		}
		return sums;
	}
}
