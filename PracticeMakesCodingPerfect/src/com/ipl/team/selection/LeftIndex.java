package com.ipl.team.selection;

/**
 * @author Abhishek Kumar Sinha
 *
 */
class Node {
    int data;
    Node left;
    Node right;

    public Node() {
        super();
    }

    /**
     * @param data
     */
    public Node(int data) {
        super();
        this.data = data;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }

}

class BinarySearchTree {
    /**
     * 
     */
    private Node node = null;
    private Node root = new Node();

    public Node getRoot() {
        return root;
    }

    public void setRoot(Node root) {
        this.root = root;
    }

    public BinarySearchTree() {
        // TODO Auto-generated constructor stub

    }

    /**
     * Method Description:
     *
     * Conditions handled:
     *
     * 1.
     *
     * 2.
     */
    private void insertIntoBinarySearchTree(int data) {
        Node n = new Node(data);
        if (this.getRoot() == null) {
            this.setRoot(n);
        }
        else {
            Node iteratorNode = this.getRoot();
            if (data > iteratorNode.getData())
                while (data > iteratorNode.getData() && iteratorNode.getRight() != null) {
                    iteratorNode = iteratorNode.getRight();
                }
            else if (data < iteratorNode.getData()) {
                while (data < iteratorNode.getData() && iteratorNode.getLeft() != null) {
                    iteratorNode = iteratorNode.getLeft();
                }

                while (data < iteratorNode.getData()) {
                    iteratorNode = iteratorNode.getLeft();
                }
            }
        }
    }

}

public class LeftIndex {
    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();

    }

}
