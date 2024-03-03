package DP.class3;

public class climbStairs 
{
    public static int nthStaris(int n)
    {
        if(n==1)
          return 1;
        if(n==2)
          return 2;

        //create dp array 
        int dp[] = new int[n+1];

        //base case 
        dp[1]=1;
        dp[2]=2;

        //fill this array 
        for (int i = 2; i < n; i++) 
        {
            dp[n] = dp[n-1]+dp[n-2];
            
        }

        return dp[n];
    }
    public static void main(String[] args) 
    {
        int n=3;

        int rs = climbStairs.nthStaris(n);

        System.out.println(rs);

        
    }
    
}
