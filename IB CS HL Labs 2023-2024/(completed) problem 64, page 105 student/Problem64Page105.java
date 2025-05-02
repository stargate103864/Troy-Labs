//Ian Havill
import java.util.*;
import java.lang.Math;
/**
 * Problem64Page105.
 *
 * @author  
 * @version (a version number or a date)
 *
 */
public class Problem64Page105
{
    /*
     *  1 <= num < ????
     */
    public static int evaluate_J(int num)
    {
        double temp = 0;
        int power = 0;
        while(Math.pow(2, power) <= num){
            power++;
        }
        int j = (int)(num - Math.pow(2, power - 1));
        return (2 * j) + 1;
    }
}