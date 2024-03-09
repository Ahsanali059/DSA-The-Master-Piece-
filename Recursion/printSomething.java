package Recursion;

public class printSomething {

    public static void printTableUsingRecursion(int num, int multiplier) 
    {
        if (multiplier == 11) {
            return; 
        }

        // Print the result
        System.out.println(num + " x " + multiplier + " = " + (num * multiplier));

        printTableUsingRecursion(num, multiplier + 1);
    }

    public static void main(String[] args) 
    {
         
        int number = 5; 
        printTableUsingRecursion(number, 1);

    }

}
