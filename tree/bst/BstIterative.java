package tree.bst;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

/**
 * Binary Search Tree (BST) Implementation - Iterative Approach
 * All operations implemented using iterative methods (no recursion)
 * Essential Operations: Insert, Search, Delete, Print, Print Left Part, Print Right Part
 */
class TreeNode {
    int data;
    TreeNode left;
    TreeNode right;

    TreeNode(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }
}

public class BstIterative {
    private TreeNode root;

    public BstIterative() {
        this.root = null;
    }

    // ==================== INSERT OPERATION (ITERATIVE) ====================

    /**
     * Insert a node into BST (Iterative)
     * Time Complexity: O(log n) average, O(n) worst case
     * Space Complexity: O(1)
     */
    public void insert(int data) {
        TreeNode newNode = new TreeNode(data);

        if (root == null) {
            root = newNode;
            return;
        }

        TreeNode current = root;
        TreeNode parent = null;

        while (current != null) {
            parent = current;
            if (data < current.data) {
                current = current.left;
            } else if (data > current.data) {
                current = current.right;
            } else {
                // Duplicate value, do nothing
                return;
            }
        }

        // Insert at the appropriate position
        if (data < parent.data) {
            parent.left = newNode;
        } else {
            parent.right = newNode;
        }
    }

    // ==================== SEARCH OPERATION (ITERATIVE) ====================

    /**
     * Search for a value in BST (Iterative)
     * Time Complexity: O(log n) average, O(n) worst case
     * Space Complexity: O(1)
     */
    public boolean search(int key) {
        TreeNode current = root;

        while (current != null) {
            if (current.data == key) {
                return true;
            } else if (key < current.data) {
                current = current.left;
            } else {
                current = current.right;
            }
        }

        return false;
    }

    // ==================== DELETE OPERATION (ITERATIVE) ====================

    /**
     * Delete a node from BST (Iterative)
     * Time Complexity: O(log n) average, O(n) worst case
     * Space Complexity: O(1)
     */
    public void delete(int key) {
        TreeNode current = root;
        TreeNode parent = null;

        // Find the node to delete and its parent
        while (current != null && current.data != key) {
            parent = current;
            if (key < current.data) {
                current = current.left;
            } else {
                current = current.right;
            }
        }

        // Node not found
        if (current == null) {
            return;
        }

        // Case 1: Node with no children (leaf node)
        if (current.left == null && current.right == null) {
            if (parent == null) {
                // Deleting root node
                root = null;
            } else if (parent.left == current) {
                parent.left = null;
            } else {
                parent.right = null;
            }
            return;
        }

        // Case 2: Node with one child
        if (current.left == null) {
            // Node has only right child
            if (parent == null) {
                root = current.right;
            } else if (parent.left == current) {
                parent.left = current.right;
            } else {
                parent.right = current.right;
            }
            return;
        }

        if (current.right == null) {
            // Node has only left child
            if (parent == null) {
                root = current.left;
            } else if (parent.left == current) {
                parent.left = current.left;
            } else {
                parent.right = current.left;
            }
            return;
        }

        // Case 3: Node with two children
        // Find inorder successor (smallest in right subtree)
        TreeNode successor = current.right;
        TreeNode successorParent = current;

        while (successor.left != null) {
            successorParent = successor;
            successor = successor.left;
        }

        // Replace current node's data with successor's data
        current.data = successor.data;

        // Delete the successor node
        if (successorParent.left == successor) {
            successorParent.left = successor.right;
        } else {
            successorParent.right = successor.right;
        }
    }

    // ==================== PRINT OPERATIONS (ITERATIVE) ====================

    /**
     * Preorder Traversal (Root -> Left -> Right) - Iterative using Stack
     * Time Complexity: O(n)
     * Space Complexity: O(h) where h is height
     */
    public void preOrder() {
        if (root == null) {
            System.out.println("Tree is empty!");
            return;
        }

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        System.out.print("Preorder: ");
        while (!stack.isEmpty()) {
            TreeNode current = stack.pop();
            System.out.print(current.data + " ");

            // Push right first, then left (so left is processed first)
            if (current.right != null) {
                stack.push(current.right);
            }
            if (current.left != null) {
                stack.push(current.left);
            }
        }
        System.out.println();
    }

    /**
     * Inorder Traversal (Left -> Root -> Right) - Iterative using Stack
     * For BST, gives sorted order
     * Time Complexity: O(n)
     * Space Complexity: O(h)
     */
    public void inOrder() {
        if (root == null) {
            System.out.println("Tree is empty!");
            return;
        }

        Stack<TreeNode> stack = new Stack<>();
        TreeNode current = root;

        System.out.print("Inorder (Sorted): ");
        while (current != null || !stack.isEmpty()) {
            // Go to the leftmost node
            while (current != null) {
                stack.push(current);
                current = current.left;
            }

            // Process the node
            current = stack.pop();
            System.out.print(current.data + " ");

            // Move to right subtree
            current = current.right;
        }
        System.out.println();
    }

