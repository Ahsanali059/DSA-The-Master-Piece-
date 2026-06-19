package stack;

import java.util.Arrays;
import java.util.Stack;

/*
Next greater element ka matlab ha har elements ka lia mujha find karna ha
ka us ka right side pir kon sa greater element ha us sa

Array: [4, 5, 2, 25]

For 4 → next greater is 5

For 5 → next greater is 25

For 2 → next greater is 25

For 25 → no greater element → -1

This problem is resolved using `Monotonic stack` jab ap kisi order mai elements
ko stack mai store karta ho tu wo monotonic stack kahlata ha
 */
public class nextGreaterElement 
{

    public static int[] findNextGreater(int arr[])
    {
        int n = arr.length;

        int []result = new int[n];

        Stack<Integer> stack = new Stack<>();

        for (int i = n-1; i >= 0; i--) {

            // stack.peek() <= arr[i] => means agar stack ka top element
            // current element sa chota ha tu ignore karo and pop kar do
            while (!stack.isEmpty() && stack.peek() <= arr[i]) {
                stack.pop();
            }

            // agar result nahi milta tu -1 insert karo do
            result[i] = stack.isEmpty() ? -1 : stack.peek();

            stack.push(arr[i]);

        }

        return result;
    }

    public static void main(String[] args) {
        int arr[] = {4, 5, 2, 25};
        int [] nge = findNextGreater(arr);

        for (int value : nge)
        {
            System.out.println(value);
        }
    }
}
