package Java8Featues;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class streamApi 
{
    public static void main(String[] args) 
    {
        List<String> myList = Arrays.asList("apple", "banana", "orange", "kiwi", "apple");
        
        //filter data and collect into a List 

        List<String> resultList = myList.stream()
        .filter(item -> item.startsWith("a"))
        .collect(Collectors.toList());

        System.out.println(resultList);

    }
    
}
