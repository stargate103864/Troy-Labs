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
public class ClassStarterDay_3<E>
{
    /**
     **<br> returns the number of nodes such that getValue().equals(obj)
     **/
    public int count(ListNode<E> head, E obj)
    {
        int count = 0;
        ListNode<E> node = head;
        
        while (node != null)
        {
            if (node.getValue().equals(obj))
            {
                count++;
            }
            node = node.getNext();
        }
        return count;
    }

    /**
     **<br> modify all nodes with getvalue() == null to getvalue().equals( item )
     **<br>
     **<br> return the number of nodes that have been modified
     **/
    public int fix(ListNode<E> head, E item)
    {
        ListNode<E> node = head;
        int count = 0;
        while (node != null)
        {
            if (node.getValue()== null)
            {
                node.setValue(item);
                count++;
            }
            node = node.getNext();
        }
        return count;
    }
}