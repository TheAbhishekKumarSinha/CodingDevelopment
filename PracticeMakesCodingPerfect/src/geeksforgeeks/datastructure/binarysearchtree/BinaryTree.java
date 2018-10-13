package geeksforgeeks.datastructure.binarysearchtree;

/**
 * @author Abhishek Kumar Sinha
 *
 */
public class BinaryTree {
    private Node head;
    private Node Last;

    class Node {
        Node left;
        Node right;
        int data;

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

        public int getData() {
            return data;
        }

        public void setData(int data) {
            this.data = data;
        }

    }

    public void add(int data) {
        Node n = new Node();
        n.setData(data);
        if (head == null)
            head = n;
        else add(head, n);

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
     * @param n
     * @param n2
     */
    private Node add(Node head, Node newNode) {
        Node currentHead = head;
        if (currentHead == null) {
            return newNode;

        }
        else {
            if (currentHead.data < newNode.data) {
                currentHead.right = add(currentHead.right, newNode);
            }
            else {
                currentHead.left = add(currentHead.left, newNode);
            }
        }
        return currentHead;

    }

    void printinorder(Node node) {
        if (node == null) {
            return;
        }

        printinorder(node.left);
        System.out.print(node.data + " ");

        printinorder(node.right);
    }

    void convertToDoubleLinkedList(Node node, DoubleLinkedList dll) {
        if (node == null) {
            return;
        }

        convertToDoubleLinkedList(node.left, dll);

        dll.add(node);

        convertToDoubleLinkedList(node.right, dll);
    }

    void printPreOrder(Node node) {
        if (node == null) {
            return;
        }
        System.out.print(node.data + " ");
        printPreOrder(node.left);

        printPreOrder(node.right);
    }

    void printPostOrder(Node node) {
        if (node == null) {
            return;
        }

        printPostOrder(node.right);
        printPostOrder(node.left);
        System.out.print(node.data + " ");

    }

    void printLevelOrder() {
        int h = height(head);
        int i;
        for (i = 1; i <= h; i++)
            printGivenLevel(head, i);
    }

    /*
     * Compute the "height" of a tree -- the number of nodes along the longest path from the root
     * node down to the farthest leaf node.
     */
    int height(Node root) {
        if (root == null)
            return 0;
        else {
            /* compute height of each subtree */
            int lheight = height(root.left);
            int rheight = height(root.right);

            /* use the larger one */
            if (lheight > rheight)
                return (lheight + 1);
            else return (rheight + 1);
        }
    }

    /* Print nodes at the given level */
    void printGivenLevel(Node root, int level) {
        if (root == null)
            return;
        if (level == 1) {
            System.out.print(root.data + " ");
            System.out.println("");
        }

        else if (level > 1) {
            printGivenLevel(root.left, level - 1);
            printGivenLevel(root.right, level - 1);

        }

    }

    public static void main(String args[]) {
        BinaryTree binaryTree = new BinaryTree();
        binaryTree.add(5);
        binaryTree.add(8);
        binaryTree.add(3);
        binaryTree.add(6);
        binaryTree.add(1);
        binaryTree.add(9);
        binaryTree.add(4);
        binaryTree.add(7);

        System.out.println("Level order traversal of binary tree is ");
        binaryTree.printLevelOrder();

        System.out.println("In order traversal of binary tree is ");
        binaryTree.printinorder();

        System.out.println("Pre order traversal of binary tree is ");
        binaryTree.printpreorder();

        System.out.println("Post order traversal of binary tree is ");
        binaryTree.printpostorder();

        DoubleLinkedList dll = new DoubleLinkedList();
        binaryTree.convertToDoubleLinkedList(dll);

        System.out.println("forward traversal of dll is ");
        dll.printForward();

        System.out.println("backward traversal of dll is ");
        dll.printBackward();
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
     * @param dll
     */
    private void convertToDoubleLinkedList(DoubleLinkedList dll) {
        convertToDoubleLinkedList(this.head, dll);

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
    private void printpostorder() {

        printPostOrder(head);
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
    private void printpreorder() {
        printPreOrder(head);

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
    private void printinorder() {
        printinorder(this.head);

    }

}
