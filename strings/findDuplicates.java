package strings;

import java.util.HashMap;
import java.util.Map;

public class findDuplicates {

    public static void findDu(String s) {
        Map<Character, Integer> map = new HashMap<>();

        for (char c : s.toCharArray()) {
            if (map.containsKey(c)) {
                map.put(c, map.get(c) + 1);
            } else {
                map.put(c, 1);
            }
        }

        System.out.println("Duplicate Elements:");
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
