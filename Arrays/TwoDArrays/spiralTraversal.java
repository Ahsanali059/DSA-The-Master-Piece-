package Arrays.TwoDArrays;

import java.util.ArrayList;
import java.util.List;

public class spiralTraversal 
{
    public static List<Integer> spiralOrder(int[][] matrix) 
    {
        List<Integer> result = new ArrayList<>();

       if(matrix.length==0 || matrix ==null)
       {
           return result;
       }

       int rows = matrix.length;
       int col = matrix[0].length;
       int top=0;
       int left = 0;
       int right = col - 1;
       int bottom = rows - 1;


       while(left<=right && top <=bottom)
       {
           for(int i=left;i<=right;i++)
           {
               result.add(matrix[top][i]);
           }
           top++;

           for(int i=top;i<=bottom;i++)
           {
               result.add(matrix[i][right]);
           }
           right--;


           if(top<=bottom)  // Corrected condition
           {
              for(int i = right;i>=left;i--) // Corrected condition
           {
               result.add(matrix[bottom][i]);
           }
           bottom--;
           }

           if(left<=right)
           {
              for(int i = bottom;i>=top;i--)
           {
               result.add(matrix[i][left]);
           }
           left++;
           }
           

           
       }
       return result;

        
    }
   public static void printMatrix(int matrix[][])
   {
    for(int i=0;i<matrix.length;i++)
    {
        for(int j=0;j<matrix.length;j++)
        {
            System.out.print(matrix[i][j] + " ");
        }
        System.out.println();
   }
        
    
    public static void main(String[] args) 
    {
        int matrix[][] = {
            {1,23,4},
            {4,5,6},
            {8,4,9}
        };

      spiralTraversal.spiralOrder(matrix);  
      printMatrix(matrix);
        

    }
    
}
