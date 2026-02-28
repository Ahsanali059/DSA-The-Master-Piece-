package tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BinaryTree 
{
    // Create Tree (Recursive)
    public static Node createTree(Scanner sc) {

        int data = sc.nextInt();

        // Base condition
        if (data == -1) {
            return null;
        }

        Node root = new Node(data);

        System.out.println("Enter data for inserting in left of " + data);
        root.left = createTree(sc);

        System.out.println("Enter data for inserting in right of " + data);
        root.right = createTree(sc);

        return root;
    }

    // Level Order Traversal (BFS)
    public static void levelOrderTraversal(Node root) {

        if (root == null)
            return;

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {

            int levelSize = queue.size();

            for (int i = 0; i < levelSize; i++) {

                Node currentNode = queue.poll();
                System.out.print(currentNode.data + " ");

                if (currentNode.left != null) {
                    queue.add(currentNode.left);
                }

                if (currentNode.right != null) {
                    queue.add(currentNode.right);
                }
            }

            System.out.println(); // For level-wise printing
        }
    }

    // InOrder Traversal (Left, Root, Right)
    public static void inOrderTraversal(Node root) {
        if (root == null)
            return;

        inOrderTraversal(root.left);
        System.out.print(root.data + " ");
        inOrderTraversal(root.right);
    }

    // PreOrder Traversal (Root, Left, Right)
    public static void preOrderTraversal(Node root) {
        if (root == null)
            return;

        System.out.print(root.data + " ");
        preOrderTraversal(root.left);
        preOrderTraversal(root.right);
    }

    // PostOrder Traversal (Left, Right, Root)
    public static void postOrderTraversal(Node root) {
        if (root == null)
            return;

        postOrderTraversal(root.left);
        postOrderTraversal(root.right);
        System.out.print(root.data + " ");
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter root data (-1 for null): ");
        Node root = createTree(sc);

        System.out.println("\nLevel Order Traversal:");
        levelOrderTraversal(root);

        System.out.println("\nPreOrder Traversal:");
        preOrderTraversal(root);

        System.out.println("\n\nInOrder Traversal:");
        inOrderTraversal(root);

        System.out.println("\n\nPostOrder Traversal:");
        postOrderTraversal(root);

        sc.close();
    }
}