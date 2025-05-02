import java.lang.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * The test class SinglyLinkedListTest.
 *
 * @author  Coglianese
 * @version 12.2022
 */
public class SinglyLinkedListTest  extends junit.framework.TestCase
{

    /**
     * The test class for SinglyLinkedListTest for Part 1
     */
    @Test
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

    @Test
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

    /**
     * Default constructor for test class SinglyLinkedListTest
     */
    public SinglyLinkedListTest()
    {
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @BeforeEach
    public void setUp()
    {
    }

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @AfterEach
    public void tearDown()
    {
    }
}
