import java.lang.*;

/**
 * The test class for SinglyLinkedListTest for Part 1
 */
public class SinglyLinkedList1StudentTest  extends junit.framework.TestCase
{
    public void testStudentA()
    {
        SinglyLinkedList<String> obj = new SinglyLinkedList();
        assertEquals(true, obj.isEmpty());
        obj.add(0, "2");
        assertEquals(1, obj.size());
        assertEquals(true, obj.contains("2"));
        ListNode<String> temp = obj.getFront();
        assertEquals("2", temp.getValue());
        temp = obj.removeFront();
        assertEquals("2", temp.getValue());
    }

    public void testStudentB()
    {
        SinglyLinkedList<String> obj = new SinglyLinkedList<String>();
        obj.addFirst("3");
        obj.addFirst("2");
        obj.addFirst("1");
        obj.addFirst("0");
        assertEquals("[0, 1, 2, 3]", obj.toString());
        String temp = obj.get(0);
        assertEquals("0", temp);
        ListNode<String> tNode = obj.getNodeAtIndex(1);
        assertEquals("1", tNode.getValue());
    }
}