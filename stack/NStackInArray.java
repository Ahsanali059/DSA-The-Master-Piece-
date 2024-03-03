package stack;

public class NStackInArray 
{
    private int[] array;      // The single array to hold all elements
    private int[] top;        // Array to store the top index of each stack
    private int[] next;       // Array to store the next available index in the array
    private int free;          // Index of the next available free space in the array

    public NStackInArray(int numsOfStack,int capacity)
    {
        array = new int[capacity];
        top = new int[numsOfStack];
        next = new int[capacity];
    // Initialize tops of all stacks as -1 (empty)
    for(int i=0;i<numsOfStack;i++)
    {
        top[i] = -1;
    }

    // Initialize next pointers
    for (int i = 0; i < capacity-1; i++) 
    {
        next[i] = i+1;
        
    }
    next[capacity-1] = -1;//indicate no next avaiable space 
    free = 0;
    public void push(int stackNumber, int value) {
        if (isFull()) {
            System.out.println("Stack Overflow");
            return;
        }

        int currentIndex = free;
        free = next[currentIndex];  // Update the free pointer

        array[currentIndex] = value;  // Place the value in the array
        next[currentIndex] = top[stackNumber];  // Update the next pointer to the previous top
        top[stackNumber] = currentIndex;  // Update the top of the stack
    }

    public int pop(int stackNumber) {
        if (isEmpty(stackNumber)) {
            System.out.println("Stack Underflow");
            return -1;  // Return a dummy value indicating underflow
        }

        int currentIndex = top[stackNumber];  // Get the current top index
        int value = array[currentIndex];      // Get the value at the top index

        // Update pointers
        top[stackNumber] = next[currentIndex];  // Move the top to the next available index
        next[currentIndex] = free;              // Update the next pointer to the current free space
        free = currentIndex;                    // Update the free pointer to the popped space

        return value;
    }

    public boolean isEmpty(int stackNumber) {
        return top[stackNumber] == -1;
    }

    public boolean isFull() {
        return free == -1;
    }

    public static void main(String[] args) {
        int numberOfStacks = 3;
        int totalCapacity = 9;

        NStackInArray nStacks = new NStackInArray(numberOfStacks, totalCapacity);

        nStacks.push(0, 1);
        nStacks.push(0, 2);
        nStacks.push(0, 3);

        nStacks.push(1, 4);
        nStacks.push(1, 5);

        nStacks.push(2, 6);

        System.out.println("Popped from stack 0: " + nStacks.pop(0));
        System.out.println("Popped from stack 1: " + nStacks.pop(1));
        System.out.println("Popped from stack 2: " + nStacks.pop(2));
    }
}