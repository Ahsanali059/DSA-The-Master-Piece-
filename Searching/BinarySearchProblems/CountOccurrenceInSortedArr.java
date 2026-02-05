package Searching.BinarySearchProblems;

/**
 *  result = lastOccurrence - firstOccurrence + 1
 * why ? because lastOccurrence is the index of the last occurrence of the target, 
 * and firstOccurrence is the index of the first occurrence of the target. 
 * So, the difference between them is the number of occurrences of the target in the array.
 * We add 1 to include the first occurrence itself in the count.
  Time Complexity: O(log n) why ? In each step we are reducing the search 
  space to half.
  Space Complexity: O(1) why ? No extra space is used.
 * 
 */
public class CountOccurrenceInSortedArr {

    private static int firstOccurrence(int[] arr, int target) {
        int low = 0, high = arr.length - 1;
        int ans = -1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (arr[mid] == target) {
                ans = mid;
                high = mid - 1; // move left
            }
            else if (arr[mid] > target) {
                high = mid - 1;
            }
            else {
                low = mid + 1;
            }
        }
        return ans;
    }

    private static int lastOccurrence(int[] arr, int target) {
        int low = 0, high = arr.length - 1;
        int ans = -1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (arr[mid] == target) {
                ans = mid;
                low = mid + 1; // move right
            }
            else if (arr[mid] > target) {
                high = mid - 1;
            }
            else {
                low = mid + 1;
            }
        }
        return ans;
    }

    // Main logic
    public static int countOccurrences(int[] arr, int target) {
        int first = firstOccurrence(arr, target);
        if (first == -1) return 0;

        int last = lastOccurrence(arr, target);
        return last - first + 1;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 5, 5,5, 6};
        int target = 5;

        System.out.println("Count: " + countOccurrences(arr, target));
    }
}
