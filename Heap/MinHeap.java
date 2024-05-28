package Heap;

public class MinHeap {
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
    private int parent(int index) {
        return (index - 1) / 2;
    }

    /**
     * Find the left child index
     */
    private int leftChild(int index) {
        return 2 * index + 1;
    }

    /**
     * Find the right child index
     */
    private int rightChild(int index) {
        return 2 * index + 2;
    }

    /**
     * Swap two elements in the heap
     */
    private void swap(int index1, int index2) {
        int temp = heap[index1];
        heap[index1] = heap[index2];
        heap[index2] = temp;
    }

    /**
     * Insert an element into the heap
     */
    public void insert(int element) {
        if (size >= capacity) {
            throw new IllegalStateException("Heap is full");
        }
        size++;
        int currentIndex = size - 1;
        heap[currentIndex] = element;
        // Maintain heap property by comparing with parent and swapping if necessary
        while (currentIndex != 0 && heap[currentIndex] < heap[parent(currentIndex)]) {
            swap(currentIndex, parent(currentIndex));
            currentIndex = parent(currentIndex);
        }
    }

    /**
     * Remove and return the minimum element from the heap
     */
    public int extractMin() {
        if (size <= 0) {
            throw new IllegalStateException("Heap is empty");
        }
        if (size == 1) {
            size--;
            return heap[0];
        }
        int min = heap[0];
        heap[0] = heap[size - 1];
        size--;
        // Restore heap property by heapifying down from the root
        heapifyDown(0);
        return min;
    }

    /**
     * Heapify down from a given index to maintain the heap property
     */
    private void heapifyDown(int index) {
        int smallest = index;
        int left = leftChild(index);
        int right = rightChild(index);
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
     * Print the elements of the heap
     */
    public void printHeap() {
        for (int i = 0; i < size; i++) {
            System.out.print(heap[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        MinHeap minHeap = new MinHeap(10);
        minHeap.insert(10);
        minHeap.insert(5);
        minHeap.insert(15);
        minHeap.insert(7);
        minHeap.insert(20);

        System.out.println("Min Heap:");
        minHeap.printHeap();

        System.out.println("Extracted Min: " + minHeap.extractMin());

        System.out.println("Min Heap after extraction:");
        minHeap.printHeap();
    }
}
