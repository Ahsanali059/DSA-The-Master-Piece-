package tree.questions;

import java.util.*;

/*
    example:

            1
           / \
          2   3
         / \   \
        4   5   6
    zigzag level order traversal = [[1], [3, 2], [4, 5, 6]]

    Time complexity: O(n) where n is the number of nodes in the tree, as we visit each node once.
    Space complexity: O(n) in the worst case, when the tree is completely unbalanced
*/
public class zigzagTraversal {

    static class Node {
        int data;
        Node left, right;

        Node(int data) {
            this.data = data;
        }
    }

    public static List<List<Integer>> zigzagLevelOrder(Node root) {

        List<List<Integer>> result = new ArrayList<>();

        if (root == null)
            return result;

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        boolean leftToRight = true;

        while (!queue.isEmpty()) {

            int size = queue.size();
            LinkedList<Integer> level = new LinkedList<>();

            for (int i = 0; i < size; i++) {

                Node node = queue.poll();

                // addFirst for right to left, 
                // addLast for left to right

                if (leftToRight)
                    level.addLast(node.data);
                else
                    level.addFirst(node.data);

                if (node.left != null)
                    queue.add(node.left);

                if (node.right != null)
                    queue.add(node.right);
            }

            result.add(level);
            leftToRight = !leftToRight; // flip direction
        }

        return result;
    }
}