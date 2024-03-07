package Arrays.TwoDArrays;

public class rotateMatrix 
{
    public static void rotate(int[][] matrix)
    {
        if(matrix.length==0 || matrix ==null || matrix.length!=matrix[0].length)
        {
            System.out.println("Invalid matrix");
            return;
        }

         
        int n = matrix.length;

        //Transpose the matrix

        for(int i=0;i<n;i++)
        {
            for(int j=i;j<n;j++)
            {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        //Reverse the matrix

        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n/2;j++)
            {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][n-j-1];
                matrix[i][n-j-1] = temp;
            }

        }



    }
    public static void main(String[] args) 
    {

        
    }
    
}
