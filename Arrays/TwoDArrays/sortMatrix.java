package Arrays.TwoDArrays;

import java.util.PriorityQueue;

public class sortMatrix 
{
    public static void printMatrix(int[][] matrix)
    {
        int rows = matrix.length;
        int col = matrix[0].length;

        PriorityQueue<Integer> result = new PriorityQueue<>();

        for(int i = 0; i < rows; i++)
        {
            for(int j=0;j<col; j++)
            {
                result.add(matrix[i][j]);

            }
        }
        
        //print 
        while(!result.isEmpty())
        {
            System.out.print(result.poll()+" ");
        }
    }
    public static void main(String[] args) 
    {

        int[][] matrix = {
            {1, 3, 5},
            {2, 4, 7},
            {6, 8, 9}
        };

        System.out.println("Elements in sorted order:");
        printMatrix(matrix);
        
    }
    
}
