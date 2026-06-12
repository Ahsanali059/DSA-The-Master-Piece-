package LinkedList;

import java.util.ArrayList;
import java.util.List;

/*
 -> create an array
 -> copy ll content into array
 -> write array check palindrome logic
 Space complexity: O(n)
 Time complexity : O(N)
 */
public class checkLinkedListPalindrome
{
     public boolean isPalindrome(Node head)
     {
         if(head == null)
         {
             return true;
         }

         // step 1: elements array mai copy kar do
         List<Integer> list = new ArrayList<>();
         Node current = head;
         while(current!= null)
         {
             list.add(current.data);
             current = current.next;
         }

         // ab array ka palindrome wala logic check kar lo
         int left = 0;
         int right = list.size()-1;

         while (left <= right)
         {
             if(list.get(left)!=list.get(right))
             {
                 return false;
             }
             left++;
             right--;
         }

         return true;
     }

}
