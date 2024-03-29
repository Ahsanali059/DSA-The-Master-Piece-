public class PalindromeNumber {

    public static boolean isPalindrome(int number) {
        String strNumber = String.valueOf(number); // Convert number to string
        return isPalindromeHelper(strNumber);
    }
    private static boolean isPalindromeHelper(String str) {
        // Base case: if the length of the string is 0 or 1, it's a palindrome
        if (str.length() <= 1) {
            return true;
        }
        // Check if the first and last characters are equal
        if (str.charAt(0) != str.charAt(str.length() - 1)) {
            return false;
        }
        // Recursively check the substring excluding the first and last characters
        return isPalindromeHelper(str.substring(1, str.length() - 1));
    }

    public static void main(String[] args) {
        int number = 12321; // Example number
        System.out.println("Is " + number + " a palindrome? " + isPalindrome(number));
    }
}
