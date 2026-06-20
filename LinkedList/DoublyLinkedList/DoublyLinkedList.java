package LinkedList.DoublyLinkedList;

class Node
{
    int data;
    Node next;
    Node prev;
    Node(int data)
    {
        this.data = data;
        next = null;
        prev = null;
    }
}
public class DoublyLinkedList
{
    Node head,tail;

    public void insertAtHead(int data)
    {
        Node newNode = new Node(data);
        if(head == null)
        {
            head = tail = newNode;
        }
        else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
    }

    public void insertAtTail(int data)
    {
        Node newNode = new Node(data);
        if(tail == null)
        {
            head = tail = newNode;
        }
        else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
    }

    // Delete a node
    public void delete(Node node) {
        if (node == null) return;

        if (node == head) head = head.next;
        if (node == tail) tail = tail.prev;

        if (node.prev != null) node.prev.next = node.next;
        if (node.next != null) node.next.prev = node.prev;
    }

    // Display forward
    public void displayForward() {
        Node temp = head;
        System.out.print("Forward: ");
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    // Display backward
    public void displayBackward() {
        Node temp = tail;
        System.out.print("Backward: ");
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.prev;
        }
        System.out.println();
    }

    // Main method for testing
    public static void main(String[] args) {
        DoublyLinkedList dll = new DoublyLinkedList();
        dll.insertAtHead(10);
        dll.insertAtHead(20);
        dll.insertAtTail(30);
        dll.insertAtTail(40);

        dll.displayForward();   // Forward: 20 10 30 40
        dll.displayBackward();  // Backward: 40 30 10 20
    }
}