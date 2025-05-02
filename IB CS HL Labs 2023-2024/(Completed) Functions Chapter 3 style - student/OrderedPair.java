import java.util.*;
import java.lang.Math;
/**
 *
 * @author  
 * @version (a version number or a date)
 */
public class OrderedPair
{
   private String x;
   private String y;

   public OrderedPair(String x1, String y1)
   {
      x = x1;
      y = y1;
   }

   public String getX() { return x; }

   public String getY() { return y; }

/*
 *    If you want to compare two OrderedPair objects for equality,
 *    you need to correctly implement this method
 */
   public boolean equals(Object obj)
   {
      if (this == obj) return true;
      if (getClass() != obj.getClass()) return false;
      OrderedPair temp = (OrderedPair) obj;
      return Objects.equals(x, temp.x) && Objects.equals(y, temp.y);
   }

/*
 *     Not tested
 *     
 *     If you are going to use a HashMap, You MUST (I think) reimplement this method
 *     
 *     OK, the class of 2020 says you must!
 */
   public int hashCode()
   {
      return Objects.hash(x, y);
   }

/*
 *     Not tested
 *     
 *     However, I did used this method in getRelationString
 *     AND it was a helpful tool when used in conjunction with the getRelationString
 *     method which GREATLY simplified and shorten the code in some methods
 */
   public String toString()
   {
      return "("+ getX() + "," + getY() + ")";
   }
}