package tree.questions;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
    example:

            1
           / \
          2   4
         / \
        3   0
    diagonal traversal = [[1, 4], [2, 0], [3]]
    Time complexity: O(n) where n is the number of nodes in the tree, as we visit each node once.
    Space complexity: O(n) in the worst case, when the tree is completely unbalanced

        */
public class diagonalTraversal {

    public List<List<Integer>> diagonal(Node root) {

        List<List<Integer>> result = new ArrayList<>();

        if (root == null)
            return result;

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {

            int size = queue.size();
            List<Integer> diagonal = new ArrayList<>();

            while (size-- > 0) {

                Node curr = queue.poll();

                // Traverse all right nodes (same diagonal)
                while (curr != null) {

                    diagonal.add(curr.data);

                    // If left child exists, push to queue
                    if (curr.left != null) {
                        queue.add(curr.left);
                    }

                    // Move to right (same diagonal)
                    curr = curr.right;
                }
            }

            result.add(diagonal);
        }

        return result;
    }

    // Test
    public static void main(String[] args) {

        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(4);
        root.left.left = new Node(3);
        root.left.right = new Node(0);

        diagonalTraversal obj = new diagonalTraversal();
        System.out.println(obj.diagonal(root));
    }
}

