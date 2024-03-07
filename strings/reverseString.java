package strings;

public class reverseString 
{
    public static String reverseString(String str)
    {
        char[] ch = str.toCharArray();
        int left = 0;
        int right = ch.length - 1;

        while (left < right) 
        {
            //swap 
            char temp = ch[left];
            ch[left] = ch[right];
            ch[right] = temp;

            left++;
            right--;
            
        }

        return new String(ch);
    }



    public static void main(String[] args) 
    {
        String inputString = "Hello, world!";
        String reversedString = reverseString(inputString);
        System.out.println("Original: " + inputString);
        System.out.println("Reversed: " + reversedString);
        
    }
    
}
