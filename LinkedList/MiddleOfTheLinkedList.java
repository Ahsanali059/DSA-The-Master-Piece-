package LinkedList;

public class MiddleOfTheLinkedList
{
    public static Node findMiddleNode(Node head)
    {
        if (head == null)
        {
            throw new IllegalArgumentException("Linked List is empty");
        }

        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null)
        {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }
}
