
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * The test class ClassStarterDay_3Test.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class ClassStarterDay_3Test extends junit.framework.TestCase
    {
        @Test        
        public void testCount_onlyNode()
        {
            ClassStarterDay_3 t = new ClassStarterDay_3();
            ListNode<String> node = new ListNode<String>("A", null);

            int ans = t.count(node, "A");
            assertEquals(1, ans);
            ans = t.count(node, "AA");
            assertEquals(0, ans);
        }

        @Test        
        public void testCount_notInList()
        {
            ClassStarterDay_3 t = new ClassStarterDay_3();
            String[] items = {"A0", "A1", "A2", "A3"};
            ListNode<String> node = new ListNode<String>(items[0], null);
            node = new ListNode<String>(items[1], node);
            node = new ListNode<String>(items[2], node);
            node = new ListNode<String>(items[3], node);
            int ans = t.count(node, "A");
            assertEquals("A3", node.getValue());
            assertEquals("A2", node.getNext().getValue());
            assertEquals("A1", node.getNext().getNext().getValue());
            assertEquals("A0", node.getNext().getNext().getNext().getValue());
            assertEquals(0, ans);
        }

        @Test        
        public void testCount_emptyList()
        {
            ClassStarterDay_3 t = new ClassStarterDay_3();
            ListNode<String> node = null;
            int ans = t.count(node, "A");
            assertEquals(0, ans);
        }

        @Test        
        public void testCount_Last()
        {
            ClassStarterDay_3 t = new ClassStarterDay_3();
            String[] items = {"A0", "A1", "A2", "A3", "A4"};
            ListNode<String> node = new ListNode<String>(items[0], null);
            node = new ListNode<String>(items[1], node);
            node = new ListNode<String>(items[2], node);
            node = new ListNode<String>(items[3], node);
            ListNode<String> front = node;
            int ans = t.count(node, "A0");
            assertEquals("A3", front.getValue());
            assertEquals("A2", front.getNext().getValue());
            assertEquals("A1", front.getNext().getNext().getValue());
            assertEquals("A0", front.getNext().getNext().getNext().getValue());
            assertEquals(1, ans);

            node = new ListNode<String>(items[4], node);
            ans = t.count(node, "A1");
            assertEquals(1, ans);

            node = new ListNode<String>(items[0], null);
            node = new ListNode<String>(items[0], node);
            node = new ListNode<String>(items[0], node);
            node = new ListNode<String>(items[1], node);
            ans = t.count(node, "A0");
            assertEquals(3, ans);
        }

        @Test        
        public void testCount_Front()
        {
            ClassStarterDay_3 t = new ClassStarterDay_3();
            String[] items = {"A0", "A1", "A2"};
            ListNode<String> node = new ListNode<String>(items[0], null);
            node = new ListNode<String>(items[1], node);
            node = new ListNode<String>(items[2], node);

            int ans = t.count(node, "A2");
            assertEquals(1, ans);
            node = new ListNode<String>(items[2], node);
            node = new ListNode<String>(items[2], node);
            node = new ListNode<String>(items[2], node);
            node = new ListNode<String>(items[2], node);
            ans = t.count(node, "A2");
            assertEquals(5, ans);
        }

        @Test        
        public void testCount_Inside()
        {
            ClassStarterDay_3 t = new ClassStarterDay_3();
            String[] items = {"A0", "A1", "A2", "A3", "A4", "A5", "A6"};
            ListNode<String> node = new ListNode<String>(items[0], null);
            node = new ListNode<String>(items[1], node);
            node = new ListNode<String>(items[2], node);
            node = new ListNode<String>(items[3], node);
            node = new ListNode<String>(items[4], node);
            node = new ListNode<String>(items[5], node);
            node = new ListNode<String>(items[6], node);

            int ans = t.count(node, "A3");
            assertEquals(1, ans);

            node = new ListNode<String>(items[2], node);
            node = new ListNode<String>(items[2], node);
            node = new ListNode<String>(items[3], node);
            ans = t.count(node, items[2]);
            assertEquals(3, ans);

            node = new ListNode<String>(items[2], node);
            node = new ListNode<String>(items[2], node);
            node = new ListNode<String>(items[3], node);
            ans = t.count(node, items[2]);
            assertEquals(5, ans);
        }

        @Test        
        public void testCount_All()
        {
            ClassStarterDay_3 t = new ClassStarterDay_3();
            String[] items = {"A0", "A1", "A2", "A3", "A4", "A5", "A6"};
            ListNode<String> node = new ListNode<String>(items[0], null);
            node = new ListNode<String>(items[1], node);
            node = new ListNode<String>(items[2], node);
            node = new ListNode<String>(items[3], node);
            node = new ListNode<String>(items[0], node);
            node = new ListNode<String>(items[4], node);
            node = new ListNode<String>(items[5], node);
            node = new ListNode<String>(items[6], node);
            node = new ListNode<String>(items[0], node);
            node = new ListNode<String>(items[2], node);
            node = new ListNode<String>(items[3], node);
            node = new ListNode<String>(items[2], node);
            node = new ListNode<String>(items[2], node);
            node = new ListNode<String>(items[0], node);
            int ans = t.count(node, items[2]);
            assertEquals(4, ans);
        }

        @Test        
        public void testFix_onlyNode()
        {
            ClassStarterDay_3 t = new ClassStarterDay_3();
            ListNode<String> node = new ListNode<String>("A", null);
            int ans = t.fix(node, "A");
            assertEquals(0, ans);
            assertEquals("A", node.getValue());
        }

        @Test        
        public void testFix_notInList()
        {
            ClassStarterDay_3 t = new ClassStarterDay_3();
            String[] items = {"A0", "A1", "A2", "A3"};
            ListNode<String> node = new ListNode<String>(items[0], null);
            node = new ListNode<String>(items[1], node);
            node = new ListNode<String>(items[2], node);
            node = new ListNode<String>(items[3], node);
            int ans = t.fix(node, "B");
            assertEquals(0, ans);
            assertEquals("A3", node.getValue());
            assertEquals("A2", node.getNext().getValue());
            assertEquals("A1", node.getNext().getNext().getValue());
            assertEquals("A0", node.getNext().getNext().getNext().getValue());
        }

        @Test        
        public void testFix_emptyList()
        {
            ClassStarterDay_3 t = new ClassStarterDay_3();
            ListNode<String> node = null;
            int ans = t.fix(node, "B");
            assertEquals(null, node);
            assertEquals(0, ans);
        }

        @Test        
        public void testFix_Last()
        {
            ClassStarterDay_3 t = new ClassStarterDay_3();
            String[] items = {"A0", "A1", "A2", "A4"};
            ListNode<String> node = new ListNode<String>(null, null);
            node = new ListNode<String>(items[1], node);
            node = new ListNode<String>(items[2], node);
            node = new ListNode<String>(items[3], node);

            int ans = t.fix(node, "HAPPY");
            assertEquals(1, ans);
            assertEquals("HAPPY", node.getNext().getNext().getNext().getValue());

            ans = t.fix(node, "HAPPY");
            assertEquals(0, ans);
            assertEquals("HAPPY", node.getNext().getNext().getNext().getValue());
        }

        @Test        
        public void testFix_First()
        {
            ClassStarterDay_3 t = new ClassStarterDay_3();
            String[] items = {"A0", "A1", "A2"};
            ListNode<String> node = new ListNode<String>(items[0], null);
            node = new ListNode<String>(items[1], node);
            node = new ListNode<String>(null, node);

            int ans = t.fix(node, "HAPPY");
            assertEquals("HAPPY", node.getValue() );
            assertEquals(1, ans);

            ans = t.fix(node, "HAPPY");
            assertEquals(0, ans);
        }

        @Test        
        public void testFix_Inside()
        {
            ClassStarterDay_3 t = new ClassStarterDay_3();
            String[] items = {"A0", "A1", "A2", "A3", "A4", "A5", "A6"};
            ListNode<String> node = new ListNode<String>(items[0], null);
            node = new ListNode<String>(items[1], node);
            node = new ListNode<String>(null, node);
            node = new ListNode<String>(items[3], node);
            node = new ListNode<String>(items[4], node);
            node = new ListNode<String>(items[5], node);
            node = new ListNode<String>(items[6], node);

            int ans = t.fix(node, "HAPPY");
            assertEquals("HAPPY", node.getNext().getNext().getNext().getNext().getValue());
            assertEquals(1, ans);

            ans = t.fix(node, "HAPPY");
            assertEquals(0, ans);

            node = new ListNode<String>(null, node);
            node = new ListNode<String>(items[3], node);
            node = new ListNode<String>(null, node);
            node = new ListNode<String>(items[3], node);

            ans = t.fix(node, "HAPPY");
            assertEquals(2, ans);
        }

        @Test        
        public void testFix_All()
        {
            ClassStarterDay_3 t = new ClassStarterDay_3();
            String[] items = {"A0", "A1", "A2", "A3", "A4", "A5", "A6"};
            ListNode<String> node = new ListNode<String>(null, null);
            node = new ListNode<String>(items[1], node);
            node = new ListNode<String>(items[2], node);
            node = new ListNode<String>(null, node);
            node = new ListNode<String>(items[0], node);
            node = new ListNode<String>(items[4], node);
            node = new ListNode<String>(items[5], node);
            node = new ListNode<String>(items[6], node);
            node = new ListNode<String>(items[0], node);
            node = new ListNode<String>(null, node);
            node = new ListNode<String>(items[3], node);
            node = new ListNode<String>(items[2], node);
            node = new ListNode<String>(null, node);
            node = new ListNode<String>(null, node);
            int ans = t.fix(node, items[2]);
            assertEquals(5, ans);

            assertEquals(items[2], node.getValue());
            assertEquals(items[2], node.getNext().getValue());
            assertEquals(items[2], node.getNext().getNext().getNext().getNext().getValue());
            ListNode<String> temp = node.getNext().getNext().getNext().getNext();
            temp = temp.getNext().getNext().getNext().getNext().getNext().getNext();
            assertEquals(items[2], temp.getValue());
            temp = temp.getNext().getNext().getNext();
            assertEquals(items[2], temp.getValue());
        }
    }

