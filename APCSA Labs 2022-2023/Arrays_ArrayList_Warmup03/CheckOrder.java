
/**
 * Write a description of class AddEmUp here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.util.ArrayList;
@SuppressWarnings("unchecked")
public class CheckOrder
{

    /**
     * Postcondition:     checks if all the items in arr are in the 
     *                      correct non-descending ordering defined by Comparable
     */
    public static boolean outOfOrder(Comparable [] arr)
    {
        for (int x = 1; x < arr.length; x++)
        {
            if (arr[x-1].compareTo(arr[x]) > 0)
            {
                return false;
            }
        }
        return true;
    }

    public static boolean outOfOrder(ArrayList <Comparable> arr)
    {
        for (int x = 1; x < arr.size(); x++)
        {
            if(arr.get(x-1).compareTo(arr.get(x)) > 0)
            {
                return false;
            }

        }
        return true;
    }
}
