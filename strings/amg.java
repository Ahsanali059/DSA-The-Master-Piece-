package strings;

// An Armstrong number (or strong number) for a three-digit number is a number that is equal to the sum of the cubes of its digits.
// input: 153
// output: YES
public class amg 
{
    public static boolean amgStrongNumbered(int x)
    {
        int originalNumber = x;
        int sum = 0;

        while(originalNumber != 0)
        {
            
            int digit = originalNumber % 10;
            sum += digit*digit*digit;

            originalNumber = originalNumber / 10;



        }

        return sum == originalNumber;





    }

    public static void main(String[] args) 
    {
           int n = 153;

           if(amgStrongNumbered(n))
           {
             System.out.println("YES");
           }
           else 
           {
               System.out.println("NO");
           }
        
    }
    
}
