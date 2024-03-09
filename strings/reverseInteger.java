package strings;

public class reverseInteger 
{
        public int reverse(int x) 
        {
            int temp = 0;//Initailize a temporary varaible to store integer number 
            long rev = 0;
    
            while(temp!=null)
            {
                rev = rev * 10 + temp%10;
                temp = temp / 10;
            }
            
            if(rev==(int)rev)// Check if the reversed integer fits within the range of a 32-bit signed integer
            {
                return (int) rev;
            }
            else 
            {
                return 0;//overflow return 0
            }
        }
    
    public static void main(String[] args)
    {
         int number = 890;

         System.err.println(reverse(number));

    }
    
}
