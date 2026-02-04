package stack;

public class NStackInArray {

    private int[] array;   // Stores actual elements
    private int[] top;     // Stores top index of each stack
    private int[] next;    // Next free or next element index
    private int free;      // Head of free list

    public NStackInArray(int numberOfStacks, int capacity) {
        array = new int[capacity];
        top = new int[numberOfStacks];
        next = new int[capacity];

        // Initialize all stacks as empty
        for (int i = 0; i < numberOfStacks; i++) {
            top[i] = -1;
        }

        // Initialize free list
        for (int i = 0; i < capacity - 1; i++) {
            next[i] = i + 1;
        }
        next[capacity - 1] = -1;

        free = 0;
    }

    public void push(int stackNumber, int value) {
        if (stackNumber < 0 || stackNumber >= top.length) {
            System.out.println("Invalid Stack Number");
            return;
        }

        if (isFull()) {
            System.out.println("Stack Overflow");
            return;
        }

        int currentIndex = free;
        free = next[currentIndex];

        array[currentIndex] = value;
        next[currentIndex] = top[stackNumber];
        top[stackNumber] = currentIndex;
    }

    public int pop(int stackNumber) {
        if (stackNumber < 0 || stackNumber >= top.length) {
            System.out.println("Invalid Stack Number");
            return -1;
        }

        if (isEmpty(stackNumber)) {
            System.out.println("Stack Underflow");
            return -1;
        }

        int currentIndex = top[stackNumber];
        int value = array[currentIndex];

        top[stackNumber] = next[currentIndex];
        next[currentIndex] = free;
        free = currentIndex;

        return value;
    }

    public boolean isEmpty(int stackNumber) {
        return top[stackNumber] == -1;
    }

    public boolean isFull() {
        return free == -1;
    }

    public static void main(String[] args) {
        NStackInArray stacks = new NStackInArray(3, 9);

        stacks.push(0, 1);
        stacks.push(0, 2);
        stacks.push(0, 3);

        stacks.push(1, 4);
        stacks.push(1, 5);

        stacks.push(2, 6);

        System.out.println("Popped from stack 0: " + stacks.pop(0));
        System.out.println("Popped from stack 1: " + stacks.pop(1));
        System.out.println("Popped from stack 2: " + stacks.pop(2));
    }
}
