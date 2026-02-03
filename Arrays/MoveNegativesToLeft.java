package arrays;

public class MoveNegativesToLeft {

    public static void moveNegatives(int[] arr) {

        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {

            // Case 1: left negative & right negative → left is correct
            if (arr[left] < 0 && arr[right] < 0) {
                left++;
            }

            // Case 2: left positive & right negative → swap (wrong positions)
            else if (arr[left] >= 0 && arr[right] < 0) {
                swap(arr, left, right);
                left++;
                right--;
            }

            // Case 3: left positive & right positive → right is correct
            else if (arr[left] >= 0 && arr[right] >= 0) {
                right--;
            }

            // Case 4: left negative & right positive → both correct
            else {
                left++;
                right--;
            }
        }
    }

    // Utility method to swap elements
    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    // Main method to test
    public static void main(String[] args) {
        int[] arr = { -1, 3, -5, 6, -2, 4 };

        moveNegatives(arr);

        for (int x : arr) {
            System.out.print(x + " ");
        }
    }
}
s