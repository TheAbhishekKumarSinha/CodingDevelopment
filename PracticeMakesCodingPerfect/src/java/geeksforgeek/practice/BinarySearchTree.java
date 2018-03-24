package java.geeksforgeek.practice;


class Nodee{
	int data;
	Nodee left;
	Nodee right;
	public Nodee getLeft() {
		return left;
	}
	public void setLeft(Nodee left) {
		this.left = left;
	}
	public Nodee getRight() {
		return right;
	}
	public void setRight(Nodee right) {
		this.right = right;
	}
	public int getData() {
		return data;
	}

	Nodee(int i ) {
		this.data=i;
		this.setLeft(null);
		this.setRight(null);
	}

}
public class BinarySearchTree {
	Nodee root;

	public Nodee getRoot() {
		return root;
	}

	public void setRoot(Nodee root) {
		this.root = root;
	}

	public BinarySearchTree(){
		setRoot(null);
	}

	public static void main(String[] args) {
		BinarySearchTree tree = new BinarySearchTree();
		Nodee n = tree.insert(50);
		tree.setRoot(n);
		tree.insert(30);
		tree.insert(20);
		tree.insert(40);
		tree.insert(70);
		tree.insert(60);
		tree.insert(80);
		
		tree.inOrderStack();
	}

	private void inOrderStack() {
		inOrderStack	(getRoot());

	}

	private void inOrderStack(Nodee root) {
		if(root!=null) {
			inOrderStack(root.left);
			System.out.println(root.getData());
			inOrderStack(root.right);
		}

	}

	private Nodee insert(int i) {
		return insert(getRoot(),i);

	}

	private Nodee insert(Nodee currentNode,int i) {
		Nodee n =null;
		if(currentNode==null) {
			currentNode= new Nodee(i);
			return currentNode;

		}else {
			if(currentNode.getData()>i) {
				/*System.out.println(currentNode.getData());*/
				currentNode.setLeft(insert(currentNode.getLeft(),i));
			}else {
				currentNode.setRight(insert(currentNode.getRight(),i));
			}
		}
		return currentNode;


	}

}
