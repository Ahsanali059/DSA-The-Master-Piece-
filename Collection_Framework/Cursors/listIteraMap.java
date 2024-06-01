package Collection_Framework.Cursors;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;

public class listIteraMap 
{
    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>();
        map.put("A", 10);
        map.put("B", 20);
        map.put("C", 30);
        map.put("D", 40);
        map.put("E", 50);
        List<Map.Entry<String, Integer>> entryList = new ArrayList<>(map.entrySet());
        System.out.print ("eentry List "+entryList);
           // Obtain a ListIterator from the list
           ListIterator<Map.Entry<String, Integer>> iterator = entryList.listIterator();

           System.out.print("Iterator "+iterator);

                 
        System.out.println("Forward traversal:");
        while (iterator.hasNext()) {
            Map.Entry<String, Integer> entry = iterator.next();
            System.out.println("Key: " + entry.getKey() + ", Value: " + entry.getValue());
        }


    }
    
}
