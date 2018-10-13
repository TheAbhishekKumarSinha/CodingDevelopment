package geeksforgeeks.datastructure.tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Abhishek Kumar Sinha
 *
 */
public class EnforceChildrenSumProperty {
    Node root;

    public void checkForSumProperty() {
        checkForSumProperty(this.root);
    }

    public int checkForSumProperty(Node root) {
        int leftChildSum = 0, rightChildSum = 0;
        boolean isChildSumProperty = false;
        if ((root == null) || (root.left == null && root.right == null)) {
            return 1;
        }
        else {
            checkForSumProperty(root.left);
            checkForSumProperty(root.right);

            if (root.left != null)
                leftChildSum = root.left.data;
            if (root.right != null)
                rightChildSum = root.right.data;
            if (!(root.data == (leftChildSum + rightChildSum))) {
                int diff = root.data - (leftChildSum + rightChildSum);
                updateNodeData(root, diff);
            }
            return 1;
        }
    }

    /**
     * Method Description:
     *
     * Conditions handled:
     *
     * 1.
     *
     * 2.
     * 
     * @param root2
     * @param diff
     */
    private void updateNodeData(Node root, int diff) {
        if (diff < 0) {
            root.data = root.data + (diff * -1);
        }
        else {
            if (root == null || (root.left == null && root.right == null)) {
                return;
            }
            updateNodeData(root.left, diff);
            updateNodeData(root.right, diff);
            if (root.left != null) {
                root.left.data = root.left.data + diff;
            }
            else if (root.right != null) {
                root.right.data = root.right.data + diff;
            }
        }

    }

    /**
     * Method Description:
     *
     * Conditions handled:
     *
     * 1.
     *
     * 2.
     * 
     * @param root2
     * @param diff
     */
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

    public static void main(String[] args) {
        EnforceChildrenSumProperty enf = new EnforceChildrenSumProperty();
        Node root = new Node(10);
        enf.root = root;
        root.left = new Node(8);
        root.left.left = new Node(6);

        // root.left.right = new Node(7);
        root.left.left.left = new Node(5);
        root.left.left.left.left = new Node(7);
        root.left.left.left.right = new Node(8);

        root.left.left.right = new Node(4);
        // root.left.left.right.left = new Node(1);
        root.left.left.right.right = new Node(1);

        root.right = new Node(7);
        // root.right.left = new Node(2);
        root.right.right = new Node(3);

        enf.checkForSumProperty(root);

        enf.printLevelOrder();
        /*
         * if (returnValue) { System.out.println("Follows Child Sum Property"); } else {
         * System.out.println("Does Not follows Child Sum Property"); }
         */
    }
}
