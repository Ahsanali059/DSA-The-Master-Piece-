package SearchingAndSorting;

class Solution {
    public int[] searchRange(int[] nums, int target) {
        int result[] = new int[2];
        result[0] = FindFirst(nums,target);
        result[1] = FindLast(nums,target);
        return result; 
    }

    public static int FindFirst(int nums[],int target) {
        int left = 0;
        int right = nums.length - 1;
        int result = -1;

        while (left <= right) {
            int middle = left + (right - left) / 2;
            if (nums[middle] == target) {
                result = middle;
                right = middle - 1; // Search left side for first occurrence
            } else if (target > nums[middle]) {
                left = middle + 1;
            } else {
                right = middle - 1;
            }
        }
        return result;
    }

    public static int FindLast(int nums[],int target) {
        int left = 0;
        int right = nums.length - 1;
        int result = -1;

        while (left <= right) {
            int middle = left + (right - left) / 2;
            if (nums[middle] == target) {
                result = middle;
                left = middle + 1; // Search right side for last occurrence
            } else if (target > nums[middle]) {
                left = middle + 1;
            } else {
                right = middle - 1;
            }
        }
        return result;
    }
}

