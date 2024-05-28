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
        int currentIndex = size - 1;
        while (currentIndex > 0 && heap[currentIndex] > heap[parentElement(currentIndex)]) {
            swap(currentIndex, parentElement(currentIndex));
            currentIndex = parentElement(currentIndex);
        }
    }

    /**
     * Extract the maximum element (root of the heap)
     */
    public int extractMax() {
        if (size == 0) {
            throw new IllegalStateException("Heap is empty");
        }

        //Store the Maximum Element
        /*
         * The maximum element in a max heap is always at the root, which is at index 0.
          This line stores the maximum element in the variable max for later return.
          
         */

        int max = heap[0];
        /*
         * The last element in the heap is moved to the root position (index 0).
          This step is necessary to fill the gap left by the removed root element and maintain the complete binary tree property.
         */
        heap[0] = heap[size - 1];
        /*
         * size--;
         */
        size--;

        /**
         * After moving the last element to the root, the heap property might be violated.
           heapifyDown(0) is called to restore the max heap property starting from the root.
         */
        heapifyDown(0);
        return max;
    }

    /**
     * Return the maximum element without removing it
     */
    public int peek() {
        if (size == 0) {
            throw new IllegalStateException("Heap is empty");
        }
        return heap[0];
    }

    /**
     * Heapify down to maintain the heap property
     */
    private void heapifyDown(int index) {
        int largest = index;
        int left = leftElement(index);
        int right = rightElement(index);

        if (left < size && heap[left] > heap[largest]) {
            largest = left;
        }

        if (right < size && heap[right] > heap[largest]) {
            largest = right;
        }

        if (largest != index) {
            swap(index, largest);
            heapifyDown(largest);
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

public class heapComplete 
{
    public static void main(String[] args) {
        MaxHeap mh = new MaxHeap(10);
        mh.insertElement(12);
        mh.insertElement(10);
        mh.insertElement(20);
        mh.insertElement(30);
        mh.insertElement(5);
        mh.insertElement(15);

        /*
           => In simple word we use heapify up when we more element bottom to top position 
           => In `heapifyDown we use move element top position to bottom `
        */   
        mh.printHeap();  // Should print the heap elements in level order

        System.out.println("Max Element: " + mh.extractMax());  // Should print and remove the max element
        mh.printHeap();  // Should print the heap elements after removing the max element

        System.out.println("Current Max Element: " + mh.peek());  // Should print the current max element without removing it
        mh.printHeap();  // Should print the heap elements
    }
}

