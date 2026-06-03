package Arrays;

import java.lang.reflect.Array;
import java.util.*;

public class ThreeSumSolution
{
    public static List<List<Integer>> threeSum(int[] nums)
    {
        int n = nums.length;

        int target = 0;
        Set<List<Integer>> result = new HashSet<>();

        for (int i = 0; i < n -2; i++)
        {
            for (int j = i + 1; j < n - 1; j++)
            {
                for (int k = j + 1; k < n; k++)
                {
                    if(nums[i] + nums[j] + nums[k] == target)
                    {
                        List<Integer> list = new ArrayList<>();
                        list.add(nums[i]);
                        list.add(nums[j]);
                        list.add(nums[k]);
                        Collections.sort(list);
                        result.add(list);
                    }
                }
            }
        }

        return new ArrayList<>(result);
    }

    public static void main(String[] args) {
        int[] nums = {-1, 0, 1, 2, -1, -4};
        System.out.println(threeSum(nums));
    }
}
