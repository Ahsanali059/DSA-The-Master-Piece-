package Recursion;

public class findFact 
{
    public static int fact(int n)
    {
        //Base case 
        if(n==1)
           return 1;
           
        int fact = n * fact(n-1); 
        return fact;  
    }

    public static void main(String[] args) 
    {
        System.err.println(findFact.fact(5));
        
    }
    
}
