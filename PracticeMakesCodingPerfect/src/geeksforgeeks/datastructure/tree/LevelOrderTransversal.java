package geeksforgeeks.datastructure.tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Abhishek Kumar Sinha
 *
 */

class Node {
    int data;
    Node left;
    Node right;

    /**
     * @param data
     */
    public Node(int data) {
        super();
        this.data = data;
        this.left = null;
        this.right = null;
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

    @Override
    public String toString() {
        return String.valueOf(this.data);
    }

}

public class LevelOrderTransversal {
    private Node root;

    public Node getRoot() {
        return root;
    }

    public void setRoot(Node root) {
        this.root = root;
    }

    public void printLevelOrder() {
        Queue<Node> nodeQueue = new LinkedList<Node>();
        nodeQueue.add(root);
        while (!nodeQueue.isEmpty()) {
            Node pollNode = nodeQueue.poll();
            System.out.print(pollNode.data + "->");
            if (pollNode.left != null) {
                nodeQueue.add(pollNode.left);
            }

            if (pollNode.right != null) {
                nodeQueue.add(pollNode.right);
            }
        }
    }

    public int getHeight(Node node) {
        if (node == null) {
            return 0;
        }
        else {
            int leftHeight = getHeight(node.left);
            int rightHeight = getHeight(node.right);
            if (leftHeight > rightHeight) {
                return (leftHeight + 1);
            }
            else {
                return (rightHeight + 1);
            }
        }
    }

    public void printOrderLevel() {
        int height = getHeight(root);
        for (int i = 0; i < height; i++) {
            printOrderLevel(root, i);
        }
    }

    void printOrderLevel(Node root, int level) {
        if (root == null)
            return;
        if (level == 0)
            System.out.print(root.data + " ");
        else if (level > 0) {
            printOrderLevel(root.left, level - 1);
            printOrderLevel(root.right, level - 1);
        }
    }

    public static void main(String[] args) {

        LevelOrderTransversal lvt = new LevelOrderTransversal();
        Node root = new Node(4);
        lvt.setRoot(root);
        root.left = new Node(2);
        root.left.left = new Node(1);
        root.left.right = new Node(3);

        root.right = new Node(6);
        root.right.left = new Node(5);
        root.right.right = new Node(7);

        lvt.printLevelOrder();
        lvt.printOrderLevel();

    }
}
