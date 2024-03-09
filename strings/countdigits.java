package strings;

public class countdigits 
{
    public static void main(String[] args) 
    {
        int number = 1234563;
        int counter = -1;

        while(number>0)
        {
            counter++;
            number = number/10;

            System.out.println(number);

        }

        System.out.println(counter);

        
        
    }
    
}
