package Arrays;

import java.util.HashSet;
import java.util.Set;

public class findFirstRepeatingElement
{
    public static int findFirstRepeatingNumber(int[] nums)
    {
        Set<Integer> seen = new HashSet<>();

        for(int element: nums)
        {
            if(seen.contains(element))
            {
                return element;// first repeating element;
            }
            else
            {
                seen.add(element);
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        int [] nums = {2,4,6,8,7,6,8};
        System.out.println(findFirstRepeatingNumber(nums));
    }
}
