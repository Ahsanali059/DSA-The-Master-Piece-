package stack;

import java.util.Stack;

public class removeFromBottom
{
    public void removeFromBottom(Stack<Integer> stack)
    {
        if(stack.size() == 1)
        {
            stack.pop();
            return;
        }

        int top = stack.pop();

        removeFromBottom(stack);

        stack.push(top);
    }
}
