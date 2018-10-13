package geeksforgeeks.datastructure.binarysearchtree;

/**
 * @author Abhishek Kumar Sinha
 *
 */
class NodeWithCount {

    int data;
    NodeWithCount left;
    NodeWithCount right;
    int count;

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public NodeWithCount getLeft() {
        return left;
    }

    public void setLeft(NodeWithCount left) {
        this.left = left;
    }

    public NodeWithCount getRight() {
        return right;
    }

    public void setRight(NodeWithCount right) {
        this.right = right;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    NodeWithCount(int data) {
        this.data = data;
        this.count = 1;
        this.left = null;
        this.right = null;
    }
}

public class NodeWithCounter {
    private NodeWithCount root;

    private NodeWithCount addNode(int data) {
        return new NodeWithCount(data);
    }

    public NodeWithCount addToBinaryTree(NodeWithCount root, int data) {
        if (root == null) {
            NodeWithCount nodes = addNode(data);
            return nodes;
        }
        else {
            NodeWithCount node = root;

            if (node.data > data) {
                node.left = addToBinaryTree(node.left, data);
            }
            else if (node.data < data) {
                node.right = addToBinaryTree(node.right, data);
            }
            else {
                node.count = node.count + 1;
            }
            return node;
        }

    }

    public static void main(String[] args) {
        NodeWithCounter tree = new NodeWithCounter();

        tree.addToBinaryTree(9);
        tree.addToBinaryTree(1);
        tree.addToBinaryTree(3);
        tree.addToBinaryTree(4);

        tree.addToBinaryTree(5);
        tree.addToBinaryTree(12);
        tree.addToBinaryTree(4);

        tree.printInOrderTransversal(tree.root);

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
     * @param i
     */
    private void addToBinaryTree(int data) {
        NodeWithCount nodeWithCount = addToBinaryTree(root, data);
        if (root == null)
            root = nodeWithCount;

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
    private void printInOrderTransversal(NodeWithCount root) {
        if (root == null) {
            return;
        }
        else {
            printInOrderTransversal(root.left);
            System.out.print(root.data + "[" + root.count + "] -> ");
            printInOrderTransversal(root.right);

        }
    }
}