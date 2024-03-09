package Recursion;

public class ReverseArray {
    public static void reverseArray(int arr[]) {
        // Base case: If array is null or has only one element, no need to reverse
        if (arr == null || arr.length <= 1) {
            return;
        }

        // Start and end pointer
        int start = 0;
        int end = arr.length - 1;

        while (start < end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        System.out.println("Original array:");
        printArray(arr);
        reverseArray(arr);
        System.out.println("Reversed array:");
        printArray(arr);
    }

    public static void printArray(int[] arr) 
    {
        for (int num : arr) 
        {
            System.out.print(num + " ");
        }

        System.out.println();
    }
}
