@SuppressWarnings("unchecked")

/**
 * The test class SorterTest.
 *
 * @author  coglianese
 * @version 3.1.2010
 */
public class SorterTest extends junit.framework.TestCase
{


    public void testSortViaJavaArraysClass()
    {
        Integer[] a = new Integer[]  {5,1,4,6,3,9,0};
        System.out.print("sortViaJavaArraysClass\nBEFORE: ");
        display(a);
        Sorter.sortViaJavaArraysClass(a);
        System.out.print("AFTER:  ");
        display(a);
        sorted(a); 
    }
    
    public void testSortViaMerge()
    {
        Integer[] a = new Integer[]  {5,1,4,6,3,9,0};
        System.out.print("sortViaMerge\nBEFORE: ");
        display(a);
        Sorter.sortViaMerge(a);
        System.out.print("AFTER:  ");
        display(a);
        sorted(a); 
    }
    
    public void testsortViaSelection()
    {
        Integer[] a = new Integer[]  {5,1,4,6,3,9,0};
        System.out.print("sortViaSelection\nBEFORE: ");
        display(a);
        Sorter.sortViaSelection(a);
        System.out.print("AFTER:  ");
        display(a);
        sorted(a); 
    }
    
    public void testSortViaInsertion()
    {
        Integer[] a = new Integer[]  {5,1,4,6,3,9,0};
        System.out.print("sortViaInsertion\nBEFORE: ");
        display(a);
        Sorter.sortViaInsertion(a);
        System.out.print("AFTER:  ");
        display(a);
        sorted(a); 
    }
    
    public void display(Comparable[] theArray) {
        System.out.print("[");
        for (int j = 0; j < theArray.length-1; j++)
          System.out.print(theArray[j] + ", ");
        System.out.println(theArray[theArray.length-1]+"]\n");
    }
    
    public void sorted(Comparable[] theArray){
        for (int j = 0; j < theArray.length-1; j++)
          assertEquals(true, theArray[j].compareTo(theArray[j+1])<=0);
    }
    
}