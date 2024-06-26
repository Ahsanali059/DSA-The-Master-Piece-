package tree.questions;

public class invertBinaryTree 
{
    public static Node invertTree(Node root)
    {
        if(root==null)
             return null;
        
        Node left = invertTree(root.left);
        Node right = invertTree(root.right);
        
        root.left=right;
        root.right=left;

        return root;
    }
    
}
