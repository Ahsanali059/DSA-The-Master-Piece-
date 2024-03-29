package Tree.questions;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class rightView 
{
    List list = new ArrayList<>();
    public List<Integer> rightSideView(Node root) 
    {
       //base case 
       if(root==null)
       {
         return list; 
       }

       Deque<Node> deque = new LinkedList<Node>();
       deque.add(root);

       while(deque.size()>0)
       {
           int size = deque.size();
           list.add(deque.peek().val);//add right part 

           while(size > 0 )
           {
              Node node = deque.poll();
              if(node.right!=null)
              {
                deque.add(node.right);
              }
              if(node.left!=null)
              {
                deque.add(node.left);
              }

              size--;
           }


       } 

       return list;
        
    }
}
