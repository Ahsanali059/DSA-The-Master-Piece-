package SearchingAndSorting;

class Solution {
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] == target) {
                return mid; // Found the target
            }

            // If the left half is sorted
            if (nums[left] <= nums[mid]) {
                if (nums[left] <= target && target < nums[mid]) {
                    // Target is within the sorted left half
                    right = mid - 1;
                } else {
                    // Target is in the unsorted right half
                    left = mid + 1;
                }
            }
            // If the right half is sorted
            else {
                if (nums[mid] < target && target <= nums[right]) {
                    // Target is within the sorted right half
                    left = mid + 1;
                } else {
                    // Target is in the unsorted left half
                    right = mid - 1;
                }
            }
        }

        // Target not found
        return -1;
    }
}

