package geeksforgeeks.datastructure.binarysearchtree;

/**
 * @author Abhishek Kumar Sinha
 *
 */
public class DoubleLinkedList {
    Node head;

    private class Node {
        Node prev;
        Node next;
        int data;

        public Node getPrev() {
            return prev;
        }

        public void setPrev(Node prev) {
            this.prev = prev;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }

        public int getData() {
            return data;
        }

        public void setData(int data) {
            this.data = data;
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
     * @param node
     */
    public void add(geeksforgeeks.datastructure.binarysearchtree.BinaryTree.Node node) {
        Node currentNode = this.head;
        Node n = new Node();
        n.setData(node.data);
        if (this.head == null) {
            this.head = n;
        }
        else {
            while (currentNode.next != null) {
                currentNode = currentNode.next;
            }
            n.prev = currentNode;
            currentNode.next = n;

        }

    }

    public void printForward() {
        Node n = this.head;
        while (n != null) {
            System.out.print(n.data + " ");
            n = n.next;
        }
    }

    public void printBackward() {
        Node n = this.head;

        while (n.next != null) {
            n = n.next;
        }
        while (n != null) {
            System.out.print(n.data + " ");
            n = n.prev;
        }
    }
}
