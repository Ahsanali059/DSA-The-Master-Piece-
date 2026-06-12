package LinkedList;

/*
Intuition:
-> Reverse first linked list
-> Reverse second linked list
-> Add from left
-> reverse ans linked list
 */
public class addTwoLinkedList
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

    public Node addTwoLists(Node first, Node second)
    {
        // step 1: reverse input LL
        first = reverse(first);
        second = reverse(second);

        // step 2: add two LL
        Node ans = add(first,second);

        // reverse ans LL
        ans = reverse(ans);

        return ans;
    }

    // Add two reversed linked lists
    private Node add(Node first, Node second) {
        Node dummy = new Node(0);
        Node current = dummy;
        int carry = 0;

        while (first != null || second != null || carry != 0) {
            int sum = carry;
            if (first != null) {
                sum = sum + first.data;
                first = first.next;
            }
            if (second != null) {
                sum = sum + second.data;
                second = second.next;
            }

            carry = sum / 10;
            current.next = new Node(sum % 10);
            current = current.next;
        }
        return dummy.next;
    }
}
