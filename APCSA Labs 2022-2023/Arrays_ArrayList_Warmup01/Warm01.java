import java.util.*;
/**
 * Write a description of class Warm00 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Warm01
{
    // precond: nums.length >= 1 
    // returns the index of the largest integer in the nums array (first such index if more than one) 
    public static int findPosOfLargest(int[] nums) 
    {
        int biggest = 0;
        for (int x = 0; x < nums.length; x++)
        {
            if (nums[biggest] < nums[x])
            {
                biggest = x;
            }
        }
        return biggest;
    }
    // precond: nums.size() >= 1 
    // postcond: returns the largest Integer object (first such Integer if more than one) 
    public static Integer findLargest(ArrayList<Integer> nums) 
    {
        int max = 0;
        for (int x = 0; x < nums.size(); x++)
        {
            if (nums.get(max) < nums.get(x))
            {
                max = x;
            }
        }
        return nums.get(max);
    }
    // precond: nums.size() >= 1 
    // postcond: return the location of the largest String (lexicographically) in words 
    public static int findPosOfLargest(ArrayList<String> words) 
    {
        String a = words.get(0);
        for (int x = 0; x < words.size(); x++)
        {
            if (words.get(x).compareTo(a) > 0)
            {
                a = words.get(x);
            }
        }
        return words.indexOf(a);
        
    }
}
