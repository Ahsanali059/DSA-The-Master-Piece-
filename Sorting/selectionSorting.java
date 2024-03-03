package Sorting;


/*
 * Defination:Selection sorting method select the minimum value 
 * or the maximum value and place in the correct position
 * 
 */
public class selectionSorting 
{
    public static void selectionSort(int []arr)
    {
        for(int i=0;i<arr.length;i++)
        {
            int min = i;
            for(int j=i+1;j<arr.length;j++)
            {
                if(arr[j]<arr[min])
                {
                    min = j;
                }
            }
            int temp = arr[i];
            arr[i] = arr[min];
            arr[min] = temp;
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

        selectionSort(arr);
        
        printArray(arr);
        

        
    }
    
}
