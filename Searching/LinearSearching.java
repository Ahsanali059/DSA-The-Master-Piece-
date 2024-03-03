package Searching;

public class LinearSearching 
{
    public static int linearSearch(int[] arr, int key)
    {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == key) {
                return i;
            }
        }
        return -1;
    }


    public static void main(String[] args) {
        int array[] = {1, 2, 3, 4, 5, 6, 7};
        System.out.println(linearSearch(array, 12));


    }
    
}
