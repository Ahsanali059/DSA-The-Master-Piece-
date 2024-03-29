package SearchingAndSorting;



public class gitMinMax 
{
    static class Pair 
{
    int min;
    int max;
}
    public static Pair findMinMax(int[] arr,int low,int high)
    {
        Pair minMax = new Pair();
        Pair mml = new Pair();
        Pair mmr = new Pair();

        int mid = 0;

        //if only one element is present
        if(low==high) {
            minMax.min = arr[low];
            minMax.max = arr[low];
            return minMax;
    
    }
          //if only two elements are present
          if(high==low+1) 
          {
             if(arr[low]>arr[high])
             {
                 minMax.max = arr[low];
                 minMax.min = arr[high];

             }       
             else 
             {
                minMax.max = arr[high];
                minMax.min = arr[low];
             }     
          }

          //if More than two elements are present

          //find middle elements
          int middle = low + (high-low)/2;

           // Compare minimums of two parts
           minMax.min = Math.min(mml.min, mmr.min);

        // Compare maximums of two parts
        minMax.max = Math.max(mml.max, mmr.max);

        return minMax;





    public static void main(String[] args) {
        int[] arr = { 1000, 11, 445, 1, 330, 3000 };
        int arr_size = 6;
        Pair minmax = findMinMax(arr, 0, arr_size - 1);
        System.out.println("Minimum element is " + minmax.min);
        System.out.println("Maximum element is " + minmax.max);
    }
    
}
