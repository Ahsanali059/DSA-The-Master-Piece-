package tree.questions;

class Node {
    int data;
    Node left;
    Node right;

    public Node(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }
}

public class BalancedTree {

    // Function to check if tree is balanced
    public static boolean isBalanced(Node root) {
        if (root == null)
            return true;

        int leftHeight = findHeight(root.left);
        int rightHeight = findHeight(root.right);

        if (Math.abs(leftHeight - rightHeight) > 1)
            return false;

        return isBalanced(root.left) && isBalanced(root.right);
    }

    // Function to calculate height
    private static int findHeight(Node root) {
        if (root == null)
            return 0;

        return 1 + Math.max(findHeight(root.left), findHeight(root.right));
    }

    // Testing
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);

        System.out.println(isBalanced(root)); // true
    }
}
