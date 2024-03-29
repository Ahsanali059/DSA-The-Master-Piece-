package strings;

public class plandiromString 
{
    public static boolean isPalindrome(String s)
    {
        return reversedString(s).equals(s); 
    }

    public static String reversedString(String s)
    {
        char[] c = s.toCharArray();
        int left = 0;
        int right = c.length - 1;
        
        while(left < right)
        {
            char temp = c[left];
            c[left] = c[right];
            c[right] = temp;
            left++;
            right--;

        }
        return new String(c);
    }
    public static void main(String[] args) 
    {
        String s = "1221";
        if(isPalindrome(s))
        {
            System.out.println("Palindrome");
        }
        else 
        {
            System.out.println("Not Palindrome");
        }
        
    }
    
}
