package Arrays.TwoDArrays;

public class twoDMatrix 
{
    public static void main(String[] args) 
    {
        //create 2d matric 
        int matrix[][] = {{12,3,4,12},{12,34,5}};

        //iterate this matrix
        for(int i=0;i<matrix.length;i++)
        {
            for(int j=0;j<matrix[i].length;j++)
            {
                System.out.print(matrix[i][j]+" ");
            }

            System.out.println();
        }
        
    }
    
}
