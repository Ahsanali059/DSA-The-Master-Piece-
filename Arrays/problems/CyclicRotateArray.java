import java.util.Arrays;

// Cyclically rotate an array by one step to the right
// Input: arr[] = {1, 2, 3, 4, 5}
// Output: arr[] = {5, 1, 2, 3, 4}
// Time Complexity: O(n)
// Space Complexity: O(1)
// Approach: Store the last element and shift all other elements to the right by one position. Finally, place the last element at the first position.
public class CyclicRotateArray {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};

        System.out.println("Original Array: " + Arrays.toString(arr));
        rotateByOne(arr);
        System.out.println("Rotated Array: " + Arrays.toString(arr));
    }

    static void rotateByOne(int[] arr) {
        if (arr.length <= 1) return; // No rotation needed

        int last = arr[arr.length - 1]; // Save last element

        // Shift all elements right by one
        for (int i = arr.length - 1; i > 0; i--) {
            arr[i] = arr[i - 1];
        }

        arr[0] = last; // Move last element to first position
    }
}
