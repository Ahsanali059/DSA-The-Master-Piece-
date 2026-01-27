import java.util.*;

public class UnionIntersectionSortedArrays {

    public static void main(String[] args) {
        int[] arr1 = {1, 3, 4, 5, 7};
        int[] arr2 = {2, 3, 5, 6};

        union(arr1, arr2);
        intersection(arr1, arr2);
    }

    // Function to print Union of two sorted arrays
    // what is union → all unique elements from both arrays
    static void union(int[] arr1, int[] arr2) {
        int i = 0, j = 0;
        System.out.print("Union: ");

        while (i < arr1.length && j < arr2.length) {
            if (arr1[i] < arr2[j]) {
                System.out.print(arr1[i++] + " ");
            } else if (arr2[j] < arr1[i]) {
                System.out.print(arr2[j++] + " ");
            } else { // arr1[i] == arr2[j]
                System.out.print(arr1[i] + " ");
                i++;
                j++;
            }
        }

        // Print remaining elements
        while (i < arr1.length) System.out.print(arr1[i++] + " ");
        while (j < arr2.length) System.out.print(arr2[j++] + " ");

        System.out.println();
    }

    // Function to print Intersection of two sorted arrays
    // what is intersection → common elements in both arrays
    static void intersection(int[] arr1, int[] arr2) {
        int i = 0, j = 0;
        System.out.print("Intersection: ");

        while (i < arr1.length && j < arr2.length) {
            if (arr1[i] < arr2[j]) {
                i++;
            } else if (arr2[j] < arr1[i]) {
                j++;
            } else { // arr1[i] == arr2[j]
                System.out.print(arr1[i] + " ");
                i++;
                j++;
            }
        }
        System.out.println();
    }
}
