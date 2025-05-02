
/**
 * Write a description of class AddEmUp here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.util.ArrayList;
public class AreTheseTheSame
{

    /**
     * @return     true if the two arrays contain the same elements in the same order.
     */
    public static boolean containsTheSameElementsInSameOrder(Comparable [] arr1, Comparable [] arr2)
    {
        if (arr1.length != arr2.length) return false;
        for (int h = 0; h < arr1.length; h++)
           if (arr1[h].compareTo(arr2[h]) != 0) return false;

        return true;
    }

    /**
     * @return     true if the two array lists contain the same elements in the same order.
     */
    public static boolean containsTheSameElementsInSameOrder(ArrayList <Comparable> arr1, ArrayList <Comparable> arr2)
    {
        if (arr1.size() != arr2.size()) return false;
        for (int h = 0; h < arr1.size(); h++)
           if (arr1.get(h).compareTo(arr2.get(h) ) != 0) return false;

        return true;
    }
}
