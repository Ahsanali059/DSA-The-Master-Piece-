package stack;

import java.util.Arrays;
import java.util.Stack;

public class nextGreaterElement 
{

    public static int[] nextGreater(int nums[])
    {
        int n = nums.length;

        int []result = new int[n];

        Arrays.fill(result, -1);

        Stack<Integer> stack = new Stack<>();

        //we are using 2*n for circular nature array 
        for(int i=0;i<2*n;i++)
        {
            int index = i%n;

            while(!stack.isEmpty() && nums[index]>nums[stack.peek()])
            {
                result[stack.pop()] = nums[index];
            }

            if(i<n)
            {
                stack.push(i);
            }

        }
        return result;
    }
    public static void main(String[] args) 
    {

        
    }
    
}
