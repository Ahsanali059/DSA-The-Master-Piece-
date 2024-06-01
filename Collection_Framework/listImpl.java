package Collection_Framework;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class listImpl 
{
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        List<Integer> duplicates = new ArrayList<>();
        Set<Integer> seen = new HashSet<>();
        
        
        list.add(1);
        list.add(2);
        list.add(4);
        list.add(6);
        list.add(4); 
        list.add(2); 

       
        for (int li : list) {
            if (seen.contains(li)) 
            {
                duplicates.add(li);
            } else {
                seen.add(li);
            }
        }

        
        System.out.println("Original list:");
        for (int li : list) {
            System.out.println(li);
        }

       
        System.out.println("\nDuplicate elements:");
        for (int dup : duplicates) {
            System.out.println(dup);
        }
    }
}
