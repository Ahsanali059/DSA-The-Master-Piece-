package Heap;

public class HeapSort {

    public void sort(int heap[]) {
        int n = heap.length;

        // Build the heap and start from n/2-1 
        //n/2 to n-1 is the leaf node 
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(heap, n, i);
        }

        // Extract elements one by one from the heap 
        for (int i = n - 1; i > 0; i--) {
            // Move current root to the end
            int temp = heap[0];
            heap[0] = heap[i];
            heap[i] = temp;

            // Call heapify on the reduced heap
            heapify(heap, i, 0);
        }
    }

    /**
     * To heapify a subtree rooted with node i which is an index in array[].
     * n is the size of the heap
     */
    private void heapify(int[] array, int n, int i) {
        int largest = i; // Initialize largest as root
        int left = 2 * i + 1; // left child
        int right = 2 * i + 2; // right child

        // If left child is larger than root
        if (left < n && array[left] > array[largest]) {
            largest = left;
        }

        // If right child is larger than the largest so far
        if (right < n && array[right] > array[largest]) {
            largest = right;
        }

        // If the largest is not root
        if (largest != i) {
            int swap = array[i];
            array[i] = array[largest];
            array[largest] = swap;

            // Recursively heapify the affected subtree
            heapify(array, n, largest);
        }
    }

    /**
     * A utility function to print an array of size n
     */
    static void printArray(int[] array) {
        int n = array.length;
        for (int i = 0; i < n; ++i) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] array = {12, 11, 13, 5, 6, 7};
        System.out.println("Unsorted array:");
        printArray(array);

        HeapSort hs = new HeapSort();
        hs.sort(array);

        System.out.println("Sorted array:");
        printArray(array);
    }
}
