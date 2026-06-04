package LinkedList;

public class ReverseLinkedList
{
    public static Node reverse(Node head)
    {
        // handle empty list and single node case
        if (head == null || head.next == null)
        {
            return head;
        }

        Node prev = null;
        Node current = head;
        while(current != null)
        {
            Node forword = current.next;
            current.next = prev;
            prev = current;
            current = forword;
        }

        return prev;
    }
}
