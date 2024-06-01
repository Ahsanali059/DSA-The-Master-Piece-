package Java8Featues;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class streamApiMap 
{
    public static void main(String[] args) {
        Map<String, String> myMap = new HashMap<>();
        myMap.put("apple", "fruit");
        myMap.put("banana", "fruit");
        myMap.put("avocado", "fruit");
        myMap.put("carrot", "vegetable");


        Map<String,String> myList = myMap.entrySet().stream().filter(
            entry->entry.getKey().startsWith("a")
        ).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));


        System.out.println(myList);
    }
    
}
