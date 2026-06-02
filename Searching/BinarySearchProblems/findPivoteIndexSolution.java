package Searching.BinarySearchProblems;

public class findPivoteIndexSolution
{
    public static int findPivoteIndex(int [] nums)
    {
        int ans = Integer.MAX_VALUE;
        int left = 0;
        int n = nums.length;
        int right = n-1;

        if(nums[left] < nums[right])
        {
            // no effective solution array is already sorted
            return -1;
        }

        while (left <= right)
        {
            int mid = left + (right - left) / 2;

            if(nums[mid] <= nums[right])
            {
                // is ka matlab hum l2 wali line pir ha
                // and ans l1 wali line pir ha
                right = mid - 1;
            }
            else
            {
                // mid mera l1 pir hi ha already
                ans = mid; // potential solution
                // move to right
                left = mid + 1;

            }

        }
        return ans;
    }
}
