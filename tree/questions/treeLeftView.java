package tree.questions;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Node {
    Node left;
    Node right;
    int data;

    Node(int data) {
        this.data = data;
    }
}

public class TreeLeftView {

    public List<Integer> leftView(Node root) {

        List<Integer> result = new ArrayList<>();

        if (root == null)
            return result;

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {

            int size = queue.size();

            for (int i = 0; i < size; i++) {

                Node curr = queue.poll();

                // First node at each level = Left View
                if (i == 0) {
                    result.add(curr.data);
                }

                if (curr.left != null)
                    queue.add(curr.left);

                if (curr.right != null)
                    queue.add(curr.right);
            }
        }

        return result;
    }

    public static void main(String[] args) {

        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(4);
        root.left.left = new Node(3);
        root.left.right = new Node(0);

        List<Integer> result = new TreeLeftView().leftView(root);

        System.out.println("Left view of the tree: " + result);
    }
}