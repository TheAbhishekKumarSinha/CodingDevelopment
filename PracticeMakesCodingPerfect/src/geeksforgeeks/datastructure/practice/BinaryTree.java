package geeksforgeeks.datastructure.practice;

//Recursive Java program for level order traversal of Binary Tree

/* Class containing left and right child of current 
Nodes and key value*/
class Nodes
{
 int data;
 Nodes left, right;
 public Nodes(int item)
 {
     data = item;
     left = right = null;
 }
}

public class BinaryTree
{
 // Root of the Binary Tree
 Nodes root;

 public BinaryTree()
 {
     root = null;
 }

 /* function to print level order traversal of tree*/
 void printLevelOrder()
 {
     int h = height(root);
     int i;
     for (i=1; i<=h; i++)
         printGivenLevel(root, i);
 }

 /* Compute the "height" of a tree -- the number of
 nodes along the longest path from the root node
 down to the farthest leaf node.*/
 int height(Nodes root)
 {
     if (root == null)
        return 0;
     else
     {
         /* compute  height of each subtree */
         int lheight = height(root.left);
         int rheight = height(root.right);
          
         /* use the larger one */
         if (lheight > rheight)
             return(lheight+1);
         else return(rheight+1); 
     }
 }

 /* Print Nodess at the given level */
 void printGivenLevel (Nodes root ,int level)
 {
     if (root == null)
         return;
     if (level == 1)
         System.out.print(root.data + " ");
     else if (level > 1)
     {
         printGivenLevel(root.left, level-1);
         printGivenLevel(root.right, level-1);
     }
 }
  
 /* Driver program to test above functions */
 public static void main(String args[])
 {
    BinaryTree tree = new BinaryTree();
    tree.root= new Nodes(1);
    tree.root.left= new Nodes(2);
    tree.root.right= new Nodes(3);
    tree.root.left.left= new Nodes(4);
    tree.root.left.right= new Nodes(5);
     
    System.out.println("Level order traversal of binary tree is ");
    tree.printLevelOrder();
 }
}