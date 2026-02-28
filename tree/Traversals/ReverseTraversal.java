package tree.Traversals;

/**
 * Reverse Traversal means Reverse any order in reverse order
 * 
 * Example:
 * preOrder Original: Root -> Left -> Right
 * preOrder Reverse: Right -> Left -> Root
 * 
 * InOrder Original: Left -> Root -> Right
 * InOrder Reverse: Right -> Root -> Left
 * 
 * postOrder Original: Left -> Right -> Root
 * postOrder Reverse: Root -> Right -> Left
 */
public class ReverseTraversal 
{

    public static void main(String[] args) {
        // Create a sample binary tree
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        // Perform reverse traversals
        System.out.println("Reverse Preorder Traversal:");
        reversePreorder(root);

        System.out.println("\nReverse Inorder Traversal:");
        reverseInorder(root);

        System.out.println("\nReverse Postorder Traversal:");
        reversePostorder(root);
    }

    private static void reversePreorder(TreeNode node) {
        if (node == null)
            return;

        System.out.print(node.val + " ");
        reversePreorder(node.right);
        reversePreorder(node.left);
    }
    
    private static void reverseInorder(TreeNode node) {
        if (node == null)
            return;

        reverseInorder(node.right);
        System.out.print(node.val + " ");
        reverseInorder(node.left);
    }

    private static void reversePostorder(TreeNode node) {
        if (node == null)
            return;

        reversePostorder(node.right);
        reversePostorder(node.left);
        System.out.print(node.val + " ");
    }           

    
}
