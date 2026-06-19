package stack;

import java.util.Stack;

/*
 Approach
 Use two stacks
 -> Main stack: store all values
 -> Min stack: keeps stacks of minimum at each level

 push karta time main stack mai direct push karo do and phir check karo ana wali value minstack sa choti ha
 agar yes tu main stack mai push karo do warna aga barh jaio
 */
public class minStack
{
    Stack<Integer> mainStack = new  Stack<>();
    Stack<Integer> minStack = new  Stack<>();

    public minStack()
    {
        mainStack = new Stack<>();
        minStack = new Stack<>();
    }

    public void push(int value)
    {
        mainStack.push(value);

        if(minStack.isEmpty() || value<= minStack.peek())
        {
            minStack.push(value);
        }
    }

    public void pop()
    {
        if (mainStack.isEmpty())
            return;
        int removed =  mainStack.pop();
        if(removed == minStack.peek())
        {
            minStack.pop();
        }
    }

    public int top()
    {
        if(mainStack.isEmpty())
            return -1;
        return mainStack.peek();
    }

    public int getMin()
    {
        if(mainStack.isEmpty())
            return -1;
        return minStack.peek();
    }

    public boolean isEmpty()
    {
        return mainStack.isEmpty();
    }
}
