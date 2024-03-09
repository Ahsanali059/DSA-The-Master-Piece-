package Recursion;

public class print1toN 
{
    public static void print1toN(int n)
    {
        if(n==0)
           return;

        System.out.println(n-1);   
        print1toN(n - 1); 
       

    }
    public static void main(String[] args)
    {
        print1toN(5);

    }
    
}
