package geeksforgeeks.datastructure.tree;

/**
 * @author Abhishek Kumar Sinha
 *
 */
public class ChildrenSumProperty {

    Node root;

    public int childSumProperty(Node root) {
        int leftChildSum = 0, rightChildSum = 0;
        if ((root == null) || (root.left == null && root.right == null)) {
            return 1;
        }
        else {
            if (root.left != null)
                leftChildSum = root.left.data;
            if (root.right != null)
                rightChildSum = root.right.data;
            if (root.data == (leftChildSum + rightChildSum) && childSumProperty(root.left) != 0
                    && childSumProperty(root.left) != 0) {
                return 1;
            }
            else return 0;
        }
    }

    public static void main(String[] args) {
        ChildrenSumProperty csp = new ChildrenSumProperty();
        Node root = new Node(10);
        csp.root = root;
        root.left = new Node(8);
        root.left.left = new Node(3);
        root.left.right = new Node(5);

        root.right = new Node(2);
        root.right.left = new Node(2);
        // root.right.right = new Node(7);

        int returnValue = csp.childSumProperty(root);
        if (returnValue == 1) {
            System.out.println("Follows Child Sum Property");
        }
        else {
            System.out.println("Does Not follows Child Sum Property");
        }

    }

}
