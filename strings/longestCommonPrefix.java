// In Java, charAt() returns character of any valid index position
// substring() returns only the part of string from startIndex to endIndex that matched so far
// Input: strs = ["flower","flow","flight"]
// Output: "fl"
class Solution {
    public String longestCommonPrefix(String[] strs) 
    {
        //edge cases
        if(strs.length ==0 || strs == null)
        {
            return "";
        }

        String refrence = strs[0];

        for(int i=0;i<=strs.length-1;i++)
        {
            int index = 0;
            while(index<refrence.length() && index<strs[i].length() 
             && refrence.charAt(index) == strs[i].charAt(index))
             {
                index++;
             }
            
            // shrink string
            refrence = refrence.substring(0,index);
        }

        return refrence;
    }
}