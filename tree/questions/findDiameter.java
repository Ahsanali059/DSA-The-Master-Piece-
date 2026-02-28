package tree.questions;


// Diameter means the longest path between any two nodes in a tree. The diameter of a tree can be found by calculating the height of the left and right subtrees for each node and keeping track of the maximum diameter found.
// Example:
// Input:
//         1
//        / \
//       2   3
//      / \
//     4   5
// Output: 3
// Explanation: The longest path is 4 -> 2 -> 1 -> 3 or 5 -> 2 -> 1 -> 3, which has a length of 3.
public class findDiameter 
{
    public static int diameter(Node root)
    {
        if(root==null)
        {
            return 0;
        }
        int leftDiameter=diameter(root.left);
        int rightDiameter=diameter(root.right);

        int leftHeight=height(root.left);
        int rightHeight=height(root.right);

        return Math.max(leftHeight+rightHeight, Math.max(leftDiameter, rightDiameter));
    }

    public static int height(Node root)
    {
        if(root==null)
        {
            return 0;
        }
        int leftHeight=height(root.left);
        int rightHeight=height(root.right);

        return Math.max(leftHeight, rightHeight)+1;
    }
    
}
