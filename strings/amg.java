package strings;

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
