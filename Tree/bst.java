package Tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Node
{
    public int data;
    public Node left;
    public Node right;


   Node(int data)
   {
      this.data = data;
      this.left = null;
      this.right = null;
   } 

}




public class bst 
{
    public static void levelOrderTraversal(Node root) {
        if (root == null)
            return;

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int levelSize = queue.size();

            for (int i = 0; i < levelSize; i++) {
                Node current = queue.poll();
                System.out.print("Current Element " + current.data + " ");

                if (current.left != null)
                    queue.add(current.left);
                if (current.right != null)
                    queue.add(current.right);
            }
            System.out.println(); // Move to the next line after printing each level
        }
    }

    //visit Node first time
    public static void preOrderTraversal(Node root)
    {
        if(root==null)
           return;

        System.out.print(root.data+" ");
        preOrderTraversal(root.left);
        preOrderTraversal(root.right);

    }
    //visit to Node in second time  

    public static void inOrderTraversal(Node root)
    {
        if(root==null)
            return;
        
        inOrderTraversal(root.left);
        System.out.print(root.data+" ");
        inOrderTraversal(root.right);
    }

    //visit node third time 

    public static void postOrderTraversal(Node root)
    {
        if(root==null)
           return;
           
        postOrderTraversal(root.left);
        postOrderTraversal(root.right);
        System.out.print(root.data+" ");

    }

    //build tree
    public static Node buildTree(Node root)
    {
        System.out.println("Enter the data ");

        Scanner sc = new Scanner(System.in);
        int data = sc.nextInt();

        root = new Node(data);

        if(data==-1)
        {
            return null;
        }

        System.out.println("Enter data for inserting in Left");

        root.left = buildTree(root.left);

        System.out.println("Enter data for inserting in right");
        root.right = buildTree(root.right);

        return root;
    }



    public static void main(String[] args) 
    {
        Node root = null;

        root = bst.buildTree(root);
        levelOrderTraversal(root);


        System.out.println("preOrder Traversal");
        bst.preOrderTraversal(root);


        System.out.println("InOrder Traversal");
        bst.inOrderTraversal(root);

        System.out.println("postOrder Traversal");
        bst.postOrderTraversal(root);

        
    }
    
}
