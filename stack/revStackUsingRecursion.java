package stack;

import java.util.Stack;

public class revStackUsingRecursion 
{
    public static void insertAtBottom(Stack<Integer> stack,int data)
    {
        if(stack.isEmpty())
        {
            stack.push(data);
            return;
        }

        //second step 
        int top = stack.peek();
        insertAtBottom(stack, data);
        stack.push(top);
    }

    public static void reverseStack(Stack<Integer> stack)
    {
        if(!stack.isEmpty())
        {
            int top = stack.peek();

            reverseStack(stack);

            //insert all the poped element in bottom 
            insertAtBottom(stack, top);
        }
    }
    public static void main(String[] args) 
    {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);

        System.out.println("Original Stack: " + stack);

        // Reverse the stack
        reverseStack(stack);

        System.out.println("Reversed Stack: " + stack);
        
    }
    
}
