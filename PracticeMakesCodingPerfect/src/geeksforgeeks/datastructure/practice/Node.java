package geeksforgeeks.datastructure.practice;

class Node{
	private int data ;
	public int getData() {
		return data;
	}
	private Node next;
	public Node(){

	}
	public Node(int data) {
		this.data = data;
		this.next = null;
	}

	public Node getNext() {
		return next;
	}
	public void setNext(Node next) {
		this.next = next;
	}

}