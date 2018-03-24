package java.geeksforgeek.practice;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.SortedSet;
import java.util.TreeSet;

public class SortedSets {

	public static void main (String[] args) {
		Scanner scan = new Scanner(System.in);
		int noOfInputs = Integer.parseInt(scan.nextLine());
		MedianFinder md= new MedianFinder();
		for (int i =0;i<noOfInputs;i++) {
			int nextInput = Integer.parseInt(scan.nextLine().trim());
			md.addNum(nextInput);
			System.out.println(md.findMedian());
		}
	}

	static class MedianFinder {
		PriorityQueue<Integer> maxHeap;//lower half
		PriorityQueue<Integer> minHeap;//higher half

		public MedianFinder(){
			maxHeap = new PriorityQueue<Integer>(Collections.reverseOrder());
			minHeap = new PriorityQueue<Integer>();
		}

		// Adds a number into the data structure.
		public void addNum(int num) {
			maxHeap.offer(num);
			minHeap.offer(maxHeap.poll());

			if(maxHeap.size() < minHeap.size()){
				maxHeap.offer(minHeap.poll());
			}
		}

		// Returns the median of current data stream
		public double findMedian() {
			if(maxHeap.size()==minHeap.size()){
				return (double)(maxHeap.peek()+(minHeap.peek()))/2;
			}else{
				return maxHeap.peek();
			}
		}
	}

}
