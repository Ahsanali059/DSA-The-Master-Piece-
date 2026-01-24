class Solution {
    public boolean isPalindrome(String s) {
        // Convert string to char array
        char arr[] = s.toCharArray();

        int left = 0;
        int right = arr.length - 1;

        // Reverse the array in place
        while (left < right) {
            char temp = arr[left]; 
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
        }

        // Convert reversed char array back to string
        String revString = new String(arr);

        // Compare strings
        if (revString.equals(s)) {
            return true;
        } else {
            return false;
        }
    }

    // Optional main to test
    public static void main(String[] args) {
        Solution sol = new Solution();

        System.out.println(sol.isPalindrome("racecar")); // true
        System.out.println(sol.isPalindrome("hello"));   // false
    }
}
