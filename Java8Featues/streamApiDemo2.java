package Java8Featues;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class streamApiDemo2 
{
    public static void main(String[] args) 
    {
         List<String> fruitsList = new ArrayList<>();
         fruitsList.add("Apple");
         fruitsList.add("Banana");
         fruitsList.add("Mango");
         fruitsList.add("Orange");
         fruitsList.add("cherry");

         List<String> filteredList = fruitsList.stream()
                                     .filter(item->item.startsWith("A")).collect(Collectors.toList());
                                     
         System.out.println(filteredList);                            
         



        
    }
    
}
