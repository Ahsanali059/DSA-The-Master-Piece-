package LinkedList;

import java.util.HashSet;

public class RemoveDuplicatesFromLL
{
    public static void removeDuplicatesFromLL(Node head)
    {
        if(head == null)
        {
            return;
        }

        HashSet<Integer> seen = new HashSet<>();
        Node current = head;
        Node prev = null;

        while(current!=null)
        {
            if(seen.contains(current.data))
            {
                // duplicate found tu duplicate ko skip kar ka agha point karwa do
                prev.next = current.next;
            }
            else {
                seen.add(current.data);
                prev = current;
            }

            current = current.next;
        }
    }
}
