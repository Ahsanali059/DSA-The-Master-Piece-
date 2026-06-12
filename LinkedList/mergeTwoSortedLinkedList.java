package LinkedList;

public class mergeTwoSortedLinkedList
{
    public Node merge(Node head1, Node head2)
    {
        if(head1 == null)
        {
            return head2;
        }
        if(head2 == null)
        {
            return head1;
        }

        // merge list head
        Node result;

        // step 1: choose starting node
        if(head1.data <= head2.data)
        {
            result = head1;
            head1 = head1.next;
        }
        else
        {
            result = head2;
            head2 = head2.next;
        }

        // step 2 merge remaining nodes
        Node current = result;

        while (head1 != null && head2 != null)
        {
            if(head1.data <= head2.data)
            {
                current.next = head1;
                head1 = head1.next;
            }
            else {
                current.next = head2;
                head2 = head2.next;
            }

            current = current.next;
        }

        // step 3: bachi hoiy node ko attach kar do
        if(head1!=null)
            current.next = head1;
        if(head2!=null)
            current.next = head2;

        return result;
    }
}
