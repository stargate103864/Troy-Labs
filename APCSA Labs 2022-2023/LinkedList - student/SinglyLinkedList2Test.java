
import java.lang.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * The test class SinglyLinkedList2Test.
 *
 * @author  Coglianese
 * @version 12.2022
 */
public class SinglyLinkedList2Test  extends junit.framework.TestCase
{
    
    @Test
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
    /**
     * Default constructor for test class SinglyLinkedList2Test
     */
    public SinglyLinkedList2Test()
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
