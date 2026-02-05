package Searching.BSProblems;

import java.util.List;

public class findLastOccurrence {

    public static int lastOccurrence(int n, int target, List<Integer> list) {
        int low = 0;
        int high = n - 1;
        int ans = -1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (list.get(mid) == target) {
                ans = mid;        // FIXED
                low = mid + 1;    // move right to find last occurrence
            }
            else if (list.get(mid) > target) {
                high = mid - 1;
            }
            else {
                low = mid + 1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int target = 5;
        List<Integer> list = List.of(1, 2, 3, 4, 5, 5);

        int result = lastOccurrence(list.size(), target, list);
        System.out.println(result); // 5
    }
}
