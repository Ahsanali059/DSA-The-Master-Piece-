package tree.questions;

/*
    example:

            1
           / \
          2   3
         / \   \
        4   5
    binary tree to doubly linked list = 4 <-> 2 <-> 5 <-> 1 <-> 3
    Time complexity: O(n) where n is the number of nodes in the tree, as we visit each node once.
    Space complexity: O(n) in the worst case, when the tree is completely unbalanced
*/

public class BinaryTreeToDoublyLinkedList 
{
        static class Node {
            int data;
            Node left, right;
    
            Node(int data) {
                this.data = data;
            }
        }
    
        public static Node bToDLL(Node root) {
    
            if (root == null)
                return null;
    
            // Convert left subtree and link to root
            if (root.left != null) {
                Node left = bToDLL(root.left);
    
                // Find the rightmost node in left subtree
                while (left.right != null)
                    left = left.right;
    
                // Link the rightmost node of left subtree to root
                left.right = root;
                root.left = left;
            }
    
            // Convert right subtree and link to root
            if (root.right != null) {
                Node right = bToDLL(root.right);
    
                // Find the leftmost node in right subtree
                while (right.left != null)
                    right = right.left;
    
                // Link the leftmost node of right subtree to root
                right.left = root;
                root.right = right;
            }
    
            return root; // Return the head of the DLL
        }

    
}
