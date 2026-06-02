package Searching.BinarySearchProblems;

/*
  What is Mountain array ?
  1,2,5,4,3 => 5 is a peak element and that is a ans
 */
public class findPeakIndexInMoutainArray
{
    public static int findPeakIndexInArray(int [] nums)
    {
        int left =0 , right = nums.length - 1;
        int ans = -1;

        while (left <= right)
        {
            int mid = left + (right - left)/2;

            if(nums[mid] < nums[mid+1])
            {
                right =  mid - 1;
            }
            else
            {
                ans = mid;
                left = mid + 1;
            }
        }
      return ans;
    }
}
