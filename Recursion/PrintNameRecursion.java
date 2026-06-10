package Recursion;

/*
 Time Complexity: O(N)
 Space Complexity : O(N)
 */
public class PrintNameRecursion
{
    public static void printName(String name,int count)
    {
        // Base case
        if(count==0)
            return;

        System.out.print(name+" ");

        printName(name,count-1);

    }

    public static void main(String[] args) {
        printName("Hello",2);
    }
}
