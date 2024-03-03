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

        //pop all the remainig elements 

        int top = stack.peek();

        insertAtBottomFuntion(stack, data);

        //insert all removed elements 

        stack.push(top);
    }
    
}
