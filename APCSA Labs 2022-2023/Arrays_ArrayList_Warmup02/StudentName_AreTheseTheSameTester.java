

/**
 * The test class AddEmTester.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
import java.util.ArrayList;
public class StudentName_AreTheseTheSameTester extends junit.framework.TestCase
{
    /**
     * Default constructor for test class AddEmTester
     */
    public void testcontainsTheSameElementsInSameOrderArrayList0()
    {
         ArrayList<Comparable> vec = new ArrayList<Comparable>();
         vec.add(new Double(1));
         vec.add(new Double(2));
         vec.add(new Double(3));
         vec.add(new Double(4));
         vec.add(new Double(5));
         ArrayList<Comparable> vec1 = new ArrayList<Comparable>();
         vec1.add(new Double(1));
         vec1.add(new Double(2));
         vec1.add(new Double(3));
         vec1.add(new Double(4));
         vec1.add(new Double(5));
         assertEquals(true, AreTheseTheSame.containsTheSameElementsInSameOrder(vec,vec1));
         vec.add(new Double(1));
         assertEquals(false, AreTheseTheSame.containsTheSameElementsInSameOrder(vec,vec1));
         
    }

    public void testcontainsTheSameElementsInSameOrderArrayList1()
    {
         ArrayList<Comparable> vec = new ArrayList<Comparable>();
         vec.add("Z");
         vec.add("B");
         vec.add("C");
         vec.add("D");
         ArrayList<Comparable> vec1 = new ArrayList<Comparable>();
         vec1.add("Z");
         vec1.add("B");
         vec1.add("C");
         vec1.add("D");
         assertEquals(true, AreTheseTheSame.containsTheSameElementsInSameOrder(vec,vec1));
         vec.remove(2);
         assertEquals(false, AreTheseTheSame.containsTheSameElementsInSameOrder(vec,vec1));
         vec1.remove(2);
         assertEquals(true, AreTheseTheSame.containsTheSameElementsInSameOrder(vec,vec1));
    }
    
    public void testcontainsTheSameElementsInSameOrderArrayList2()
    {
        ArrayList<Comparable> vec = new ArrayList<Comparable>();
        vec.add(new Integer(-71));
        vec.add(new Integer(-71));
        vec.add(new Integer(-17));
        vec.add(new Integer(-7));
        vec.add(new Integer(-7));
        vec.add(new Integer(-2));
        ArrayList<Comparable> vec1 = new ArrayList<Comparable>();
        vec1.add(new Integer(-71));
        vec1.add(new Integer(-71));
        vec1.add(new Integer(-17));
        vec1.add(new Integer(-7));
        vec1.add(new Integer(-7));
        vec1.add(new Integer(-2));
        assertEquals(true, AreTheseTheSame.containsTheSameElementsInSameOrder(vec1,vec));
        vec.add(new Integer(-7));
        assertEquals(false, AreTheseTheSame.containsTheSameElementsInSameOrder(vec1,vec));
    }
    
    public void testcontainsTheSameElementsInSameOrderArrayList3()
    {
         ArrayList<Comparable> vec = new ArrayList<Comparable>();
         vec.add(new Double(-.1));
         vec.add(new Double(.2));
         vec.add(new Double(-.3));
         vec.add(new Double(.4));
         ArrayList<Comparable> vec1 = new ArrayList<Comparable>();
         vec1.add(new Double(-.1));
         vec1.add(new Double(.2));
         vec1.add(new Double(-.3));
         vec1.add(new Double(.4));
         assertEquals(true, AreTheseTheSame.containsTheSameElementsInSameOrder(vec,vec1));
         vec.remove(2);
         assertEquals(false, AreTheseTheSame.containsTheSameElementsInSameOrder(vec,vec1));
         assertEquals(false, AreTheseTheSame.containsTheSameElementsInSameOrder(vec1,vec));
    }
    
    
    public void testcontainsTheSameElementsInSameOrderArrayList4()
    {
         ArrayList<Comparable> vec = new ArrayList<Comparable>();
         vec.add(new Double(7.11));
         ArrayList<Comparable> vec1 = new ArrayList<Comparable>();
         vec1.add(new Double(7.11));
         assertEquals(true, AreTheseTheSame.containsTheSameElementsInSameOrder(vec,vec1));
         vec.add(new Double(-7.11));
         assertEquals(false, AreTheseTheSame.containsTheSameElementsInSameOrder(vec1,vec));
         assertEquals(false, AreTheseTheSame.containsTheSameElementsInSameOrder(vec,vec1));
    }  
    
    public void testcontainsTheSameElementsInSameOrderArray0()
    {
         Comparable [] vec = {1.0, 2.0, 3.0, 4.0, 5.0};
         Comparable [] vec1 = {1.0, 2.0, 3.0, 4.0, 5.0};
         assertEquals(true, AreTheseTheSame.containsTheSameElementsInSameOrder(vec,vec1));
    }

    public void testcontainsTheSameElementsInSameOrderArray1()
    {
         Comparable [] vec = {"Hello", "Goodbye", "See Ya", "Later"};
         Comparable [] vec1 = {"Hello", "Goodbye", "See Ya", "Later"};
         assertEquals(true, AreTheseTheSame.containsTheSameElementsInSameOrder(vec,vec1));
         Comparable [] vec2 = {"Hello", "Goodbye", "SeeYa", "Later"};
         assertEquals(false, AreTheseTheSame.containsTheSameElementsInSameOrder(vec2,vec1));
         
    }

    public void testcontainsTheSameElementsInSameOrderArray2()
    {
         Comparable [] vec = {-.10, .20, -.30, .40};
         Comparable [] vec1 = {-.10, .20, .30, .40};
         assertEquals(false, AreTheseTheSame.containsTheSameElementsInSameOrder(vec1,vec));
         Comparable [] vec2 = {-.10, .20, -.30, .40};
         assertEquals(true, AreTheseTheSame.containsTheSameElementsInSameOrder(vec, vec2));
         
    }
    
    
    public void testcontainsTheSameElementsInSameOrderArray3()
    {
         Comparable [] vec = {"Hello", "Goodbye", "See Ya", "Zater"};
         assertEquals(true, AreTheseTheSame.containsTheSameElementsInSameOrder(vec, vec));
         Comparable [] vec1 = {"Hello", "Hello", "Hello", "Hello"};
         assertEquals(false, AreTheseTheSame.containsTheSameElementsInSameOrder(vec, vec1));
         Comparable [] vec2 = {"Hello", "Hello", "Hello", "Goodbye"};
         assertEquals(false, AreTheseTheSame.containsTheSameElementsInSameOrder(vec, vec2));
    }
    
    public void testcontainsTheSameElementsInSameOrderArray4()
    {
         Comparable [] vec = {7.11};
         Comparable [] vec1 = {7.1, 1};
         assertEquals(true, AreTheseTheSame.containsTheSameElementsInSameOrder(vec, vec));
         
         assertEquals(false, AreTheseTheSame.containsTheSameElementsInSameOrder(vec1, vec));
    } 
    
}
