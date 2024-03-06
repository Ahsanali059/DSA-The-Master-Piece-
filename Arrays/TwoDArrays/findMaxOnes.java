package Arrays.TwoDArrays;

public class findMaxOnes 
{
    public static int findMax(int matrix[][])
    {
        int maxRow = 0; // Start with the first row
        int maxCount = 0;
    
        for (int i = 0; i < matrix.length; i++) {
            int count = findCount(matrix[i]);
    
            if (count > maxCount) {
                maxCount = count;
                maxRow = i;
            }
        }
        return maxRow;

    }

    public static int findCount(int arr[])
    {
        int count = 0;
        for(int element:arr)
        {
            if(element==1)
            {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) 
    {
        int[][] matrix = {
            {0, 0, 1, 1, 1},
            {0, 1, 1, 1, 1},
            {0, 0, 0, 1, 1},
            {0, 0, 1, 1, 1},
            {1, 1, 1, 1, 1}
        };

        int maxOnesRow = findMax(matrix);
        System.out.println("Row with maximum number of 1's: " + maxOnesRow);
        
    }
    
}
