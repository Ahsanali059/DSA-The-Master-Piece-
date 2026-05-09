package Arrays;

import java.util.HashSet;
import java.util.Set;

// ----------------> Alternative Solution But high complexity<----------------
/*
    public class Main {
    public static void main(String[] args) {

        int[] arr = {1,2,3,4,2,5,1};

        System.out.println("Duplicates:");

        for (int i = 0; i < arr.length; i++) {

            for (int j = i + 1; j < arr.length; j++) {

                if (arr[i] == arr[j]) {
                    System.out.println(arr[i]);
                    break;
                }
            }
        }
    }
}
 */

// Time complexity => O(N)
// Space complexity => O(N) : Because we are taking extra space of Set
// Best Solution
public class findDuplicates
{
    public static void main(String[] args) {
        int [] arr = {1,2,3,4,5,1,2};
        Set<Integer> set = new HashSet<>();
        Set<Integer> duplicates = new HashSet<>();

        for (int num: arr)
        {
            // if already exist add inside duplicate set
            if(!set.add(num))
            {
                duplicates.add(num);
            }
        }

        System.out.println("Duplicates "+duplicates);

    }
}
