package Searching.BinarySearchProblems;

public class findMinimumInRotatedArray 
{
    public int findMin(int [] nums)
    {
        int n = nums.length; // length of the array
        int low = 0; // starting index
        int high = n - 1; // ending index

        while(low < high)
        {
            int mid = low + (high - low) /2; // finding the middle index
            
            if(nums[mid] > nums[high]) // if the middle element is greater than the last element
            {
                low = mid + 1; // move the low pointer to the right of mid
            }
            else // if the middle element is less than or equal to the last element
            {
                high = mid; // move the high pointer to mid
            }
        }
        return nums[low]; // the minimum element will be at the low pointer
    }
    
}
