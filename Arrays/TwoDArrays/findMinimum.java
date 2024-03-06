package Arrays.TwoDArrays;

public class findMinimum 
{

    public static int findMinimum(int matric[][])
    {
        int min = matric[0][0];

        for(int i=0;i<matric.length;i++)
        {
            for(int j=0;j<matric.length;j++)
            {
                if(matric[i][j]<min)
                {
                    min = matric[i][j];
                }
            }
        }

        return min;
    }
    public static void main(String[] args) 
    {
        int matric[][] = {{1,23,56},{12,3,4}};
        
        int minimum = findMinimum(matric);


        System.out.println("Minimum: " + minimum);
        
    }
    
}
