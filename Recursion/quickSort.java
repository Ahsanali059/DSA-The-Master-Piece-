package Recursion;

/*
 Pivot: Choose any element -> after first pass all the elements less then of the pivot
 this will comes inside left side of the pivot element and greater element will comes
 inside right side of the pivot elements

 Important point: after every round pivot will goes its correct position
 e.g: 5,4,3,2,1
 we choose pivot 4 then after this round 4 will goes to its correct position
 */
public class quickSort
{
    public static void main(String[] args) {

    }

    static void sort(int[] nums, int low, int high)
    {
        // Base case
        if(low>=high)
        {
            return;
        }

        int start = low;
        int end = high;

        int mid = start +  (end-start)/2;
        int pivot = nums[mid];

        while (start<=end)
        {
            while (nums[start]<pivot)
            {
                // correct position just move forward
                start++;
            }
            while (nums[end]>pivot)
            {
                // correct position move backward
                end--;
            }

            if(start<=end)
            {
                int temp = nums[start];
                nums[start] = nums[end];
                nums[end] = temp;
                start++;
                end--;
            }
        }

        // now my pivote is at correct index, sort two halves now
        sort(nums, low, end); // Left half pivot ka left wala elements
        sort(nums, start, high); // Right half pivot ka right wala elements
    }
}
