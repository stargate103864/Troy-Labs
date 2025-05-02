import java.lang.*;
import java.util.*;
import java.lang.Math;
/**
 * @author  Don Allen
 */

public class ArrayQueue
{
    private int front;
    private int back;
    private int size = 0;
    private String[] myQueue;
    public ArrayQueue()
    {
        myQueue = new String[5];
        size = 0;
        back = 0;
        front = 0;
    }

    /*
     *   You must implement enqueue
     *       adds the parameter item to back of queue
     *       the queue will not be full, but you SHALL not make myQueue bigger
     *           When attempting Extra Credit, you may make myQueue bigger
     *   

     */
    public void enqueue(String item)
    {
        myQueue[back] = item;
        back++;
        size++;
    }

    /*
     *   returns (and removes) the front element from queue
     */
    public String dequeue()
    {
        String x = myQueue[front];
        for (int i = 1; i < myQueue.length; i++)
        {
            myQueue[i-1] = myQueue[i];
        }
        size--;
        back--;
        return x;
    }

    /*
     *   returns the number of elements in the queue
     */
    public int size()
    {
        return size;
    }

    /*
     *    returns true if the queue is empty
     *            false if the queue contains at least one element
     */
    public boolean isEmpty()
    {
        return (size() == 0);
    }

    /*
     *   leave this method alone!!!!!
     */
    public String[] getQueue()
    {
        return myQueue;
    }
}