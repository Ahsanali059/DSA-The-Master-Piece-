package stack.stackUsingLL;

class Node
{
    int data;
    Node next;

    Node(int data)
    {
        this.data = data;
        this.next = null;
    }
}
public class stackImplementationUsingLL {
    private Node head;  // top of stack
    private int size;

    // Push → insert at head
    public void push(int data) {
        Node newNode = new Node(data);
        newNode.next = head; // link new node to old head
        head = newNode;      // update head
        size++;
    }

    // Pop → remove head
    public int pop() {
        if (isEmpty()) {
            throw new RuntimeException("Stack is empty");
        }
        int value = head.data;
        head = head.next; // move head forward
        size--;
        return value;
    }

    // Peek → top element
    public int peek() {
        if (isEmpty()) {
            throw new RuntimeException("Stack is empty");
        }
        return head.data;
    }

    // Size of stack
    public int getSize() {
        return size;
    }

    // Check empty
    public boolean isEmpty() {
        return size == 0;
    }

    // Display stack elements (optional helper)
    public void display() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    // Main method for testing
    public static void main(String[] args) {
        stackImplementationUsingLL stack = new stackImplementationUsingLL();

        stack.push(10);
        stack.push(20);
        stack.push(30);

        stack.display(); // 30 -> 20 -> 10 -> null

        System.out.println("Top element: " + stack.peek()); // 30
        System.out.println("Popped: " + stack.pop());       // 30
        System.out.println("Top after pop: " + stack.peek()); // 20
        System.out.println("Size: " + stack.getSize());     // 2
    }
}