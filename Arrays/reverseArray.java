package Arrays;

public class reverseArray 
{
    public static void reverseArray(int arr[])
    {
        int leftPinter = 0;
        int rightPointer = arr.length - 1;

        while(leftPinter < rightPointer)
        {
          
            int temp = arr[leftPinter];
            arr[leftPinter] = arr[rightPointer];
            arr[rightPointer] = temp;
            
            leftPinter++;
            rightPointer--;

        }
    }

    public static void print(int arr[])
    {
        for(int i=0;i<arr.length;i++)
        {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) 
    {

        int arr[] = {10,4,1,7,8,9};
        reverseArray(arr);
        print(arr);


        
    }
    
}
