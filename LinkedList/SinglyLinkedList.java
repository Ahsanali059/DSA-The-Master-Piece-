package LinkedList;

public class SinglyLinkedList
{
    Node head;

    public void insertAtStart(int data)
    {
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
    }

    public void insertAtEnd(int data)
    {
        Node newNode = new Node(data);
        if(head == null)
        {
            head = newNode;
            return;
        }
        Node current = head;
        while(current.next!=null)
        {
            current = current.next;
        }

        current.next = newNode;
    }

    public void insertAtMiddle(int data,int position)
    {
        if(position == 0)
        {
            insertAtStart(data);
        }

        Node newNode = new Node(data);
        Node current = head;
        int index = 0;

        while (current!=null && index < position - 1)
        {
            current = current.next;
            index++;
        }

        if (current==null)
        {
            System.out.println("Position out of range");
            return;
        }

        newNode.next = current;
        current.next = newNode;
    }

    public void deleteAtStart()
    {
        if(head == null)
            return;
        head = head.next;
    }
    public void deleteAtEnd()
    {
        if(head == null)
            return;
        if(head == head.next)
        {
            head = null;
            return;
        }

        Node current = head;
        while (current.next.next != null)
        {
            current = current.next;
        }
        current.next = null;
    }

    public void deleteAtMiddle(int position)
    {
        if (position == 0){
            deleteAtStart();
            return;
        }

        Node current = head;
        int index = 0;
        while (current!=null && index < position - 1)
        {
            current = current.next;
            index++;
        }
        if (current == null || current.next == null) {
            System.out.println("Position out of range");
            return;
        }
        current.next = current.next.next;
    }

    public void displayList()
    {
        Node current = head;
        while (current!=null)
        {
            System.out.print(current.data+" ");
            current = current.next;
        }

        System.out.println("null");
    }

    public static void main(String[] args) {
        SinglyLinkedList list = new SinglyLinkedList();
        list.insertAtStart(1);
        list.insertAtStart(2);
        list.insertAtStart(3);
        list.insertAtStart(4);
        list.insertAtStart(5);

        // insert at middle
        list.insertAtMiddle(6,4);
        list.displayList();

    }
}
