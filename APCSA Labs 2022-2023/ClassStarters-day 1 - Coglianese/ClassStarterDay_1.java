import java.util.*;
import java.io.PrintStream;
import java.lang.Comparable;
import java.lang.Object;
import java.lang.String;

/**
 * Write a description of class ClassStarterDay_1 here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class ClassStarterDay_1<E>
{
    /** removes first node such that obj.equals(node.getvalue()) == true
     **<br> return ListNOde to the front of the List
     **<br> If the List does not contain obj, the List is not modified
     **/
    public ListNode<E> remove(ListNode<E> head, E obj)
    {
        ListNode<E> temp = head;

        if (!contains(head, obj))
        {
            return head;
        }
        if (head.getValue().equals(obj))
        {
            head = head.getNext();
            return head;
        }
        while(!head.getNext().getValue().equals(obj))
        
        {
            head = head.getNext();
        }
        head.setNext(head.getNext().getNext());
        return temp;
    }

    /**      removes all nodes such that obj.equals(node.getvalue()) == true
     **<br>  return ListNode to the first node in the List
     **<br> If the List does not contain obj, the List is not modified
     **/
    public ListNode<E> removeAll(ListNode<E> head, E obj)
    {
        while (contains(head, obj))
        {
            head = remove(head, obj);
        }
        return head;
    }

    private boolean contains(ListNode<E> head, E obj)
    {
        while(head != null)
        {
            if ( head.getValue().equals(obj))
               return true;
            head = head.getNext();
        }
        return false;
    }
}
