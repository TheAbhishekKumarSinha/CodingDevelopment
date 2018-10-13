package geeksforgeeks.datastructure.tree;

/**
 * @author Abhishek Kumar Sinha
 *
 */
class Nodes {
    int data;
    Nodes left;
    Nodes right;

    /**
     * @param data
     * @param left
     * @param right
     */
    public Nodes(int data) {
        super();
        this.data = data;
        this.left = null;
        this.right = null;
    }
}

public class CountLeafNode {
    Nodes root;

    public int countLeafNode(Nodes root) {
        if (root == null) {
            return 0;
        }
        else if (root.left == null && root.right == null) {
            return 1;
        }
        else {
            int leftCount = countLeafNode(root.left);
            int rightCount = countLeafNode(root.right);
            return leftCount + rightCount;
        }

    }

    public static void main(String[] args) {

        CountLeafNode lvt = new CountLeafNode();
        Nodes root = new Nodes(4);
        lvt.root = root;
        root.left = new Nodes(2);
        root.left.left = new Nodes(1);
        root.left.right = new Nodes(3);

        root.right = new Nodes(6);
        root.right.left = new Nodes(5);
        root.right.right = new Nodes(7);

        System.out.println(lvt.countLeafNode(root));

    }

}
