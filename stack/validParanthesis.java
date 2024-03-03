package stack;

import java.util.Stack;

public class validParanthesis 
{
    public static boolean isValid(String s)
    {
        Stack<Character> stack = new Stack<>();

        for(char c:s.toCharArray())
        {
            //opening Bracket 
            if(c == '(' || c == '[' || c == '{')
            {
                //push in stack 
                stack.push(c);

            }
            else 
            {
                //closing bracket
                if(stack.isEmpty())
                {
                    return false;
                }

              char top = stack.pop();
              
              if((c == ')' && top != '(') || (c == ']' && top != '[') || (c == '}' && top != '{'))
              {
                return false;
              }
            }
        }
        return stack.isEmpty();
    }
    public static void main(String[] args) 
    {

        String example1 = "(){}[]";
        String example2 = "([)]";
        String example3 = "{[]}";

        System.out.println("Example 1 is valid: " + isValid(example1));
        System.out.println("Example 2 is valid: " + isValid(example2));
        System.out.println("Example 3 is valid: " + isValid(example3));


        
    }
    
}
