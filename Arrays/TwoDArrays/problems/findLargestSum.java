package Arrays.TwoDArrays.problems;

// Find the largest sum of any row in a 2D array (matrix)
// input: matrix = {{1,2,3},{4,5,6},{7,8,9}}
// output: 24 (sum of the last row)
// Explanation: The sums of the rows are 6, 15, and 24 respectively. The largest sum is 24.

public class findLargestSum 
{
    public static int largestSum(int matrix[][])
    {
        int maxSum = Integer.MIN_VALUE;

        for(int i=0;i<matrix.length;i++)
        {
            int rowSum = 0;
            for(int j=0;j<matrix[0].length;j++)
            {
                rowSum += matrix[i][j];
            }

            if(rowSum > maxSum)
            {
                maxSum = rowSum;
            }
        }

        return maxSum;
    }
    
}
