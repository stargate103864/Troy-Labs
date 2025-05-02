//Ian Havill
import java.util.*;
import java.lang.Math;
/**
 * RunRunRunAroundNumbers.
 *
 * @author  
 * @version (a version number or a date)
 */
public class Problem28Page103
{
/*
 *  1 <= num < ????
 */
   public static double evaluate(int num)
   {
      double ans = 0;
      double temp = 0;
      for(double i = 1; i <= num; i++)
      {
          temp = 1/(i * (i + 1));
          ans += temp;
      }
      return ans;
   }
}