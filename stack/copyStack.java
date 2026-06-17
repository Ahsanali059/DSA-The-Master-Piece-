package stack;

import java.util.Stack;

public class copyStack
{
    public Stack<Integer> copyStack(Stack<Integer> stack)
    {
        Stack<Integer> temp = new Stack<>();

        while(!stack.isEmpty())
        {
            int current = stack.peek();
            stack.pop();
            temp.push(current);
        }

        Stack<Integer> result = new Stack<>();
        while(!temp.isEmpty())
        {
            int current = temp.peek();
            temp.pop();
            result.push(current);
        }

        return result;
    }

    public static void printStack(Stack<Integer> stack)
    {
        while(!stack.isEmpty())
        {
            int current = stack.peek();
            stack.pop();
            System.out.print(current + " ");

        }
    }

    public static void main(String[] args) {

    }
}
