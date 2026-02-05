package Searching.CountOccurrenceInSortedArray.java;

/*
  Time Complexity: O(log n) why ? In each step we are reducing the search 
  space to half.
  Space Complexity: O(1) why ? No extra space is used.
*/
public class findKElements 
{
    public static int kthElementFinder(int arr[],int target)
    {
        int n = arr.length; //size of the array 
        int low = 0;
        int high = n - 1;

        while (low<=high) 
        {
            int mid = low + (high - low) / 2;

            if (arr[mid] == target) 
            {
                return mid; // Target found at index mid
            } 
            else if (arr[mid] < target) 
            {
                low = mid + 1; // Search in the right half
            } 
            else 
            {
                high = mid - 1; // Search in the left half
            }
            
        }
        return -1; // Target not found
    } 


    public static void main(String[] args) 
    {
        int arr[] = {1,2,3,4,5,6,7,8,9}; //sorted array
        int target = 5;
        int result = kthElementFinder(arr, target);

        if (result==-1) 
        {
            System.out.println("Element not found in the array");
        } 
        else 
        {
            System.out.println("Element found at index: " + result);
            
        }

        
    }
    
}
