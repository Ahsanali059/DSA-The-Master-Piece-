package tree.bst;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * Binary Search Tree (BST) Implementation
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

public class BstImpl {
    private TreeNode root;

    public BstImpl() {
        this.root = null;
    }

    // ==================== INSERT OPERATION ====================

    /**
     * Insert a node into BST (Recursive)
     * Time Complexity: O(log n) average, O(n) worst case
     * Space Complexity: O(log n) average, O(n) worst case
     */
    public TreeNode insert(TreeNode root, int data) {
        if (root == null) {
            return new TreeNode(data);
        }

        if (data < root.data) {
            root.left = insert(root.left, data);
        } else if (data > root.data) {
            root.right = insert(root.right, data);
        }
        // If data == root.data, do nothing (no duplicates)

        return root;
    }

    /**
     * Public method to insert into BST
     */
    public void insert(int data) {
        root = insert(root, data);
    }

    // ==================== SEARCH OPERATION ====================

    /**
     * Search for a value in BST (Recursive)
     * Time Complexity: O(log n) average, O(n) worst case
     * Space Complexity: O(log n) average, O(n) worst case
     */
    public boolean search(TreeNode root, int key) {
        if (root == null) {
            return false;
        }

        if (root.data == key) {
            return true;
        } else if (key < root.data) {
            return search(root.left, key);
        } else {
            return search(root.right, key);
        }
    }

    /**
     * Public method to search in BST
     */
    public boolean search(int key) {
        return search(root, key);
    }

    // ==================== DELETE OPERATION ====================

    /**
     * Delete a node from BST
     * Time Complexity: O(log n) average, O(n) worst case
     * Space Complexity: O(log n) average, O(n) worst case
     */
    public TreeNode delete(TreeNode root, int key) {
        if (root == null) {
            return null;
        }

        // Search for the node to delete
        if (key < root.data) {
            root.left = delete(root.left, key);
        } else if (key > root.data) {
            root.right = delete(root.right, key);
        } else {
            // Node to delete found

            // Case 1: Node with no children (leaf node)
            if (root.left == null && root.right == null) {
                return null;
            }

            // Case 2: Node with one child
            if (root.left == null) {
                return root.right;
            }
            if (root.right == null) {
                return root.left;
            }

            // Case 3: Node with two children
            // Find inorder successor (smallest in right subtree)
            TreeNode successor = findMin(root.right);
            root.data = successor.data;
            root.right = delete(root.right, successor.data);
        }

        return root;
    }

    /**
     * Helper method to find minimum value node
     */
    private TreeNode findMin(TreeNode root) {
        while (root.left != null) {
            root = root.left;
        }
        return root;
    }

    /**
     * Public method to delete from BST
     */
    public void delete(int key) {
        root = delete(root, key);
    }

    // ==================== PRINT OPERATIONS ====================

    /**
     * Preorder Traversal (Root -> Left -> Right)
     * Time Complexity: O(n)
     */
    public void preOrder(TreeNode root) {
        if (root == null) {
            return;
        }

        System.out.print(root.data + " ");
        preOrder(root.left);
        preOrder(root.right);
    }

    /**
     * Inorder Traversal (Left -> Root -> Right)
     * For BST, gives sorted order
     * Time Complexity: O(n)
     */
    public void inOrder(TreeNode root) {
        if (root == null) {
            return;
        }

        inOrder(root.left);
        System.out.print(root.data + " ");
        inOrder(root.right);
    }

    /**
     * Postorder Traversal (Left -> Right -> Root)
     * Time Complexity: O(n)
     */
    public void postOrder(TreeNode root) {
        if (root == null) {
            return;
        }

        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.data + " ");
    }

    /**
     * Level Order Traversal (BFS)
     * Time Complexity: O(n)
     */
    public void levelOrder(TreeNode root) {
        if (root == null) {
            return;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

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

    // ==================== PRINT LEFT PART ====================

    /**
     * Print left part of the tree (left subtree of root)
     * Time Complexity: O(n)
     */
    public void printLeftPart(TreeNode root) {
        if (root == null || root.left == null) {
            System.out.println("Left part is empty!");
            return;
        }

        System.out.println("Left Part of Tree (Inorder):");
        inOrder(root.left);
        System.out.println();
    }

    /**
     * Public method to print left part
     */
    public void printLeftPart() {
        printLeftPart(root);
    }

    // ==================== PRINT RIGHT PART ====================

    /**
     * Print right part of the tree (right subtree of root)
     * Time Complexity: O(n)
     */
    public void printRightPart(TreeNode root) {
        if (root == null || root.right == null) {
            System.out.println("Right part is empty!");
            return;
        }

        System.out.println("Right Part of Tree (Inorder):");
        inOrder(root.right);
        System.out.println();
    }

    /**
     * Public method to print right part
     */
    public void printRightPart() {
        printRightPart(root);
    }

    // ==================== GET ROOT ====================

    /**
     * Get root node
     */
    public TreeNode getRoot() {
        return root;
    }

    // ==================== MAIN METHOD ====================

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BstImpl bst = new BstImpl();

        System.out.println("=== Binary Search Tree Implementation ===\n");

        while (true) {
            System.out.println("\n--- BST Operations Menu ---");
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
                    System.out.print("Preorder: ");
                    bst.preOrder(bst.getRoot());
                    System.out.println();
                    break;

                case 5:
                    System.out.print("Inorder (Sorted): ");
                    bst.inOrder(bst.getRoot());
                    System.out.println();
                    break;

                case 6:
                    System.out.print("Postorder: ");
                    bst.postOrder(bst.getRoot());
                    System.out.println();
                    break;

                case 7:
                    System.out.println("Level Order:");
                    bst.levelOrder(bst.getRoot());
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
