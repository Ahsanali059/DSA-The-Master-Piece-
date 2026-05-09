package Arrays.KadanesAlgorithm;

public class KadanesAlgo
{
    public static int findMaxSubArray(int[] arr)
    {
        int currentElement = arr[0];
        int maxElement = arr[0];

        for (int i = 1; i < arr.length; i++)
        {
            currentElement = Math.max(currentElement, arr[i]);
            maxElement = Math.max(maxElement, currentElement);
        }
        return maxElement;
    }

    public static void main(String[] args) {
        int arr[] = {-2, 1, -3, 4};
        System.out.println(findMaxSubArray(arr));
    }
}
