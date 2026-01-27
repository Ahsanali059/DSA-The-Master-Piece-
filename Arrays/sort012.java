package Arrays;


// Dutch National Flag Algorithm
// Time Complexity: O(n)
// Space Complexity: O(1)
// input: arr[] = {0, 1, 2, 0, 1, 2}
// output: arr[] = {0, 0, 1, 1, 2, 2}

public class sort012 
{
    public static void sortZeroOneTwo(int arr[])
    {
        int left = 0;
        int mid = 0;
        int right = arr.length - 1;

        while (left<=right) 
            {
                if ( arr[mid] == 0 ) 
                {
                    // swap arr[low] and arr[mid]
                    int temp = arr[left];
                    arr[left] = arr[mid];
                    arr[mid] = temp;
                    left++;
                    mid++;
                } 
                else if (arr[mid] == 1) 
                {
                    mid++;
                } 
                else 
                {
                    // swap arr[mid] and arr[high]
                    int temp = arr[mid];
                    arr[mid] = arr[right];
                    arr[right] = temp;
                    right--;
                }
            
        }
    }
    
}
