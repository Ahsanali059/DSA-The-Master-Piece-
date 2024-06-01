package Collection_Framework.Cursors;

import java.util.Enumeration;
import java.util.Vector;

/**
 * Enumerator is a Cursor which is used to print the elements one by one from a collection.
 * Enumerator was introduced in JDK 1.0 version.
 * Enumerator is only used for legacy classes like Vector, Stack, Hashtable, etc.
 */

public class EnumeratorImpl {

    public static void main(String[] args) {
        // Create a Vector and add some elements to it
        Vector<Integer> numbers = new Vector<>();

        numbers.add(90);
        numbers.add(null); // Adding a null value to demonstrate handling of null elements
        numbers.add(4);
        numbers.add(67);

        // Get the Enumeration from the Vector
        Enumeration<Integer> enumeration = numbers.elements();

        // Iterate over the elements using the Enumeration
        System.out.println("Elements in the Vector:");
        while (enumeration.hasMoreElements()) {
            Integer elem = enumeration.nextElement();
            System.out.println(elem);
        }
    }
}
