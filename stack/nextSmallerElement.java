package stack;

import java.util.Arrays;
import java.util.Stack;

public class nextSmallerElement 
{
    public static int[] nextSmaller(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        Arrays.fill(result, -1);

        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < 2 * n; i++) {
            int index = i % n;

            while (!stack.isEmpty() && nums[index] < nums[stack.peek()]) {
                result[stack.pop()] = nums[index];
            }

            if (i < n) {
                stack.push(i);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[] nums = {4, 2, 8, 6, 1, 5, 3};
        int[] result = nextSmaller(nums);

        System.out.println("Next Smaller Elements: " + Arrays.toString(result));
    }
}
