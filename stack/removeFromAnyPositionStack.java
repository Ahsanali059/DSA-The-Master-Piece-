package stack;

import java.util.Stack;

public class removeFromAnyPositionStack
{
    public static void removeFromAnyPosition(Stack<Integer> stack, int position)
    {
        // base case
        if(position == 0)
        {
            // sahi jagha pir a gaiy
            stack.pop();
            return;
        }

        int top = stack.pop();

        removeFromAnyPosition(stack,position-1);

        stack.push(top);

    }
}
