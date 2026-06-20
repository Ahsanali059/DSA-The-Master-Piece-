package LinkedList.CircularLinkedList;

class Node {
    int data;
    Node next;
    Node(int data) {
        this.data = data;
        next = null;
    }
}

public class CircularLinkedList {
    Node head, tail;

    // Insert at head
    public void insertAtHead(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = tail = newNode;
            tail.next = head;
        } else {
            newNode.next = head;
            head = newNode;
            tail.next = head; // maintain circular link
        }
    }

    // Insert at tail
    public void insertAtTail(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = tail = newNode;
            tail.next = head;
        } else {
            tail.next = newNode;
            tail = newNode;
            tail.next = head;
        }
    }

    // Insert at position (1-based index)
    public void insertAtPosition(int data, int pos) {
        if (pos <= 0) return;
        if (pos == 1) {
            insertAtHead(data);
            return;
        }
        Node newNode = new Node(data);
        Node temp = head;
        int count = 1;
        while (count < pos - 1 && temp.next != head) {
            temp = temp.next;
            count++;
        }
        newNode.next = temp.next;
        temp.next = newNode;
        if (temp == tail) tail = newNode;
    }

    // Delete from head
    public void deleteFromHead() {
        if (head == null) return;
        if (head == tail) {
            head = tail = null;
        } else {
            head = head.next;
            tail.next = head;
        }
    }

    // Delete from tail
    public void deleteFromTail() {
        if (head == null) return;
        if (head == tail) {
            head = tail = null;
        } else {
            Node temp = head;
            while (temp.next != tail) {
                temp = temp.next;
            }
            temp.next = head;
            tail = temp;
        }
    }

    // Delete from position (1-based index)
    public void deleteFromPosition(int pos) {
        if (head == null || pos <= 0) return;
        if (pos == 1) {
            deleteFromHead();
            return;
        }
        Node temp = head;
        int count = 1;
        while (count < pos - 1 && temp.next != head) {
            temp = temp.next;
            count++;
        }
        Node delNode = temp.next;
        if (delNode == head) return; // invalid
        temp.next = delNode.next;
        if (delNode == tail) tail = temp;
    }

    // Display
    public void display() {
        if (head == null) {
            System.out.println("List is empty!");
            return;
        }
        Node temp = head;
        System.out.print("Circular LL: ");
        do {
            System.out.print(temp.data + " ");
            temp = temp.next;
        } while (temp != head);
        System.out.println();
    }

    // Main method
    public static void main(String[] args) {
        CircularLinkedList cll = new CircularLinkedList();
        cll.insertAtHead(10);
        cll.insertAtTail(20);
        cll.insertAtTail(30);
        cll.insertAtTail(40);
        cll.display(); // 10 20 30 40

        cll.insertAtPosition(25, 3);
        cll.display(); // 10 20 25 30 40

        cll.deleteFromHead();
        cll.display(); // 20 25 30 40

        cll.deleteFromTail();
        cll.display(); // 20 25 30

        cll.deleteFromPosition(2);
        cll.display(); // 20 30
    }
}
