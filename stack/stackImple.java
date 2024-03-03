package stack;
public class stackImple {
    int arr[];
    int size;
    int top;

    public stackImple(int size) {
        this.top = -1;
        this.size = size;
        this.arr = new int[size];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return top == size - 1;
    }

    public void push(int data) {
        if (isFull())
            System.out.println("Stack is full");
        else {
            arr[++top] = data; // Increment top before using it as an index
            size++;
        }
    }

    public void pop() {
        if (isEmpty())
            System.out.println("Stack is empty");
        else {
            top--;
            size--;
        }
    }

    public int peek() {
        if (isEmpty()) {
            System.out.println("Stack is empty");
            return -1; // or throw an exception
        }
        return arr[top];
    }

    public void printStack() {
        for (int i = 0; i <= top; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        // stack contains two things: array, top, size
        stackImple st = new stackImple(2);

        st.push(0);
        st.push(1);



        System.out.println("Peek Element is = "+st.peek());

        System.out.println("Size of Stack "+st.size);

        st.printStack();
    }
}
