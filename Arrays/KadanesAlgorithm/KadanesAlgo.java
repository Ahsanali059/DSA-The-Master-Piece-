package Arrays.KadanesAlgorithm;

public class KadanesAlgo
{
    public static int findMaxSubArray(int[] arr)
    {
        int sum = 0;
        int maxi = Integer.MIN_VALUE;

        for (int i = 0; i < arr.length; i++)
        {
//            currentElement = Math.max(currentElement, arr[i]);
//            maxElement = Math.max(maxElement, currentElement);

            // Step 1: sum create karte ha
            sum = sum + arr[i];
            // Step 2: maxi update karte ha
            maxi = Math.max(maxi, sum);
            // Step 3: sum check karte h for negative value
            if(sum<0)
                sum = 0;
        }
        return maxi;
    }

    public static void main(String[] args) {
        int arr[] = {-2, 1, -3, 4};
        System.out.println(findMaxSubArray(arr));
    }
}
