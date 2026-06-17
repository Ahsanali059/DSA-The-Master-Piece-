package stack;

import java.util.Stack;

public class insertAtBottom 
{
    public static void insertAtBottomFuntion(Stack<Integer> stack,int data)
    {

        if(stack.isEmpty())
        {
            stack.push(data);
            return;
        }

        //pop all the remaining elements and this all elements is stored inside temporary recursive stack then after insert in bottom we again insert this elements from this stack to original stack
        int top = stack.peek();

        insertAtBottomFuntion(stack, data);

        //insert all removed elements
        stack.push(top);
    }
    
}
