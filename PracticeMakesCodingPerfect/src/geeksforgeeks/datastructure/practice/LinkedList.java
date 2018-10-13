package geeksforgeeks.datastructure.practice;

import java.util.HashMap;

class SingleLinkedList{
	private Node head;

	public Node getHead() {
		return head;
	}

	public void setHead(Node head) {
		this.head = head;
	}
	
	public void count(int i) {
		Node currentNode = getHead();
		HashMap<Integer,Integer> counter = new HashMap<>();
		
		while(currentNode!=null) {
			if(counter.containsKey(currentNode.getData())) {
				int count=counter.get(currentNode.getData());
				count=count+1;
			}else {
				counter.put(currentNode.getData(),1);
			}
			currentNode = currentNode.getNext();
		}
		if(counter.containsKey(i)) {
			int k =counter.get(i);
			System.out.println(k);
		}else {
			System.out.println("Element - "+i+" Not Found In List");
		}
		
	}
	public void insertAtStart(int i) {
		Node currentNode = new Node(i);
		Node headNode = getHead();
		if(headNode == null) {
			setHead(currentNode);
		}else {
			currentNode.setNext(headNode);
			setHead(currentNode);			
		}
		
	}
	
	public void insertAtEnd(int i) {
		Node newNode = new Node(i);
		Node currentNode = getHead();
		if(currentNode == null) {
			setHead(newNode);
		}else {
			while(currentNode.getNext()!= null) {
				currentNode=currentNode.getNext();
				
			}
			currentNode.setNext(newNode);
		}
	}
	
	public void insertAfterAnElement(int j,int i) {
		Node currentNode = getHead();
		Node nextNode = null;
		boolean nodeHit = false;
		if(currentNode == null) {
			System.out.println("Element Not Found");
		}else {
			while(currentNode!= null) {
				if(currentNode.getData()==i) {
					Node newNode = new Node(j);
					nextNode = currentNode.getNext();
					currentNode.setNext(newNode);
					newNode.setNext(nextNode);
					nodeHit= true;
				}
					
				currentNode=currentNode.getNext();
				
			}if(!nodeHit)
				System.out.println("No Node with Element - "+i+" found");
			
		}
	}
	
	public void printList() {
		Node currentNode = getHead();
		while(currentNode!=null) {
			System.out.print(currentNode.getData());
			if(currentNode.getNext()!= null) {
				System.out.print("-->");
			}
			currentNode=currentNode.getNext();
		}System.out.println("");
		
	}
	
	public void reverse() {
		Node currentNode = getHead();
		Node prev = null;
		Node next = null;
		while(currentNode!=null) {
			next= currentNode.getNext();
			currentNode.setNext(prev);
			prev= currentNode;
			currentNode = next;
			
		}
		setHead(prev);
	}
	
	int detectLoop()
    {
        Node slow_p = head, fast_p = head;
        while (slow_p != null && fast_p != null && fast_p.getNext() != null) {
            slow_p = slow_p.getNext();
            fast_p = fast_p.getNext().getNext();
            if (slow_p == fast_p) {
                System.out.println("Found loop");
                return 1;
            }
        }
        return 0;
    }
	
	
}

public class LinkedList {
	public static void main(String args[]) {
		SingleLinkedList SLL= new SingleLinkedList();
	/*	SLL.printList();
		SLL.insertAfterAnElement(130, 30);
		SLL.insertAtStart(10);
		SLL.printList();
		System.out.println( "After Insertion At End");
		SLL.insertAtEnd(120);
		SLL.printList();
		SLL.insertAfterAnElement(130, 30);
		SLL.insertAfterAnElement(30, 120);
		SLL.printList();
		SLL.count(130);
		SLL.count(120);
		SLL.count(30);
		SLL.count(10);
		SLL.reverse();
		SLL.printList();*/

	}
}