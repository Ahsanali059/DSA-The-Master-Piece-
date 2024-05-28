package Heap;

class MinHeap {
    private int[] heap;
    private int size;
    private int capacity;

    public MinHeap(int capacity) {
        this.size = 0;
        this.capacity = capacity;
        this.heap = new int[capacity];
    }

    /**
     * Find the parent index
     */
    public int parentElement(int index) {
        return (index - 1) / 2;
    }

    /**
     * Find the left child index
     */
    public int leftElement(int index) {
        return 2 * index + 1;
    }

    /**
     * Find the right child index
     */
    public int rightElement(int index) {
        return 2 * index + 2;
    }

    /**
     * Swap two nodes/elements
     */
    public void swap(int index1, int index2) {
        int temp = heap[index1];
        heap[index1] = heap[index2];
        heap[index2] = temp;
    }

    /**
     * Insert an element
     */
    public void insertElement(int element) {
        if (size >= capacity) {
            throw new IllegalArgumentException("Heap is full");
        }

        // Insert a new element at the end of the heap
        heap[size] = element;
        size++;

        // Perform heapify up
        heapifyUp(size - 1);
    }

    /**
     * Heapify up to maintain the heap property after insertion
     */
    private void heapifyUp(int index) {
        while (index > 0 && heap[index] < heap[parentElement(index)]) {
            swap(index, parentElement(index));
            index = parentElement(index);
        }
    }

    /**
     * Extract the minimum element (root of the heap)
     */
    public int extractMin() {
        if (size == 0) {
            throw new IllegalStateException("Heap is empty");
        }

        int min = heap[0];
        heap[0] = heap[size - 1];
        size--;

        heapifyDown(0);
        return min;
    }

    /**
     * Return the minimum element without removing it
     */
    public int peek() {
        if (size == 0) {
            throw new IllegalStateException("Heap is empty");
        }
        return heap[0];
    }

    /**
     * Heapify down to maintain the heap property after extraction
     */
    private void heapifyDown(int index) {
        int smallest = index;
        int left = leftElement(index);
        int right = rightElement(index);

        if (left < size && heap[left] < heap[smallest]) {
            smallest = left;
        }

        if (right < size && heap[right] < heap[smallest]) {
            smallest = right;
        }

        if (smallest != index) {
            swap(index, smallest);
            heapifyDown(smallest);
        }
    }

    /**
     * Print the heap elements
     */
    public void printHeap() {
        for (int i = 0; i < size; i++) {
            System.out.print("=> " + heap[i] + " ");
        }
        System.out.println();
    }
}

public class deleteHeapImpl {
    public static void main(String[] args) {
        MinHeap mh = new MinHeap(10);
        mh.insertElement(12);
        mh.insertElement(10);
        mh.insertElement(20);
        mh.insertElement(30);
        mh.insertElement(5);
        mh.insertElement(15);

        mh.printHeap();  // Should print the heap elements in level order

        System.out.println("Min Element: " + mh.extractMin());  // Should print and remove the min element
        mh.printHeap();  // Should print the heap elements after removing the min element

        System.out.println("Current Min Element: " + mh.peek());  // Should print the current min element without removing it
        mh.printHeap();  // Should print the heap elements
    }
}

    

