package stack;
import java.util.Stack;

public class reverseStackImpl 
{
    public static void reverseStack(Stack<Integer> firstStack)
    {
        if(firstStack.isEmpty())
        {
            System.out.println("stack is empty");
            return;
        }

        Stack<Integer> secondStack = new Stack<>();
        //store first stack data in second stack
        while(!firstStack.isEmpty())
        {
            secondStack.push(firstStack.pop());
        }
        //then again store second stack data in first 

        while(!secondStack.isEmpty())
        {
            firstStack.push(secondStack.pop());
        }


    }


    public static void main(String[] args) 
    {

        
    }
    
}
