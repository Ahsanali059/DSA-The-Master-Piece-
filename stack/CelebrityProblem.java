package stack;

import java.util.Stack;

public class CelebrityProblem 
{

      // Replace this with the actual implementation or logic to check if a knows b
      public boolean isKnow(int a, int b) {
        // Example: Assuming a knows b if a is greater than b
        return a > b;
    }

    public int findCelebrity(int n) {
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < n; i++) {
            stack.push(i);
        }

        while (stack.size() > 1) {
            int A = stack.pop();
            int B = stack.pop();

            if (isKnow(A, B)) {
                stack.push(B);
            } else {
                stack.push(A);
            }
        }

        int lastPerson = stack.pop();

        for (int i = 0; i < n; i++) {
            if (i != lastPerson && !isKnow(lastPerson, i)) {
                // No celebrity found
                return -1;
            }
        }
        return lastPerson;
    }
    public static void main(String[] args) 
    {
        /*
         * Algo 
         *    ->Initialize Empty stack
         *    ->push all the people in the stack 
         *    ->while stack size is greater then 1,pop two people 
         *      from stack (lets call them A and B)
         *    ->If A Knows B A is not a Celebrity push B in stack 
         *    ->If A Knows B B is not a Celebrity push A in stack 
         *
         * 5-Repeat steps 3-4 until only one person remains on the stack.
         * 6-Check if the remaining person is a celebrity by verifying that everyone else knows them, and they know no one   
         * 
         * 
         */
        
         CelebrityProblem cProblem = new CelebrityProblem();
         int n = 4; // Number of people at the party
         int celebrity = cProblem.findCelebrity(n);

         if(celebrity==-1)
         {
            System.out.println("No Celebrity Found ");
         }
         else 
         {
            System.out.println("This is the Celebrity "+celebrity);
         }


    }
    
}
