package Collection_Framework.Cursors;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

/**
 * Iterator :-
 Iterator is a cursor which is used to get the
elements one by one from the collection object
 It is universal cursor which means that we can
use it with all collection objects
 It can be used for read and remove operation
 It was introduced in JDK 1.2 version
 */
public class listIteratorDemo 
{

    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>();
        numbers.add(10);
        numbers.add(20);
        numbers.add(30);
        numbers.add(40);
        numbers.add(50);
   
        ListIterator<Integer> listIterator = numbers.listIterator();
     
        System.out.println("Forward Traversal ");

        while (listIterator.hasNext()) 
        {
            Integer num = listIterator.next();
            System.out.println(num);
            
        }
    }
    
}
