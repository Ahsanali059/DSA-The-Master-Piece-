package strings;

import java.util.HashMap;
import java.util.Map;

public class findDuplicates {

    public static void findDu(String s) 
    {
        Map<Character, Integer> map = new HashMap<>();

        // Convert string to array 
        for (char c : s.toCharArray()) {
            if (map.containsKey(c)) 
            {   
                //means the key is already in the map,so we increment its value by 1.
                map.put(c, map.get(c) + 1);
            } else {
                // Key is not present in the map, so we add it with a value of 1.
                map.put(c, 1);
            }
        }

        System.out.println("Duplicate Elements:");
        // in Java entrySet() method is used to get a set view of the mappings contained in this map.
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            if (entry.getValue() > 1) {
                System.out.println(entry.getKey() + " -> " + entry.getValue() + " occurrences");
            }
        }
    }

    public static void main(String[] args) {
        String inputString = "Hello, world!";
        findDu(inputString);
    }
}
