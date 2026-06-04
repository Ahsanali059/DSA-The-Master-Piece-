package LinkedList;

public class ReverseLinkedList
{
    public static Node reverse(Node head)
    {
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
