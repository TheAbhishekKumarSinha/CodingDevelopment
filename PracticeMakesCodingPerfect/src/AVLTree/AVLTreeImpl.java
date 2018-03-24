package AVLTree;

class AVLTre{
	private Node root;
	
	public Node getRoot() {
		return root;
	}

	public void setRoot(Node root) {
		this.root = root;
	}

	
	
	public Node InsertNode(int data,Node currentNode){
		
		
		if(currentNode== null) {
			Node n = new Node(data);
			return n;
		}else if(data<currentNode.getData()) {
			currentNode.setLeft(InsertNode(data,currentNode.getLeft()));
		}else if(data>currentNode.getData()) {
			currentNode.setRight(InsertNode(data,currentNode.getRight()));
		}else {
			return currentNode;
		}
		
		currentNode.setHeight(1+(max(nodeHeight(currentNode.getLeft()),nodeHeight(currentNode.getRight()))));
		
		int balance = getbalance(currentNode);
		if(balance>1 ||balance < -1 ) {
			if (balance > 1 && (currentNode.getLeft()!=null && data < currentNode.getLeft().getData()))
	            return rightRotate(currentNode);
	 
	        // Right Right Case
	        if (balance < -1 && (currentNode.getRight()!=null && data > currentNode.getRight().getData()))
	            return leftRotate(currentNode);
	 
	        // Left Right Case
	        if (balance > 1 && (currentNode.getLeft()!=null && data > currentNode.getLeft().getData())){
	            currentNode.setLeft(leftRotate(currentNode.getLeft()));
	            return rightRotate(currentNode);
	        }
	 
	        // Right Left Case
	        if (balance < -1 && (currentNode.getRight()!=null && data < currentNode.getRight().getData())){
	            currentNode.setRight(rightRotate(currentNode.getRight()));
	            return leftRotate(currentNode);
	        }
		}
		
 
		
		return currentNode;
		
	}

	private int nodeHeight(Node currentNode) {
		if(currentNode ==null)
			return 0;
		return currentNode.getHeight();
	}

	private Node rightRotate(Node currentNode) {
		// TODO Auto-generated method stub
		Node T= currentNode.getLeft();
		Node T2 =T.getRight();
		
		T.setRight(currentNode);
		currentNode.setLeft(T2);
		
		currentNode.setHeight(1+(max(currentNode.getLeft().getHeight(),currentNode.getRight().getHeight())));
		T.setHeight(1+(max(T.getLeft().getHeight(),T.getRight().getHeight())));
		
		return T;
	}
	public void printInOrder() {
		printInOrder(getRoot());
	}
	private void printInOrder(Node currentNode) {
		if(currentNode == null)
			return;
		printInOrder(currentNode.getLeft());
		System.out.println(currentNode.getData());
		printInOrder(currentNode.getRight());
		
	}

	private Node leftRotate(Node currentNode) {
		// TODO Auto-generated method stub
		Node T= currentNode.getRight();
		Node T2 =T.getLeft();
		
		T.setLeft(currentNode);
		currentNode.setRight(T2);
		
		currentNode.setHeight(1+(max(currentNode.getLeft().getHeight(),currentNode.getRight().getHeight())));
		T.setHeight(1+(max(T.getLeft().getHeight(),T.getRight().getHeight())));
		
		return T;
	}
	private int getbalance(Node node) {
		if(node==null)
			return 0;
		else return (nodeHeight(node.getRight())-nodeHeight(node.getLeft()));
	}

	private int max(int height, int height2) {
		return height>height2?height:height2;
	}

	public void InsertNode(int i) {
		// TODO Auto-generated method stub
		setRoot(InsertNode(i,getRoot()));
	}

	
}

public class AVLTreeImpl {
	public static  void main(String args[]) {
		AVLTre avl= new AVLTre();
		avl.InsertNode(10);
		avl.InsertNode(20);
		avl.InsertNode(30);
		avl.InsertNode(40);
		avl.InsertNode(50);
		avl.InsertNode(25);
		
		avl.printInOrder();
	}
}
