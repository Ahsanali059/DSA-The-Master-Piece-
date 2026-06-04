package Searching.BinarySearchProblems;

public class SearchNearlySortedArray
{
    public static int findElementInNearlySortedArray(int[] nums, int target)
    {
        int n = nums.length;
        int low = 0;
        int high = n - 1;

        while (low <= high)
        {
            int mid = low + (high - low)/2;

            if(nums[mid] >=0 && nums[mid] == target)
            {
                return mid;
            }
            if(nums[mid+1]==target)
            {
                return mid+1;
            }
            if(nums[mid-1]==target)
            {
                return mid-1;
            }

            if(nums[mid]<target)
            {
                // right mai move kar jaio
                low = mid+1;
            }
            else if(nums[mid]>target)
            {
                // left mai move kar jaio
                high = mid-1;
            }
        }

        return -1;
    }

}
