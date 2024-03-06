package Arrays.TwoDArrays;

import java.util.Arrays;

public class medianFinder 
{
    public static int findMedian(int metric[][])
    {
        int rows = metric.length;
        int col = metric[0].length;

        int flattern[] = new int[rows*col];

        int index = 0;
        for(int row[]:metric)
        {
            for(int element:row)
            {
                flattern[index++] = element;
            }

        }

        Arrays.sort(flattern);

        int mid = flattern.length/2;

        if(flattern.length%2 == 0)
        {
            //even numbers
            return (flattern[mid-1] + flattern[mid]) /2;
        }
        else 
        {
            //if odd numbers return simple middle
            return flattern[mid];
        }
    }
    public static void main(String[] args) 
    {
          int matrix[][] = {{1,2,3,4},{5,6,7,8}};

          System.err.println(findMedian(matrix));
        
    }
    
}
