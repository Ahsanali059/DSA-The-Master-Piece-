package Sorting;

/*
 * Time Complexity ->O(n^2)
 * space complexity ->O(1)
 * 
 * 
 * 
 */



public class insertionSort 
{
    public static void insertionSort(int []arr)
    {
        for(int i=1;i<arr.length;i++)
        {
            int key = arr[i];
            int j = i-1;
            while(j>=0 && arr[j]>key)
            {
                arr[j+1] = arr[j];
                j--;
            }
            arr[j+1] = key;
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

    public static void main(String[] args) {
        int arr[] = {10,4,1,7,8,9};

        insertionSort(arr);

        printArray(arr);
    }
    
}
