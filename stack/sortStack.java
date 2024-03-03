package stack;

import java.util.Stack;

public class sortStack 
{
    public static void sortMyStack(Stack<Integer> orgiginalStack)
    {
        Stack<Integer> SecondStack = new Stack<>();

        while (!orgiginalStack.isEmpty()) 
        {

            //top element nikalo ure compare karo 

            int stackTop = orgiginalStack.pop();

            while (!SecondStack.isEmpty() && SecondStack.peek() > stackTop)
            {

               SecondStack.push(orgiginalStack.pop());
                
            }

            //jab stackTop ko sai position mil jaiy 
            SecondStack.push(stackTop);

            
        }

        while (!SecondStack.isEmpty()) {
            orgiginalStack.push(SecondStack.pop());
        }


    }


    public static void main(String[] args) 
    {

        
    }
    
}
