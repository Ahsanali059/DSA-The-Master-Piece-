package Searching.BSProblems;

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
