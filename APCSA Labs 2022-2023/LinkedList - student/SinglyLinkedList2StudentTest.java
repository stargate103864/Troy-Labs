import java.lang.*;

/**
 * The test class for SinglyLinkedListTest for Part B
 * 
 *    test the following methods
 *       addFirst(Object)
 *       getFirst()
 *       addLast(Object)
 *       getLast()
 *       set(int, Object)
 *       getMiddleNode()
 * 
 */
public class SinglyLinkedList2StudentTest extends junit.framework.TestCase
{
    /**
     * The test class for SinglyLinkedListTest for Part B
     * 
     *    test the following methods
     *       addFirst(Object)
     *       getFirst()
     *       addLast(Object)
     *       getLast()
     *       set(int, Object)
     *       getMiddleNode()
     * 
     */
    public void testStudent2A()
    {
        SinglyLinkedList2<String> obj = new SinglyLinkedList2<String>();
        obj.addFirst("4");           // 4
        obj.addFirst("3");           // 3 4
        obj.addFirst("2");           // 2 3 4
        obj.addFirst("1");           // 1 2 3 4
        assertEquals("1", obj.getFirst());
        assertEquals("4", obj.getLast());

        obj.addLast("20");           // 1 2 3 4 20
        obj.reverse();               // 20 4 3 2 1
        assertEquals("1", obj.getLast());
        assertEquals("4", obj.set(1, "set"));   //  20 set 3 2 1
        assertEquals("set", obj.remove(1));   //  20 3 2 1
        boolean midNode1 = "3".equals( obj.getMiddleNode().getValue());
        boolean midNode2 = "2".equals( obj.getMiddleNode().getValue());
        assertEquals(true, midNode1 || midNode2);
    }

}