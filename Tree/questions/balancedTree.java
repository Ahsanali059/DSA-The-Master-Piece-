package Tree.questions;



class Node
{
    public int data;
    public Node left;
    public Node right;


    public Node(int data)
    {
        this.data=data;
        this.left=null;
        this.right=null;
    }


}


public static boolean isBalanced(Node root)
{
    if(root==null)
       return true;

    
    boolean leftHeight = findHeight(root.left);
    boolean rightHeight = findHeight(root.right);
    
    boolean diff = Math.abs(findHeight(root.left)-findHeight(root.right))<=1;

    if(leftHeight&&rightHeight&&diff)
    {
           return true;
    }
    else 
    {
        return false;
    }
}
public class balancedTree 
{

    
}
