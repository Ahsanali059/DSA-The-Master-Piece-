
/*
    input : "aaabbbccdde"
    output: "abcde"
    explanation: remove adjacent duplicates
    means if two same characters are adjacent to each other we remove them.
    
    time complexity : O(n): why? because we iterate through the string once.n is the length of the string.
    space complexity: O(n): why? because in worst case we might have to store all characters in the string in the stack. 

*/

class Solution {
    public String removeDuplicates(String s) {
        final var sb = new StringBuilder();

        for (char c : s.toCharArray()) {
            final var len = sb.length();

            // if last char == current char → remove last
            if (len > 0 && sb.charAt(len - 1) == c) {
                sb.deleteCharAt(len - 1);
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }
}

