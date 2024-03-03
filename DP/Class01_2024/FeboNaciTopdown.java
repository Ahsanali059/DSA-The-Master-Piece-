package DP.Class01_2024;

import java.util.Arrays;

public class FeboNaciTopdown 
{

    private static long[] memo;

    public static long febo(int n)
    {
        memo = new long[n+1];
        Arrays.fill(memo, -1);

        //Call the recursion helper function 
        return feboHelper(n);
    }

    private static long feboHelper(int n)
    {
        //base case 
        if(n<=1)
          return n;
        //Check if the result is already computed 
        if(memo[n]!= -1)
        {
            return memo[n];
        }
        // Compute the Fibonacci value and store it in the memoization table

        memo[n] = feboHelper(n-1) + feboHelper(n-2);
        return memo[n];
    }
    public static void main(String[] args) {
        /*
         * steps  
         *   Create empty memo array 
         *   Initailize this array with -1 and start with n+1
         *   check if ans is already calcualted then return ans 
         *   then call recursive functions and store in memo array 
         * 
         *   
         * 
         */
        
        
        int n = 10; 

        long result = febo(n);
        System.out.println("Fibonacci of " + n + " is: " + result);
    }
    
}
