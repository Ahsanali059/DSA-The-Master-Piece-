package LinkedList;

public class ReverseKGroup
{
    public static Node reverseKGroupElement(Node head, int k)
    {
        // Base case
        if(head == null)
        {
            return null;
        }

        // step 1: reverse first k nodes
        Node current = head;
        Node prev = null;
        Node next = null;

        int count = 0;

        while (current != null && count < k)
        {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
            count++;
        }

        // step 2: Recursive call laga do agha wala part ka lia
        // head.next ka matlab ka first k node ka agha wala part
        if(head!=null)
        {
            head.next = reverseKGroupElement(head, k);
        }

        // step 3: return head of the reverse list
        return prev;


    }
}
