package stack;

import java.util.Stack;

public class InsertAtAnyPositionStack
{
    public static void insertAtAnyPosition(Stack<Integer> stack, int data,int position)
    {
        // base case
        if(position ==0)
        {
            // agar position == 0 => true is ka matlab sahi position pir a gaiy
            stack.push(data);
            return;
        }

        int top = stack.peek();

        insertAtAnyPosition(stack,data,position-1); // position-1 means reach to base case

        stack.push(data);
    }
}
