package Arrays;

public class findUniqueElements
{
    public static int findUnique(int[] arr)
    {
        int xorSum = 0;
        for(int element:arr)
        {
            xorSum = xorSum ^ element;
        }
        return xorSum;
    }

    public static void main(String[] args) {
        int [] arr = {2,3,2,1,1,5};
        System.out.println(findUnique(arr));
    }
}
