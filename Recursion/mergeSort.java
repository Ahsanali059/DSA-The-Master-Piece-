package Recursion;

import java.util.Arrays;

/*
 Simple Idea is: Divide array into multiple parts then sort this parts
 and then merge this in sorted order.

 Steps
 Step 1: Divide array into 2 parts
 Step 2: Get both parts sorted via a recursion
 Step 3: Merge the sorted array

 Time Complexity: T(n) = 2T(N/2) + O(N)
 2T(N/2) = Two recursive calls (left half + right half)
 O(N) -> Merging the two halves back together

 At the top level (root) we merge two halves -> cost = O(N)
 At the next level we have 2 sub problems of size n/2 Each merge cost O(N/2) Together O(n)
 The array keeps splitting in half until we reach size 1.
 -> Since each level costs O(N) and there are logn levels
 Time complexity: T(n) = O(n).O(logn) = O(nlogn)
 Space complexity: O(n) : Because we are holding extra temp array to store left and right array
 */
public class mergeSort
{
    public static void main(String[] args) {
       int[] arr = {10,9,8,7,4,2,1};
       int [] sortedArray =  mergeSort(arr);
       System.out.println(Arrays.toString(sortedArray));
    }

    static int [] mergeSort(int [] arr)
    {
        // Base Condition
        if(arr.length == 1)
        {
            return arr;
        }

        // find middle element
        int mid = arr.length/2;

        int [] left = mergeSort(Arrays.copyOfRange(arr, 0, mid));
        int [] right = mergeSort(Arrays.copyOfRange(arr, mid, arr.length));

        return merge(left,right);
    }

    private static int[] merge(int[] first, int[] second)
    {
        // Initialize result array
        int[] result = new int[first.length + second.length];

        int firstArrayIndex = 0;
        int secondArrayIndex = 0;
        int resultIndex = 0;

        while (firstArrayIndex < first.length && secondArrayIndex < second.length)
        {
            if(first[firstArrayIndex] < second[secondArrayIndex])
            {
                result[resultIndex] =  first[firstArrayIndex];
                firstArrayIndex++;
            }
            else {
                result[resultIndex] =  second[secondArrayIndex];
                secondArrayIndex++;
            }

            resultIndex++;
        }

        // it may be possible that one of the arrays is not complete
        // copy the remaining elements
        while (firstArrayIndex < first.length)
        {
            result[resultIndex] =  first[firstArrayIndex];
            firstArrayIndex++;
            resultIndex++;
        }

        while (secondArrayIndex < second.length)
        {
            result[resultIndex] =  second[secondArrayIndex];
            secondArrayIndex++;
            resultIndex++;
        }
     return result;
    }
}
