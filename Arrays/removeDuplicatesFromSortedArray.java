package Arrays;

import java.util.HashSet;
import java.util.Set;

public class removeDuplicatesFromSortedArray
{
    // duplicates elements ko remove kar do and new unique sorted array return karo
    public static int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        Set<Integer> set = new HashSet<>();

        for (int elements: nums)
        {
            set.add(elements);
        }

        return set.size();
    }
    public static void main(String[] args) {

    }
}