    /**
     * Postorder Traversal (Left -> Right -> Root) - Iterative using Stack
     * Time Complexity: O(n)
     * Space Complexity: O(h)
     */
    public void postOrder() {
        if (root == null) {
            System.out.println("Tree is empty!");
            return;
        }

        Stack<TreeNode> stack1 = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();
        stack1.push(root);

        // First stack: process nodes in reverse postorder
        while (!stack1.isEmpty()) {
            TreeNode current = stack1.pop();
            stack2.push(current);

            if (current.left != null) {
                stack1.push(current.left);
            }
            if (current.right != null) {
                stack1.push(current.right);
            }
        }

        // Second stack: print in postorder
        System.out.print("Postorder: ");
        while (!stack2.isEmpty()) {
            System.out.print(stack2.pop().data + " ");
        }
        System.out.println();
    }

    /**
     * Level Order Traversal (BFS) - Iterative using Queue
     * Time Complexity: O(n)
     * Space Complexity: O(w) where w is maximum width
     */
    public void levelOrder() {
        if (root == null) {
            System.out.println("Tree is empty!");
            return;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        System.out.println("Level Order:");
        while (!queue.isEmpty()) {
            int levelSize = queue.size();

            for (int i = 0; i < levelSize; i++) {
                TreeNode current = queue.poll();
                System.out.print(current.data + " ");

                if (current.left != null) {
                    queue.add(current.left);
                }
                if (current.right != null) {
                    queue.add(current.right);
                }
            }
            System.out.println();
        }
    }

    // ==================== PRINT LEFT PART (ITERATIVE) ====================

    /**
     * Print left part of the tree (left subtree of root) - Iterative
     * Time Complexity: O(n)
     */
    public void printLeftPart() {
        if (root == null || root.left == null) {
            System.out.println("Left part is empty!");
            return;
        }

        Stack<TreeNode> stack = new Stack<>();
        TreeNode current = root.left;

        System.out.print("Left Part of Tree (Inorder): ");
        while (current != null || !stack.isEmpty()) {
            while (current != null) {
                stack.push(current);
                current = current.left;
            }

            current = stack.pop();
            System.out.print(current.data + " ");
            current = current.right;
        }
        System.out.println();
    }

    // ==================== PRINT RIGHT PART (ITERATIVE) ====================

    /**
     * Print right part of the tree (right subtree of root) - Iterative
     * Time Complexity: O(n)
     */
    public void printRightPart() {
        if (root == null || root.right == null) {
            System.out.println("Right part is empty!");
            return;
        }

        Stack<TreeNode> stack = new Stack<>();
        TreeNode current = root.right;

        System.out.print("Right Part of Tree (Inorder): ");
        while (current != null || !stack.isEmpty()) {
            while (current != null) {
                stack.push(current);
                current = current.left;
            }

            current = stack.pop();
            System.out.print(current.data + " ");
            current = current.right;
        }
        System.out.println();
    }

    // ==================== MAIN METHOD ====================

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BstIterative bst = new BstIterative();

        System.out.println("=== Binary Search Tree Implementation (Iterative) ===\n");

        while (true) {
            System.out.println("\n--- BST Operations Menu (All Iterative) ---");
            System.out.println("1. Insert");
            System.out.println("2. Search");
            System.out.println("3. Delete");
            System.out.println("4. Preorder Traversal");
            System.out.println("5. Inorder Traversal");
            System.out.println("6. Postorder Traversal");
            System.out.println("7. Level Order Traversal");
            System.out.println("8. Print Left Part");
            System.out.println("9. Print Right Part");
            System.out.println("0. Exit");

            System.out.print("\nEnter your choice: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter value to insert: ");
                    int insertVal = sc.nextInt();
                    bst.insert(insertVal);
                    System.out.println("Value " + insertVal + " inserted successfully!");
                    break;

                case 2:
                    System.out.print("Enter value to search: ");
                    int searchVal = sc.nextInt();
                    boolean found = bst.search(searchVal);
                    System.out.println(found ? "Value found!" : "Value not found!");
                    break;

                case 3:
                    System.out.print("Enter value to delete: ");
                    int deleteVal = sc.nextInt();
                    bst.delete(deleteVal);
                    System.out.println("Value " + deleteVal + " deleted (if existed)!");
                    break;

                case 4:
                    bst.preOrder();
                    break;

                case 5:
                    bst.inOrder();
                    break;

                case 6:
                    bst.postOrder();
                    break;

                case 7:
                    bst.levelOrder();
                    break;

                case 8:
                    bst.printLeftPart();
                    break;

                case 9:
                    bst.printRightPart();
                    break;

                case 0:
                    System.out.println("Exiting...");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        }
    }
}
