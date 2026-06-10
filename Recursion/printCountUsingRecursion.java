package Recursion;

public class printCountUsingRecursion
{
    public static void printCount(int n)
    {
        // Base case
        if(n==0)
            return;

        printCount(n-1);
        // jab recursion call ka bad mai print karta ha tab 1 2 3 4 print ho ga
        // q ka recursion call backend mai chali jati ha sub aj jab stack sa nikala ga
        // tab 1 pahla ay ga fhir 2 ...n
        System.out.println(n);
    }

    public static void main(String[] args) {
        int n = 4;
        printCount(n);
    }
}
