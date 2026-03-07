package tree.questions;

import java.util.*;


/*
 What is Boundary Traversal of a Binary Tree?
 Boundary Traversal of a binary tree is a traversal method 
 that visits the nodes of the tree in a specific order:
 1. Start with the root node.
    2. Traverse the left boundary of the tree (excluding leaf nodes).
    3. Traverse all the leaf nodes from left to right.
    4. Traverse the right boundary of the tree (excluding leaf nodes) in reverse order.
    The result is a list of node values that represent the boundary traversal of the binary tree.
    Example:
    Consider the following binary tree:
            1
           / \
          2   3
         / \   \
        4   5   6
       /         \
      7           8
    The boundary traversal of this tree would be: [1, 2, 4, 7, 5, 6, 8, 3]
*/
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    
    TreeNode(int val) {
        this.val = val;
    }
}

public class BoundaryTraversal {
    
    public static List<Integer> boundaryTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        
        if (root == null) return result;
        
        // Add root
        result.add(root.val);
        
        // Add left boundary (excluding leaf)
        addLeftBoundary(root.left, result);
        
        // Add leaves
        addLeaves(root.left, result);
        addLeaves(root.right, result);
        
        // Add right boundary (excluding leaf, in reverse)
        addRightBoundary(root.right, result);
        
        return result;
    }
    
    private static void addLeftBoundary(TreeNode node, List<Integer> result) {
        while (node != null) {
            if (!isLeaf(node)) result.add(node.val);
            node = (node.left != null) ? node.left : node.right;
        }
    }
    
    private static void addRightBoundary(TreeNode node, List<Integer> result) {
        List<Integer> temp = new ArrayList<>();
        while (node != null) {
            if (!isLeaf(node)) temp.add(node.val);
            node = (node.right != null) ? node.right : node.left;
        }
        Collections.reverse(temp);
        result.addAll(temp);
    }
    
    private static void addLeaves(TreeNode node, List<Integer> result) {
        if (node == null) return;
        if (isLeaf(node)) {
            result.add(node.val);
            return;
        }
        addLeaves(node.left, result);
        addLeaves(node.right, result);
    }
    
    private static boolean isLeaf(TreeNode node) {
        return node.left == null && node.right == null;
    }
}