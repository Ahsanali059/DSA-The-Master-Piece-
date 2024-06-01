package Collection_Framework.Cursors;

import java.util.Enumeration;
import java.util.Vector;

public class enumeratorDemo2 
{
    public static void main(String[] args) 
    {
        Vector<String> students = new Vector<>();

        students.add("ahsan");
        students.add("Usama");
        students.add("Khan Arif");


        //Create Cursor 
        Enumeration<String> enumeration = students.elements();

        while (enumeration.hasMoreElements()) 
        {
            String names = enumeration.nextElement();

            System.out.println(names);
            
        }


        
    }
    
}
