import java.lang.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
/**
 * The test class for ClassStarterDay_2<String> Test for Day 1
 * 
 *    test the following methods
 *    
 *    public ListNode<E> remove(ListNode<E> head, E obj)
 *    public ListNode<E> removeAll(ListNode<E> head, E obj)
 */
public class ClassStarterDay_2_BeforeTest extends junit.framework.TestCase
{
    @Test
    public void testInsertBefore_onlyNode()
    {
        ClassStarterDay_2 t = new ClassStarterDay_2();
        ListNode<String> node = new ListNode<String>("A", null);
        node = t.insertBefore(node, "A", "B");
        assertEquals("B", node.getValue());
        assertEquals("A", node.getNext().getValue());
    }

    @Test
    public void testInsertBefore_notInList()
    {
        ClassStarterDay_2 t = new ClassStarterDay_2();
        String[] items = {"A0", "A1", "A2", "A3", "A4", "A5", "A6", "A7"};
        ListNode<String> node = new ListNode<String>(items[0], null);
        node = new ListNode<String>(items[1], node);
        node = new ListNode<String>(items[2], node);
        node = new ListNode<String>(items[3], node);
        node = t.insertBefore(node, "A", "B");
        assertEquals("A3", node.getValue());
        assertEquals("A2", node.getNext().getValue());
        assertEquals("A1", node.getNext().getNext().getValue());
        assertEquals("A0", node.getNext().getNext().getNext().getValue());
    }

    @Test
    public void testInsertBefore_emptyList()
    {
        ClassStarterDay_2 t = new ClassStarterDay_2();
        ListNode<String> node = null;
        node = t.insertBefore(node, "A", "B");
        assertEquals(null, node);
    }

    @Test
    public void testInsertBefore_Last()
    {
        ClassStarterDay_2 t = new ClassStarterDay_2();
        String[] items = {"A0", "A1", "A2", "A3"};
        ListNode<String> node = new ListNode<String>(items[0], null);
        node = new ListNode<String>(items[1], node);
        node = new ListNode<String>(items[2], node);
        node = new ListNode<String>(items[3], node);

        node = t.insertBefore(node, "A0", "B");
        assertEquals("A3", node.getValue());
        assertEquals("A2", node.getNext().getValue());
        assertEquals("A1", node.getNext().getNext().getValue());
        assertEquals("B", node.getNext().getNext().getNext().getValue());
        assertEquals("A0", node.getNext().getNext().getNext().getNext().getValue());

        node = t.insertBefore(node, "A0", "C");
        assertEquals("A3", node.getValue());
        assertEquals("A2", node.getNext().getValue());
        assertEquals("A1", node.getNext().getNext().getValue());
        assertEquals("B", node.getNext().getNext().getNext().getValue());
        assertEquals("C", node.getNext().getNext().getNext().getNext().getValue());
        assertEquals("A0", node.getNext().getNext().getNext().getNext().getNext().getValue());
    }

    @Test
    public void testInsertBefore_First()
    {
        ClassStarterDay_2 t = new ClassStarterDay_2();
        String[] items = {"A0", "A1", "A2"};
        ListNode<String> node = new ListNode<String>(items[0], null);
        node = new ListNode<String>(items[1], node);
        node = new ListNode<String>(items[2], node);

        node = t.insertBefore(node, "A2", "B");
        assertEquals("B", node.getValue() );
        node = t.insertBefore(node, "B", "B");
        assertEquals("B", node.getValue() );
        assertEquals("B", node.getNext().getValue() );
    }

    @Test
    public void testInsertBefore_Inside()
    {
        ClassStarterDay_2 t = new ClassStarterDay_2();
        String[] items = {"A0", "A1", "A2", "A3", "A4", "A5", "A6"};
        ListNode<String> node = new ListNode<String>(items[0], null);
        node = new ListNode<String>(items[1], node);
        node = new ListNode<String>(items[2], node);
        node = new ListNode<String>(items[3], node);
        node = new ListNode<String>(items[4], node);
        node = new ListNode<String>(items[5], node);
        node = new ListNode<String>(items[6], node);

        node = t.insertBefore(node, "A3", "B");
        assertEquals("A6", node.getValue());
        assertEquals("A5", node.getNext().getValue());
        assertEquals("A4", node.getNext().getNext().getValue());
        assertEquals("B", node.getNext().getNext().getNext().getValue());
        assertEquals("A3",  node.getNext().getNext().getNext().getNext().getValue());
        assertEquals("A2", node.getNext().getNext().getNext().getNext().getNext().getValue());

        node = t.insertBefore(node, "B", "B");
        assertEquals("A6", node.getValue());
        assertEquals("A5", node.getNext().getValue());
        assertEquals("A4", node.getNext().getNext().getValue());
        assertEquals("B", node.getNext().getNext().getNext().getValue());
        assertEquals("B", node.getNext().getNext().getNext().getNext().getValue());
        assertEquals("A3", node.getNext().getNext().getNext().getNext().getNext().getValue());

        node = t.insertBefore(node, "A4", "B");
        assertEquals("A6", node.getValue());
        assertEquals("A5", node.getNext().getValue());
        assertEquals("B", node.getNext().getNext().getValue());
        assertEquals("A4", node.getNext().getNext().getNext().getValue());
        assertEquals("B", node.getNext().getNext().getNext().getNext().getValue());
        assertEquals("B", node.getNext().getNext().getNext().getNext().getNext().getValue());
    }
}