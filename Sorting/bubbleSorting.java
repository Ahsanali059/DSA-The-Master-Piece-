package Sorting;



/*
 * time Complixity 
 *        O(N^2) time
 * space Complicity is
 *        O(1)
 * 
 */
public class bubbleSorting 
{
    public static void bubbleSort(int []arr)
    {
        for(int i=0;i<arr.length;i++)
        {
            for(int j=0;j<arr.length-i-1;j++)
            {
                if(arr[j]>arr[j+1])
                {
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
    }
    
    public static void printArray(int[] arr)
    {
        for(int i=0;i<arr.length;i++)
        {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }


    public static void main(String[] args) 
    {
        int arr[] = {10,4,1,7,8,9};

        bubbleSort(arr);

        printArray(arr);

        
    }
    
}
