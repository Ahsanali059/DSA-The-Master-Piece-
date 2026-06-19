package stack;

import java.util.Arrays;
import java.util.Stack;

public class nextSmallerElement 
{
    public static int[] findNextSmaller(int[] nums) {
        int n = nums.length;

        int []result = new int[n];

        Stack<Integer> stack = new Stack<>();

        for (int i = n-1; i >= 0; i--) {

            // stack.peek() <= arr[i] => means agar stack ka top element
            // current element sa barha ha tu ignore karo and pop kar do
            while (!stack.isEmpty() && stack.peek() >= nums[i]) {
                stack.pop();
            }

            // agar result nahi milta tu -1 insert karo do
            result[i] = stack.isEmpty() ? -1 : stack.peek();

            stack.push(nums[i]);

        }

        return result;
    }

    public static void main(String[] args) {
        int[] nums = {4, 2, 8, 6, 1, 5, 3};
        int[] result = findNextSmaller(nums);

        System.out.println("Next Smaller Elements: " + Arrays.toString(result));
    }
}
