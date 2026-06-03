package Arrays;

import java.util.Arrays;

public class sortZerosAndOne
{
    public static int[] sort(int arr[]) {
        int left = 0;
        int right = arr.length - 1;

        while (left < right)
        {
            if(arr[left] == 1 && arr[right] == 0)
            {
                // swap
            }
            if(arr[left] == 0)
            {
                left ++;
            }
            if(arr[right] == 0)
            {
                right--;
            }
        }
        return arr;
    }

    public static void main(String[] args) {
        int[] arr = {0,1,1,0,0,1,0};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
