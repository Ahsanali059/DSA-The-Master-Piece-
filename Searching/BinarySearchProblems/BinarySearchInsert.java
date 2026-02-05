package Searching.CountOccurrenceInSortedArray.java;


/**
 * What is Binary Search Insert Position?
    Given a sorted array and a target value, return the index if the target is found.
    If not, return the index where it would be if it were inserted in order.
    You may assume no duplicates in the array.
    Time Complexity: O(log n) why ? In each step we are reducing the search
    space to half.
    Space Complexity: O(1) why ? No extra space is used.
    Example:
    Input: nums = [1,3,5,6], target = 5
    Output: 2
    Input: nums = [1,3,5,6], target = 2
    Output: 1 : why ? because 2 is not present in the array but if we insert 2 in the array
    at index 1 the array will be sorted
 * 
 */
public class BinarySearchInsert 
{
    public int searchInsert(int []nums, int x)
    {
        int n = nums.length; // length of the array
        int left = 0; // starting index
        int right = n - 1; // ending index
        int ans = n; // default answer if no element >= x is found

        while (left <= right) 
        {
            int mid = left + (right - left) / 2; // to avoid overflow

            if (nums[mid] >= x) 
            {
                ans = mid; // potential answer found
                right = mid - 1; // continue searching in the left half
            } 
            else 
            {
                left = mid + 1; // search in the right half
            }
        }
        return ans; // return the index of the first element >= x
    }

    public static void main(String[] args) {
        BinarySearchInsert obj = new BinarySearchInsert();
        int arr[] = {1,3,5,6};
        int target = 5;
        int result = obj.searchInsert(arr, target);
        System.out.println("The target " + target + " can be inserted at index: " + result);
    }
    
}
