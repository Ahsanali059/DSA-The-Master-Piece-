package LinkedList;

/*
Cases:
1: Empty list -> if(head==null) return true
2: 1 node -> if(head.next==null) return false fhir check karo chud ko point tu nahi kar raha
3: Multiple Node case: Kidhar sa start kiya dhir waha pir agaiy tu list ek circular ha
 */
public class CheckListIsCircular {

    public static boolean isCircular(Node head)
    {
        if(head == null)
        {
            return true;
        }

        // one node case
        if(head.next == null)
        {
            return false;
        }

        // multiple node case
        Node current = head;
        while(current!=null && current!=head)
        {
            current = current.next;
        }

        // dubara ushi node pir a gaya
        return current == head;
    }

}
