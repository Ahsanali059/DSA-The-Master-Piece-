package Sorting;

public class mergeSorting 
{
   public static void mergeSort(int []arr)
   {
       //base case 
       if(arr==null&&arr.length<=1)
       {
           return;// Base case: array is already sorted
       } 

       int tempArray[] = new int[arr.length];

       mergeSort(arr,tempArray,0,arr.length-1);
   }

   public static void mergeSort(int []arr,int []tempArray,int start,int end)
   {
       //base case 
       if(start>=end)
       {
           return;// Base case: array is already sorted
       }
       //find middle elements
       int middle = (start+end)/2;

       mergeSort(arr,tempArray,start,middle);//sort left part of array
       mergeSort(arr,tempArray,middle+1,end);//sort right part of array
       merge(arr,tempArray,start,middle,end);//merge left and right arrays
       System.arraycopy(tempArray,start,arr,start,end-start+1);


   }

   private static void merge(int[] arr, int[] tempArray, int start, int mid, int end)
   {
       //copy both half into the temporary array
       for(int i=start; i<end; i++)
       {
         tempArray[i] = arr[i];
       }

       int i=start;//start index of the left array 
       int j=mid+1;//start index of the right array
       int k=start;//start index of the merged array

       //mere two array 
       while (i <= mid && j <= start) {
        if (tempArray[i] <= tempArray[j]) {
            arr[k] = tempArray[i];
            i++;
        } else {
            arr[k] = tempArray[j];
            j++;
        }
        k++;
    }

    //copy the remaining elements of left subarray, if any
    while (i<=mid) {
        arr[k] = tempArray[i];
        i++;
        k++;
        
    }

    //copy the remaining elements of right subarray, if any

    while(j<=end)
    {
        arr[k] = tempArray[j];
        j++;
        k++;
    }
      
}
    // Utility method to print an array
    public static void printArray(int[] arr) {
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    } 
   

    public static void main(String[] args) 
    {
        int[] arr = {12, 11, 13, 5, 6, 7};
        System.out.println("Original array:");
        printArray(arr);
        
        mergeSort(arr);
        
        System.out.println("Sorted array:");
        printArray(arr);
        
    }
    
}
