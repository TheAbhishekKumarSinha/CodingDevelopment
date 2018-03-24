package java.geeksforgeek.practice.dataStructure;

class CircularLL {
	private static int count;
	private Node Head;

	public Node getHead() {
		return Head;
	}

	private void setHead(Node head) {
		Head = head;
	}
	public void InsertIntoStart(int data) {
		Node n = new Node(data);
		if(getHead()==null) {
			setHead(n);
			n.setNext(n);

		}else {
			Node currentNode= getHead();
			while(currentNode.getNext()!= getHead()) {
				currentNode = currentNode.getNext();
			}
			currentNode.setNext(n);
			n.setNext(getHead());
			setHead(n);
		}
		
	}

	public void InsertIntoEnd(int data){
		Node n = new Node(data);
		if(getHead()==null) {
			setHead(n);
			n.setNext(n);

		}else {
			Node currentNode= getHead();
			while(currentNode.getNext()!= getHead()) {
				currentNode = currentNode.getNext();
			}
			currentNode.setNext(n);
			n.setNext(getHead());
		}
	}

	public void Display() {
		count=0;
		if(getHead()!=null) {
			Node currentNode = getHead();
			do{
				System.out.print(currentNode.getData());
				if(currentNode.getNext()!= getHead())
					System.out.print("-->");
				currentNode = currentNode.getNext();
				count++;
			}while(currentNode!=getHead());
			System.out.println("");
		}System.out.println(count);
		
	}
	
	public void getNthItem(int n) {
		Node currentNode = getHead();
		while(n!=0) {
			currentNode =currentNode.getNext();
			n--;
		}
		System.out.println(currentNode.getData());
	}
	
	public void getNthItemFromEnd(int n) {
		int count= lengthOfLinkedList(getHead());
		Node currentNode = getHead();
		n= count-n-1;
		while(n!=0) {
			currentNode =currentNode.getNext();
			n--;
		}
		System.out.println(currentNode.getData());
	}
	
	
	public void LengthOfLinkedList() {
		System.out.println(lengthOfLinkedList(getHead()));
	}
	private int lengthOfLinkedList(Node n) {
		
		if( n.getNext() !=getHead()) {
			n=n.getNext();
			return 1 + lengthOfLinkedList(n);
			
		}
		else{
			
			
			return 1;
			
		}
	}
	public void swapTwoNodes(int data1, int data2) {
		Node currentNode = getHead();
		Node node1 = null;
		Node previousNode1 = null;
		Node node2 = null;
		Node previousNode2 = null;
		if(currentNode!=null) {
			do{
				if(currentNode.getNext().getData() ==data1 ) {
					previousNode1= currentNode;
				}else if(currentNode.getNext().getData() ==data2 ) {
					previousNode2 = currentNode;
				}
				if(currentNode.getData() ==data1 ) {
					node1= currentNode;
				}else if(currentNode.getData() ==data2 ) {
					node2 = currentNode;
				}
				if(node1!=null && node2!=null && previousNode1!=null && previousNode2!=null) {
					break;
				}else {
					currentNode =currentNode.getNext();
				}
			}while(currentNode!=getHead());
			previousNode1.setNext(node2);
			previousNode2.setNext(node1);
			currentNode = node1.getNext();
			node1.setNext(node2.getNext());
			node2.setNext(currentNode);
			if(getHead().getData()== data1) {
				setHead(node2);
			}else if(getHead().getData()== data2) {
				setHead(node1);
			}
		}else {
			System.out.println("LinkedList is Empty");
		}
		
		
	}
}
public class CircularLinkedList {
	public static void main(String args[]) {
		CircularLL cll= new CircularLL();
		cll.InsertIntoEnd(10);
		cll.Display();
		System.out.println("After Insertion At the start");
		cll.InsertIntoStart(20);
		cll.Display();
		System.out.println("After Insertion At the End");
		cll.InsertIntoEnd(40);
		cll.Display();
		System.out.println("After Insertion At the End");
		cll.InsertIntoEnd(120);
		cll.Display();
		System.out.println("After Insertion At the End");
		cll.InsertIntoEnd(130);
		cll.Display();
		System.out.println("After Insertion At the End");
		cll.InsertIntoEnd(45);
		cll.Display();
		System.out.println("After Insertion At the End");
		cll.InsertIntoEnd(124);
		cll.Display();
		System.out.println("After Insertion At the End");
		cll.InsertIntoStart(1240);
		cll.Display();
		cll.LengthOfLinkedList();
		cll.swapTwoNodes(10, 1240);
		cll.Display();
		cll.swapTwoNodes(20, 40);
		cll.Display();
		cll.getNthItem(2);
		cll.getNthItemFromEnd(2);
	}
}