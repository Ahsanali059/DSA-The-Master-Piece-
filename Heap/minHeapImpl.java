package Heap;

class minHeap
{
    private int[]heap;
    private int size;
    private int capacity;

    public minHeap(int capacity)
    {
        this.capacity = capacity;
        this.size = 0;
        this.heap = new int[capacity];
       
    }


    /* 
     * find parent
     * 
    */
    private int parent(int i)
    {
        return (i-1)/2;

    }

    /*
     * find left child 
     */

     private int leftChild(int i)
     {
        return 2*i+1;
     }
     /**
      * find right child 
      */
      private int rightChild(int i) { return 2 * i + 2; }

      /*
       * write swap function for need of swaping if parent is less then child 
       * 
       */

       public void swap(int i,int j)
       {
            int temp = heap[i];
            heap[i] = heap[j];
            heap[j] = temp;
       }

       public void insert(int key)
       {
         if(size==capacity)
             throw new IllegalStateException("Heap is Full");

          heap[size] = key;
          size++;
          heapifyUp(size - 1);
       }

       //to maintain the binary tree property we use heapifyUp 
       /*
        * Heapify Up (also known as "Bubble Up" or "Percolate Up")
        
        */
       private void heapifyUp(int i) {
        while (i != 0 && heap[parent(i)] > heap[i]) {
            swap(i, parent(i));
            i = parent(i);
        }
    }
    public int extractMin() {
        if (size == 0) {
            throw new IllegalStateException("Heap is empty");
        }
        int root = heap[0];

        heap[0] = heap[size - 1];
        size--;
        heapifyDown(0);
        return root;
    }

    /**
     * Heapify down is used when an element is removed from the heap (typically the root). 
     * element in the heap is moved to the root position (to maintain the complete binary tree property), 
     * and the heap property is restored by comparing the new root with its children and swapping if necessary.
     * 
     * @param i
     */
    private void heapifyDown(int i) {
        int smallest = i;
        int left = leftChild(i);
        int right = rightChild(i);

        if (left < size && heap[left] < heap[smallest]) {
            smallest = left;
        }
        if (right < size && heap[right] < heap[smallest]) {
            smallest = right;
        }
        if (smallest != i) {
            swap(i, smallest);
            heapifyDown(smallest);
        }
    }

}


public class minHeapImpl 
{
    public static void main(String[] args) 
    {
        minHeap mh = new minHeap(10);
        mh.insert(3);
        mh.insert(2);
        mh.insert(15);
        mh.insert(5);
        mh.insert(4);
        mh.insert(45);

        System.out.println("Extracted Min: " + mh.extractMin());
        System.out.println("Extracted Min: " + mh.extractMin());

        
    }
    
}
