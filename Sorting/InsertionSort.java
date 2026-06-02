package Sorting;

/*
 * Time Complexity ->O(n^2)
 * space complexity ->O(1)
 * 
 * 
 * 
 */

public class InsertionSort {

    // Insertion Sort Method
    public static void insertionSort(int[] arr) {

        // Start from second element
        for (int i = 1; i < arr.length; i++) {

            int currentValue = arr[i];
            // j is pointing to the previous element
            int prev = i - 1;

            // Move bigger elements one step ahead
            while (prev >= 0 && arr[prev] > currentValue) {
                arr[prev + 1] = arr[prev]; // shifting means jagha kahli karo
                prev--;
            }

            // ab hamara pass kahli jagha a cukhi ha is ko correct place pir put kar do
            // Put current element in correct position
            arr[prev + 1] = currentValue;
        }
    }

    // Print Array
    public static void printArray(int[] arr) {
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }

    public static void main(String[] args) {

        int[] arr = {10, 4, 1, 7, 8, 9};

        insertionSort(arr);

        System.out.println("Sorted Array:");
        printArray(arr);
    }
}
