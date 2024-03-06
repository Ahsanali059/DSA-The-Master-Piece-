package Arrays.TwoDArrays;

public class searchElement 
{
    public static boolean searchTarget(int matrix[][], int targetElement)
    {
        for(int i=0;i<matrix.length;i++)
        {
            for(int j=0;j<matrix.length;j++)
            {
                if(matrix[i][j]==targetElement)
                {
                    return true;
                }
            }
        }

        return false;
       

    }

    public static void printMatrix(int matrix[][])
    {
        for(int i=0;i<matrix.length;i++)
        {
            for(int j=0;j<matrix[i].length;j++)
            {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) 
    {
        int matrix[][] = {{1,2,3,4},{5,6,7,8},{9,10,11,12}};

        System.out.println(searchTarget(matrix, 1));

        printMatrix(matrix);

        
        
    }
    
}
