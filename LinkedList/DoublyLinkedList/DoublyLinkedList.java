package LinkedList.DoublyLinkedList;

class Node {
    int data;
    Node next;
    Node prev;
    Node(int data) {
        this.data = data;
        next = null;
        prev = null;
    }
}

public class DoublyLinkedList {
    Node head, tail;

    // Insert at head
    public void insertAtHead(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = tail = newNode;
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
    }

    // Insert at tail
    public void insertAtTail(int data) {
        Node newNode = new Node(data);
        if (tail == null) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
    }

    // Delete from head
    public void deleteFromHead() {
        if (head == null) return;
        if (head == tail) {
            head = tail = null;
        } else {
            head = head.next;
            head.prev = null;
        }
    }

    // Delete from tail
    public void deleteFromTail() {
        if (tail == null) return;
        if (head == tail) {
            head = tail = null;
        } else {
            tail = tail.prev;
            tail.next = null;
        }
    }

    // Delete from position (1-based index)
    public void deleteFromPosition(int pos) {
        if (pos <= 0 || head == null) return;
        Node temp = head;
        int count = 1;
        while (temp != null && count < pos) {
            temp = temp.next;
            count++;
        }
        if (temp == null) return; // position out of range
        if (temp == head) deleteFromHead();
        else if (temp == tail) deleteFromTail();
        else {
            temp.prev.next = temp.next;
            temp.next.prev = temp.prev;
        }
    }

    // Insert at position (1-based index)
    public void insertAtPosition(int data, int pos) {
        if (pos <= 0) return;
        Node newNode = new Node(data);
        if (pos == 1) {
            insertAtHead(data);
            return;
        }
        Node temp = head;
        int count = 1;
        while (temp != null && count < pos - 1) {
            temp = temp.next;
            count++;
        }
        if (temp == null || temp == tail) {
            insertAtTail(data);
        } else {
            newNode.next = temp.next;
            newNode.prev = temp;
            temp.next.prev = newNode;
            temp.next = newNode;
        }
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

        dll.deleteFromHead();
        dll.displayForward();   // Forward: 10 30 40

        dll.deleteFromTail();
        dll.displayForward();   // Forward: 10 30

        dll.insertAtPosition(25, 2);
        dll.displayForward();   // Forward: 10 25 30

        dll.deleteFromPosition(2);
        dll.displayForward();   // Forward: 10 30
    }
}
