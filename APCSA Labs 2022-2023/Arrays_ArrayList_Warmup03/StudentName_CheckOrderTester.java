

/**
 * The test class AddEmTester.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
import java.util.ArrayList;
public class StudentName_CheckOrderTester extends junit.framework.TestCase
{
    /**
     * Default constructor for test class AddEmTesterz
     */
    public void testOutOfOrderArrayList0()
    {
         ArrayList<Comparable> vec = new ArrayList<Comparable>();
         vec.add(new Double(1));
         vec.add(new Double(2));
         vec.add(new Double(3));
         vec.add(new Double(4));
         vec.add(new Double(5));
         assertEquals(true, CheckOrder.outOfOrder(vec));
         vec.add(new Double(1));
         assertEquals(false, CheckOrder.outOfOrder(vec));
    }

    public void testOutOfOrderArrayList1()
    {
         ArrayList<Comparable> vec = new ArrayList<Comparable>();
         vec.add("Z");
         vec.add("B");
         vec.add("C");
         vec.add("D");
         assertEquals(false, CheckOrder.outOfOrder(vec));
         vec.set(0,"A");
         assertEquals(true, CheckOrder.outOfOrder(vec));
    }
    
    public void testOutOfOrderArrayList2()
    {
        ArrayList<Comparable> vec = new ArrayList<Comparable>();
		vec.add(new Integer(-71));
		vec.add(new Integer(-71));
		vec.add(new Integer(-17));
		vec.add(new Integer(-7));
		vec.add(new Integer(-7));
		vec.add(new Integer(-2));
        assertEquals(true, CheckOrder.outOfOrder(vec));
        vec.add(new Integer(-7));
        assertEquals(false, CheckOrder.outOfOrder(vec));
    }
    
    public void testOutOfOrderArrayList3()
    {
         ArrayList<Comparable> vec = new ArrayList<Comparable>();
         vec.add(new Double(-.1));
         vec.add(new Double(.2));
         vec.add(new Double(-.3));
         vec.add(new Double(.4));

         assertEquals(false, CheckOrder.outOfOrder(vec));
         vec.remove(2);
         assertEquals(true, CheckOrder.outOfOrder(vec));
    }

    
    public void testOutOfOrderArrayList4()
    {
         ArrayList<Comparable> vec = new ArrayList<Comparable>();
         vec.add(new Double(7.11));

         assertEquals(true, CheckOrder.outOfOrder(vec));
         vec.add(new Double(-7.11));

         assertEquals(false, CheckOrder.outOfOrder(vec));
    }  
    
    public void testOutOfOrderArrayList5()
    {
         ArrayList<Comparable> vec = new ArrayList<Comparable>();
         vec.add(new Double(7.11));

         assertEquals(true, CheckOrder.outOfOrder(vec));
         vec.add(new Double(9.6));
         vec.add(new Double(13.5));
         vec.add(new Double(7.3));
         vec.add(new Double(21.21));
         vec.add(new Double(1.1));

         assertEquals(false, CheckOrder.outOfOrder(vec));
    }  
    
    public void testOutOfOrderArray0()
    {
         Comparable [] vec = {1.0, 2.0, 3.0, 4.0, 5.0};
         assertEquals(true, CheckOrder.outOfOrder(vec));
         Comparable [] vec1 = {1.0, 2.0, 3.0, 4.0, 1.0};
         assertEquals(false, CheckOrder.outOfOrder(vec1));
             
    }

    public void testOutOfOrderArray1()
    {
         Comparable [] vec = {"Hello", "Goodbye", "See Ya", "Later"};
         assertEquals(false, CheckOrder.outOfOrder(vec));
         Comparable [] vec1 = {"Hello", "Hellobye", "See Ya", "Zater"};
         assertEquals(true, CheckOrder.outOfOrder(vec1));
    }

    public void testOutOfOrderArray2()
    {
         Comparable [] vec = {-.10, .20, -.30, .40};
         assertEquals(false, CheckOrder.outOfOrder(vec));
         
         Comparable [] vec1 = {-.10, .20, .30, .40};
         assertEquals(true, CheckOrder.outOfOrder(vec1));
    }
    
    
    public void testOutOfOrderArray3()
    {
         Comparable [] vec = {"Hello", "Goodbye", "See Ya", "Zater"};
         assertEquals(false, CheckOrder.outOfOrder(vec));
         Comparable [] vec1 = {"Hello", "Hello", "Hello", "Hello"};
         assertEquals(true, CheckOrder.outOfOrder(vec1));
         Comparable [] vec2 = {"Hello", "Hello", "Hello", "Goodbye"};
         assertEquals(false, CheckOrder.outOfOrder(vec2));
    }
    
    public void testOutOfOrderArray4()
    {
         Comparable [] vec = {7.11};
         assertEquals(true, CheckOrder.outOfOrder(vec));
         Comparable [] vec1 = {7.1, 1.0};
         assertEquals(false, CheckOrder.outOfOrder(vec1));
    } 
    
}
