package Searching.BSProblems;

/**
    What is upper Bound ?
        Upper Bound of a target in a sorted array is the index of the 
        first element that is greater than the target.
        If all elements in the array are less than or equal to the target, then the 
        upper bound is the length of the array.
        Time Complexity: O(log n) why ? In each step we are reducing the search 
        space to half.
        Space Complexity: O(1) why ? No extra space is used.
        Example:
        Input: arr[] = {1,2,3,4,5,6,7,8,9}, target = 5
        Output: 5 (index of first element greater than 5)
        
 */
public class upparBound 
{
    public static int upperBoundFinder(int arr[],int target)
    {
        int n = arr.length; //size of the array 
        int low = 0;
        int high = n;

        while (low<high) 
        {
            int mid = low + (high - low) / 2;

            if (arr[mid] <= target) 
            {
                low = mid + 1; // Search in the right half
            } 
            else 
            {
                high = mid; // Search in the left half
            }
            
        }
        return low; // Target not found
    }
    
}
