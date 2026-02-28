package tree.questions;

/*
  e.g
  Original Tree:
          1
         / \
        2   3
       / \
      4   5

  Mirror Tree:
          1
         / \
        3   2
           / \
          5   4

*/
public class MirrorOfTree {
    public static void main(String[] args) {
        // Create a sample binary tree
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);

        // Mirror the tree
        mirror(root);

        // Print the mirrored tree (preorder traversal)
        System.out.println("Preorder Traversal of Mirrored Tree:");
        preorder(root);
    }

    private static void mirror(Node node) {
        if (node == null) {
            return;
        }

        // Swap left and right children
        Node temp = node.left;
        node.left = node.right;
        node.right = temp;

        // Recursively mirror left and right subtrees
        mirror(node.left);
        mirror(node.right);
    }

    private static void preorder(Node node) {
        if (node == null) {
            return;
        }
        
        System.out.print(node.data + " ");
        preorder(node.left);
        preorder(node.right);
    }
    
    
}
