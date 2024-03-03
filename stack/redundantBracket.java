package stack;

import java.util.Stack;

public class redundantBracket {

    public boolean isRedundant(String s) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (ch == '(' || ch == '+' || ch == '-' || ch == '/' || ch == '*') {
                stack.push(ch);
            } else if (ch == ')') {
                // Closing bracket
                boolean isRedundant = true;
                while (stack.peek() != '(') {
                    char top = stack.pop();
                    if (top == '+' || top == '-' || top == '/' || top == '*') {
                        isRedundant = false;
                    }
                }
                
                // Pop the opening bracket
                stack.pop();

                if (isRedundant) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        redundantBracket rb = new redundantBracket();
        System.out.println(rb.isRedundant("((a+b))"));  // Should print true
        System.out.println(rb.isRedundant("(a+(b)/c)"));  // Should print false
    }
}
