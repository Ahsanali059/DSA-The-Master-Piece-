package Heap;

class MaxHeap {
    private int[] heap;
    private int size;
    private int capacity;

    public MaxHeap(int capacity) {
        this.size = 0;
        this.capacity = capacity;
        this.heap = new int[capacity];
    }

    /**
     * Find the parent index
     */
    public int parentIndex(int index) {
        return (index - 1) / 2;
    }

    /**
     * Find the left child index
     */
    public int leftChildIndex(int index) {
        return 2 * index + 1;
    }

    /**
     * Find the right child index
     */
    public int rightChildIndex(int index) {
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
            throw new IllegalArgumentException("Heap is Full");
        }

        // Insert a new element at the end of the heap
        heap[size] = element;
        size++;

        // Perform heapify up
        int currentIndex = size - 1;
        while (currentIndex > 0 && heap[currentIndex] > heap[parentIndex(currentIndex)]) {
            swap(currentIndex, parentIndex(currentIndex));
            currentIndex = parentIndex(currentIndex);
        }
    }

    /**
     * Print the heap elements
     */
    public void printHeap() {
        for (int i = 0; i < size; i++) {
            System.out.print(heap[i] + " ");
        }
        System.out.println();
    }
}

public class MaxHeapImpl {
    public static void main(String[] args) {
        MaxHeap mh = new MaxHeap(10);
        mh.insertElement(12);
        mh.insertElement(10);
        mh.insertElement(20);
        mh.insertElement(30);
        mh.insertElement(5);
        mh.insertElement(15);

        mh.printHeap();  // Should print the heap elements in level order
    }
}
