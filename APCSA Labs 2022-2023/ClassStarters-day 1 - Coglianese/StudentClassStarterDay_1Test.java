import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

/**
 * The test class StudentClassStarterDay_1Test.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class StudentClassStarterDay_1Test 
{

    @Test
    public void testRemove01_onlyNode()
    {
        ClassStarterDay_1 t = new ClassStarterDay_1();
        ListNode<String> node = new ListNode<String>("A", null);
        assertEquals("A", node.getValue());
        node = t.remove(node, "A");
        assertNull( node);
    }

    @Test    
    public void testRemove01_notInList()
    {
        ClassStarterDay_1 t = new ClassStarterDay_1();
        String[] items = {"A0", "A1", "A2", "A3", "A4", "A5", "A6", "A7"};
        ListNode<String> node = new ListNode<String>(items[0], null);
        node = new ListNode<String>(items[1], node);
        node = new ListNode<String>(items[2], node);
        node = new ListNode<String>(items[3], node);
        ListNode<String> front = node;
        node = t.remove(node, "A");
        assertEquals("A3", front.getValue() );
        assertEquals("A2", front.getNext().getValue());
        assertEquals("A1", front.getNext().getNext().getValue());
        assertEquals("A0", front.getNext().getNext().getNext().getValue());
    }

    @Test
    public void testRemove02_emptyList()
    {
        ClassStarterDay_1 t = new ClassStarterDay_1();
        ListNode<String> node = null;
        node = t.remove(node, "A");
        assertNull(node);
    }

    @Test
    public void testRemove03_removeLast()
    {
        ClassStarterDay_1 t = new ClassStarterDay_1();
        String[] items = {"A0", "A1", "A2", "A3", "A4", "A5", "A6", "A7"};
        ListNode<String> node = new ListNode<String>(items[0], null);
        node = new ListNode<String>(items[1], node);
        node = new ListNode<String>(items[2], node);
        node = new ListNode<String>(items[3], node);
        node = new ListNode<String>(items[4], node);
        node = new ListNode<String>(items[5], node);
        node = new ListNode<String>(items[6], node);
        ListNode<String> front = node;
        node = t.remove(node, "A0");
        assertEquals(front, node);
        int ind = 6;
        while(front!= null)
        {
            assertEquals(front.getValue(), items[ind]);
            ind--;
            front = front.getNext();
        }
    }

    @Test
    public void testRemove04_removeFirst()
    {
        ClassStarterDay_1 t = new ClassStarterDay_1();
        String[] items = {"A0", "A1", "A2", "A3", "A4", "A5", "A6", "A7"};
        ListNode<String> node = new ListNode<String>(items[0], null);
        node = new ListNode<String>(items[1], node);
        node = new ListNode<String>(items[2], node);
        node = new ListNode<String>(items[3], node);
        node = new ListNode<String>(items[4], node);
        node = new ListNode<String>(items[5], node);
        node = new ListNode<String>(items[6], node);
        ListNode<String> front = node;
        node = t.remove(node, "A6");
        assertEquals(front.getNext(), node);
        node = t.remove(node, "A5");
        assertEquals(front.getNext().getNext(), node);
        node = t.remove(node, "A4");
        assertEquals(front.getNext().getNext().getNext(), node);
    }

    @Test
    public void testRemove04_removeInside()
    {
        ClassStarterDay_1 t = new ClassStarterDay_1();
        String[] items = {"A0", "A1", "A2", "A3", "A4", "A5", "A6", "A7"};
        ListNode<String> node = new ListNode<String>(items[0], null);
        node = new ListNode<String>(items[1], node);
        node = new ListNode<String>(items[2], node);
        node = new ListNode<String>(items[3], node);
        node = new ListNode<String>(items[4], node);
        node = new ListNode<String>(items[5], node);
        node = new ListNode<String>(items[6], node);
        node = new ListNode<String>(items[7], node);
        ListNode<String> front = node;
        node = t.remove(node, "A3");
        assertEquals("A7", front.getValue());
        assertEquals("A5", front.getNext().getNext().getValue());
        assertEquals("A4", front.getNext().getNext().getNext().getValue());
        assertEquals("A2", front.getNext().getNext().getNext().getNext().getValue());
        assertEquals("A1", front.getNext().getNext().getNext().getNext().getNext().getValue());
        node = t.remove(node, "A1");
        assertEquals("A7", front.getValue());
        assertEquals("A5", front.getNext().getNext().getValue());
        assertEquals("A4", front.getNext().getNext().getNext().getValue());
        assertEquals("A2", front.getNext().getNext().getNext().getNext().getValue());
        assertEquals("A0", front.getNext().getNext().getNext().getNext().getNext().getValue());
        node = t.remove(node, "A6");
        assertEquals("A7", front.getValue());
        assertEquals("A4", front.getNext().getNext().getValue());
        assertEquals("A2", front.getNext().getNext().getNext().getValue());
        assertEquals("A0", front.getNext().getNext().getNext().getNext().getValue());
    }

    @Test
    public void testRemoveAll01()
    {
        ClassStarterDay_1 t = new ClassStarterDay_1();
        ListNode<String> node = new ListNode<String>("A", null);
        assertEquals("A", node.getValue());
        node = t.removeAll(node, "A");
        assertNull( node);
    }

    @Test
    public void testRemove04_removeAll02()
    {
        ClassStarterDay_1 t = new ClassStarterDay_1();
        String[] items = {"A0", "B", "A2", "B", "A4", "B", "B", "A7"};
        ListNode<String> node = new ListNode<String>(items[0], null);
        node = new ListNode<String>(items[1], node);
        node = new ListNode<String>(items[2], node);
        node = new ListNode<String>(items[3], node);
        node = new ListNode<String>(items[4], node);
        node = new ListNode<String>(items[5], node);
        node = new ListNode<String>(items[6], node);
        node = new ListNode<String>(items[7], node);

        node = t.removeAll(node, "B");
        assertEquals("A7", node.getValue());
        assertEquals("A4", node.getNext().getValue());
        assertEquals("A2", node.getNext().getNext().getValue());
        assertEquals("A0", node.getNext().getNext().getNext().getValue());

        node = t.removeAll(node, "A0");
        assertEquals("A7", node.getValue());
        assertEquals("A4", node.getNext().getValue());
        assertEquals("A2", node.getNext().getNext().getValue());

        node = t.removeAll(node, "A7");
        assertEquals("A4", node.getValue());
        assertEquals("A2", node.getNext().getValue());
    }

    @Test
    public void testRemove04_removeAll03()
    {
        ClassStarterDay_1 t = new ClassStarterDay_1();
        String[] items = {"A0", "B", "A", "B", "A4", "B", "B", "A"};
        ListNode<String> node = new ListNode<String>(items[0], null);
        node = new ListNode<String>(items[1], node);
        node = new ListNode<String>(items[2], node);
        node = new ListNode<String>(items[3], node);
        node = new ListNode<String>(items[4], node);
        node = new ListNode<String>(items[5], node);
        node = new ListNode<String>(items[6], node);
        node = new ListNode<String>(items[7], node);

        node = t.removeAll(node, "B");
        assertEquals("A", node.getValue());
        assertEquals("A4", node.getNext().getValue());
        assertEquals("A", node.getNext().getNext().getValue());
        assertEquals("A0", node.getNext().getNext().getNext().getValue());

        node = t.removeAll(node, "A");
        assertEquals("A4", node.getValue());
        assertEquals("A0", node.getNext().getValue());

        node = t.removeAll(node, "A4");
        assertEquals("A0", node.getValue());
    }

    /**
     * Default constructor for test class StudentClassStarterDay_1Test
     */
    public StudentClassStarterDay_1Test()
    {
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @BeforeEach
    public void setUp()throws Exception {
        System.out.println("JUnit4To5.before");
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

