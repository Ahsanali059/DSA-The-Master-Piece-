package Searching.BSProblems;

public class floorCeilFinder 
{
    public static int findFloor(int arr[],int target)
    {
        int n = arr.length;
        int low = 0;
        int high = n - 1;
        int ans = -1;
        
        while (low<=high) 
        {
            int mid = low + (high-low)/2;
            if(arr[mid]<=target)
            {
                ans = arr[mid];
                low = mid+1;
            }
            else {
                high = mid-1;
            }
            
        }
        return ans;

    }

    public static int findCeil(int arr[],int target)
    {
        int n = arr.length;
        int low = 0;
        int high = n - 1;
        int ans = -1;

        while (low<=high)
        {
            int mid = low + (high-low)/2;
            if( arr[mid]>=target)
            {
                ans = arr[mid];
                low = mid+1;
            }
            else
            {
                high = mid-1;
            }
        }
        return ans;
    }

    // Funtion to return floor and ceil as array
    public int[] getFloorAndCiel(int arr[],int target)
    {
        int f = findFloor(arr,target);
        int ceil = findCeil(arr,target);
        return new int[]{f,ceil};
    }
    public static void main(String[] args) {
        int arr[] = {3,4,4,7,8,10};
        int target = 5;
        floorCeilFinder finder = new floorCeilFinder();
        int res[] = finder.getFloorAndCiel(arr,target);
        System.out.println("The Floor and Ciel are : "+ res[0]+" "+res[1]);
    }
}
