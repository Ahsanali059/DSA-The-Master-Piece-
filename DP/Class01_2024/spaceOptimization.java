package DP.Class01_2024;

public class spaceOptimization 
{

    public static long febo(int n)
    {
        if(n<=1)
           return n;
        
        //step 1:store curr and prev value 

        long prev =0;
        long current = 1;

        // Build the Fibonacci sequence from the bottom up

        for(int i=2;i<=n;i++)
        {
            long next = prev+current;
            prev = current;
            current = next;
        }

        //return result 
        return current;
    }
    public static void main(String[] args) 
    {
        /*
         * 
         * You can further optimize the space complexity by 
         * observing that you only need the last two Fibonacci 
         * values to calculate the next one. You don't need 
         * to store the entire array of Fibonacci values. 
         * Here's the Java implementation with space optimization:
         */

         int n = 10;  
         // Change the value of n as needed

        long result = febo(n);
        System.out.println("Fibonacci of " + n + " is: " + result);
      
         
    }
    
}
