package tree.questions;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Node 
{
    Node left;
    Node right;
    int data;

    Node(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }
}

public class treeLeftView 
{
    public List<Integer> leftView(Node root)
    {
        List<Integer> result = new ArrayList<>();
        if(root == null)
        {
            return result;
        }

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);


        
        while(!queue.isEmpty())
        {
            int size = queue.size();
            boolean firstNodeEncountered = true; 
            // Flag to track the first node encountered at each level

            for(int i = 0; i < size; i++)
            {
                Node curr = queue.poll();

                if(firstNodeEncountered)
                {
                    result.add(curr.data);
                    firstNodeEncountered = false;
                }

                if(curr.left !=null)
                {
                    queue.offer(curr.left);
                }
                if(curr.right !=null)
                {
                    queue.offer(curr.right);
                }
            }
        }
        return result;
    }

    public static void main(String[] args) 
    {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(4);
        root.left.left = new Node(3);
        root.left.right = new Node(0);

        List<Integer> result = new treeLeftView().leftView(root);
        
        // Print the left view of the tree
        System.out.println("Left view of the tree: " + result);
    }    
}
