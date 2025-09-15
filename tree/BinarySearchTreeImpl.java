package tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Node {
    public int data;
    public Node left;
    public Node right;

    Node(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }
}

public class BinarySearchTreeImpl {

    // Insert node into BST
    public static Node insertBST(Node root, int data) {
        if (root == null) {
            return new Node(data);
        }

        if (data < root.data) {
            root.left = insertBST(root.left, data);
        } else if (data > root.data) {
            root.right = insertBST(root.right, data);
        }

        return root;
    }

    // Build BST interactively
    public static Node buildBST() {
        Scanner sc = new Scanner(System.in);
        Node root = null;

        System.out.println("Enter values to insert into BST (-1 to stop):");

        while (true) {
            int data = sc.nextInt();
            if (data == -1)
                break;

            root = insertBST(root, data);
        }

        return root;
    }

    // Level Order Traversal
    public static void levelOrderTraversal(Node root) {
        if (root == null)
            return;

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int levelSize = queue.size();

            for (int i = 0; i < levelSize; i++) {
                Node current = queue.poll();
                System.out.print(current.data + " ");

                if (current.left != null)
                    queue.add(current.left);
                if (current.right != null)
                    queue.add(current.right);
            }
            System.out.println();
        }
    }

    // Preorder Traversal
    public static void preOrderTraversal(Node root) {
        if (root == null)
            return;

        System.out.print(root.data + " ");
        preOrderTraversal(root.left);
        preOrderTraversal(root.right);
    }

    // Inorder Traversal
    public static void inOrderTraversal(Node root) {
        if (root == null)
            return;

        inOrderTraversal(root.left);
        System.out.print(root.data + " ");
        inOrderTraversal(root.right);
    }

    // Postorder Traversal
    public static void postOrderTraversal(Node root) {
        if (root == null)
            return;

        postOrderTraversal(root.left);
        postOrderTraversal(root.right);
        System.out.print(root.data + " ");
    }

    public static void main(String[] args) {
        Node root = buildBST();

        System.out.println("\nLevel Order Traversal:");
        levelOrderTraversal(root);

        System.out.println("\nPreOrder Traversal:");
        preOrderTraversal(root);

        System.out.println("\nInOrder Traversal:");
        inOrderTraversal(root);

        System.out.println("\nPostOrder Traversal:");
        postOrderTraversal(root);
    }
}

