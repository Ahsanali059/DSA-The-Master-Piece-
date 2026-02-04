package Searching.BSProblems;

/*
    Time Complexity: O(log n) why ? In each step we are reducing the search 
    space to half.
    Space Complexity: O(1) why ? No extra space is used.



*/
public class lowerBoundOptimal 
{
    public static int lowerBound(int arr[],int target)
    {
        int left = 0; // starting index
        int right = arr.length - 1; // ending index
        int ans = arr.length; // default answer if no element >= target is found

        while(left <= right)
        {
            int mid = left + (right - left) / 2; // to avoid overflow

            if(arr[mid] == target) // 
            {
                ans = mid; // potential answer found
                right = mid - 1; // continue searching in the left half
            }
            else if(arr[mid] < target)
            {
                left = mid + 1; // search in the right half
            }
            else
            {
                right = mid - 1; // search in the left half
            }
        }

        return ans; // return the index of the first element >= target
    }
    
}
