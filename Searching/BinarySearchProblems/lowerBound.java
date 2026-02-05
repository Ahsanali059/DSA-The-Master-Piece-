package Searching.CountOccurrenceInSortedArray.java;

/*
  What is lower Bound ?
    Lower Bound of a target in a sorted array is the index of the 
    first element that is greater than or equal to the target.
    If all elements in the array are less than the target, then the 
    lower bound is the length of the array.
    Time Complexity: O(n) why ? We are traversing the entire array in worst case.
    Space Complexity: O(1) why ? No extra space is used.
*/
public class lowerBound 
{
   
    public static int lowerBoundFinder(int arr[],int target)
    {
        for (int i = 0; i < arr.length; i++) 
        {
            if (arr[i] >= target) 
            {
                return i; // Return the index of the first element >= target
            }
        }
        return arr.length; // If no element is >= target, return length of array
    }

    public static void main(String[] args) 
    {
        int arr[] = {1,2,3,4,5,6,7,8,9}; //sorted array

        int target = 5;
        int result = lowerBoundFinder(arr, target);

        System.out.println("Lower Bound of " + target + " is " + result);
        
    }
    
}
