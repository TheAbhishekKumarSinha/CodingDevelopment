package geeksforgeeks.datastructure.tree;

import java.util.Stack;

/**
 * @author Abhishek Kumar Sinha
 *
 */
public class InOrderTransversalStack {
    Node root;

    public void printInOrderTransversal() {
        Stack<Node> stack = new Stack();
        Node curr = root;
        while (curr != null || stack.size() > 0) {
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;

            }
            curr = stack.pop();
            System.out.print(curr.data + " ");
            curr = curr.right;
        }
    }

    public static void main(String[] args) {

        InOrderTransversalStack enf = new InOrderTransversalStack();
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

        enf.printInOrderTransversal();
        /*
         * if (returnValue) { System.out.println("Follows Child Sum Property"); } else {
         * System.out.println("Does Not follows Child Sum Property"); }
         */

    }
}
