package DP.Class01_2024;

public class bottomUp
{
    public static long feboSeries(int n)
    {
        if(n<=1)
           return n;

        //Step 1:Create dp array to store febo ans 
        long[] dp=new long[n+1];

        //step 2:base case 
        dp[0] = 0;
        dp[1] = 1;

        //step 3:build the Febonnaci sequence from the bottom up 
        for(int i=2;i<=n;i++)
        {
            dp[i] = dp[i-1] + dp[n-2];
        }

        //return the result
        return dp[n];
    }

    public static void main(String[] args) 
    {
        /*
         * The bottom up approach involves building the solution 
         * iterativly,starting from the smallest sub problems and 
         * and progressing towards the larger ones.   
         * 
         * 
         */
        int n = 10;  // Change the value of n as needed

        long result = feboSeries(n);
        System.out.println("Fibonacci of " + n + " is: " + result);

        
    }
    
}
