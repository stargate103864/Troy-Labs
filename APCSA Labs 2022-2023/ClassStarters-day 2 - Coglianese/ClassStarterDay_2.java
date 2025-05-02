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
public class ClassStarterDay_2<E>
{
    /**
     **<br> insert a new ListNode after the first ListNode with node.getvalue().equals( target)
     **<br> The new node shall contain the parameter val
     **<br> All other nodes are not changed
     **<br> if no nodes contain target, the list is unchanged
     **/
    public ListNode<E> insertAfter(ListNode<E> head, E target, E val)
    {
        if (head == null)
        {
            return head;
        }//if list is empty return nothing
        ListNode<E> node = head;
        while (node != null)//traversing the whole list
        {
            if (node.getValue().equals(target))//if current node = value
            {
                ListNode<E> ans = new ListNode<E> (val, node.getNext());//creating a new node with value
                node.setNext(ans);//setting the next node to the one you created
                node = node.getNext();//moving on to that node that you just set
            }
            node = node.getNext();//moving to the next node to check again
        }
        return head; //returning the list
    }

    /**
     **<br> insert a new ListNode before the first ListNode with node.getvalue().equals( target)
     **<br> The new node shall contain the parameter val
     **<br> All other nodes are not changed
     **<br> if no nodes contain target, the list is unchanged
     **/
    public ListNode<E> insertBefore(ListNode<E> head, E target, E val)
    {
        if (head == null)
        {
            return head;
        }
        else if (!contains(head, target))
        {
            return head;
        }
        else if (contains (head, target) && head.getValue().equals(target))
        {
            ListNode<E> insert = new ListNode<E>(val, head);
            head = insert;
        }
        else
        {
            ListNode<E> insert = new ListNode<E>(val, null);
            ListNode<E> trail = head;
            int c = 0;
            while (trail != null && !trail.getValue().equals(target))
            {
                trail = trail.getNext();
                c++;
            }
            trail = head;
            for (int i = 0; i < c - 1; i++)
            {
                trail = trail.getNext();
            }
            ListNode<E> track = trail.getNext();
            trail.setNext(insert);
            insert.setNext(track);
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