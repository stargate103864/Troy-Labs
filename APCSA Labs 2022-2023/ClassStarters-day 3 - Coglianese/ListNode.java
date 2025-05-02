// don't modify - AP's class for a "node"

public class ListNode<E>
{  
  public ListNode(E initValue, ListNode initNext) { 
    value = initValue; 
    next = initNext; 
  } 
  public E getValue() { return value; }
  public ListNode<E> getNext() { return next; }
  public void setValue(E theNewValue)
                             { value = theNewValue; }
  public void setNext(ListNode<E> theNewNext)
                               { next = theNewNext; }

  private E value;
  private ListNode<E> next;
}
