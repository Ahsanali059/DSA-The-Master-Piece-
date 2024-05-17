package tree.questions;



class Node
{
    int data;
    public Node left;
    public Node right;


    Node(int data)
    {
        this.data=data;
        this.left=null;
        this.right=null;
    }
}

public class bstHeight 
{
    public static int findHeight(Node root)
    {
        if(root==null)
        {
            return -1;
        }

        int leftHeight = findHeight(root.left);
        int rightHeight = findHeight(root.right);



        return Math.max(leftHeight, rightHeight)+1;
    }

    public int findDimeter(Node root)
    {
        if(root==null)
        {
            return 0;
        }


        int op1 = findDimeter(root.left);
        int op2 = findDimeter(root.right);

        int op3 = findHeight(root.left) + findHeight(root.right)+1;


        return Math.max(op1,Math.max(op2, op3));
    }



    public static void main(String[] args) 
    {

        
    }
    
}
