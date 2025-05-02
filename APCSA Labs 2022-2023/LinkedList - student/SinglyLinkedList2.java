/**
 * lab goals:        - Learn all about "do it yourself" linked lists
 *                   - Learn how to create unit tests using JUnit and the Jamtester tool. 
 *                   - Learn how to create a complete battery of tests so as to attain complete "code coverage".
 *                   - Have a lot of fun looking at the bright colors red and green!
 *
 * lab instructions: 
 *                   while ( everyMethodNotYetWrittenAndThoroughlyTested() ) {
 *                     1) Write a test for a method.
 *                     2) Run and watch the test fail.
 *                     
 *                     while ( testNotYetGreen() ) {
3) Write/modify the code for the method.
 *                       4) re-run the test.
 *                     } 
 *                   } 
 *
 *                   Now that you have at least one test method per method in your class, go back and run
 *                   all tests in the student tool. Do you have complete code coverage? If not, design more
 *                   tests until you do.
 *
 * class invariant: elements stored in the list are all of the same type.
 */
import java.util.*;
import java.io.PrintStream;
import java.lang.Comparable;
import java.lang.Object;
import java.lang.String;

public class SinglyLinkedList2<E> extends SinglyLinkedList<E>
{
    /** returns a reference (not the ListNode but the getvalue() ) to the obj at the end of the list**/
    public E getLast()
    {
        if (isEmpty())
        {
            return null;
        }
        ListNode<E> temp = getFront();
        while(temp.getNext()!=null)
        {
            temp = temp.getNext();
        }
        return temp.getValue();
    }

    /**  adds value to the end of the list.**/
    public void addLast(E value)
    {
        if (isEmpty())
        {
            addFirst(value);
        }
        else
        {
            ListNode<E>node = new ListNode<E>(value, null);
            ListNode<E> temp = getFront();
            while(temp.getNext()!=null)
            {
                temp = temp.getNext();
            }
            temp.setNext(node);
        }
    }

    /** reverse the contents of the list.**/
    public void reverse()
    {
        int count = 1;
        ListNode<E>temp = getFront();
        while (temp != null)
        {
            addFirst(temp.getValue());
            temp = temp.getNext();
            remove(count);
            count++;
        }
    }

    /**
     *  return a referrence (ot the ListNode but the getvalue() ) previously at index ind. 
     *  replace that value with obj
     *  preCondition: 0 <= ind < number of nodes in the list 
     *              0 < size()
     **/
    public E set(int ind, E obj)
    {
        ListNode<E> temp = getFront();
        for (int i = 0; i < ind; i++)
        {
            temp = temp.getNext();
        }
        E out = temp.getValue();
        temp.setValue(obj);
        return out;
    }

    /** removes the ind-th node from the list.
     *  return a referrence (ot the ListNode but the getvalue() ) to the obj at index ind.
     *  preCondition: 0 <= ind < number of nodes in the list
     *               0 < size()
     **/
    public E remove(int ind)
    {
        if (ind == 0)
        {
            return removeFront().getValue();
        }
        else
        {
            ListNode<E>prev = getFront();
            for (int i = 1; i < ind; i++)
            {
                prev = prev.getNext();
            }
            E out = prev.getNext().getValue();
            prev.setNext(prev.getNext().getNext());
            return out;
        }
    }

    /**
     * return a referrence (not the ListNode but the getvalue() ) to the first obj 
     *  list is not modified!
     *  if list is empty return null
     **/
    public E getFirst()
    {
        if (isEmpty())
        {
            return null;
        }
        return getFront().getValue();
    }

    /*
     *    If List is empty return null
     *    otherwise, return the middle node.
     *               If there are two middle nodes, return either
     */
    public ListNode<E> getMiddleNode()
    {
        if (isEmpty())
        {
            return null;
        }
        ListNode<E>temp = getFront();
        for (int i = 0; i < size()/2; i++)
        {
            temp = temp.getNext();
        }
        return temp;
    }
}
