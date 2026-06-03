package Arrays;

/*
sub elements ko xor kar do jo do dafa ho ga wo cancel and jo
ek dafa ho ga wo a jaiy ga ans simple
 */
public class missingNumberSolution
{
    public static int missingNumber(int[] nums)
    {
        int xorSum = 0;
        int n = nums.length;

        // XOR all array elements
        for (int num : nums)
        {
            xorSum ^= num;
        }

        // XOR all numbers from 0 to n
        for (int i = 0; i <= n; i++)
        {
            xorSum ^= i;
        }

        return xorSum;
    }
}
