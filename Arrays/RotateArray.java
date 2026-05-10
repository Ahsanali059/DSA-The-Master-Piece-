package Arrays;

/*
 Approach (Reversal Algorithm):

 Step 1: Reverse the whole array
 Step 2: Reverse first k elements
 Step 3: Reverse remaining elements

 Why it works?
 - After full reverse, elements are reversed globally
 - Then we fix positions by reversing parts again
 - This effectively moves last k elements to front
*/

public class RotateArray {

    public static void rotateRight(int[] arr, int k) {
        int n = arr.length;

        // ⚠️ handle cases where k > n
        k = k % n;

        // Step 1: reverse full array
        reverse(arr, 0, n - 1);

        // Step 2: reverse first k elements
        reverse(arr, 0, k - 1);

        // Step 3: reverse remaining elements
        reverse(arr, k, n - 1);
    }

    // helper function to reverse array between two indexes
    private static void reverse(int[] arr, int start, int end) {
        while (start < end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;

            start++;
            end--;
        }
    }

    // test the code
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        int k = 2;

        rotateRight(arr, k);

        for (int num : arr) {
            System.out.print(num + " ");
        }
    }
}