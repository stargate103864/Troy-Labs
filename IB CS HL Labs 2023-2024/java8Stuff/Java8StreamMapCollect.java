import kareltherobot.*;
import java.lang.*;
import java.util.stream.*;
import java.awt.Point;
import java.util.*;
//import java.util.stream;
/**
 * @author  Don Allen
 */
public class Java8StreamMapCollect implements Directions
{
    /*
     *   Remember, the objective of this lab is to use the features provided in Java 8
     *     
     *    remove all negative numbers (< 0) from the parameter nums
     */
    public static List<Integer> noNeg(List<Integer> nums) {
        List<Integer> result = nums.stream()
            .filter(num -> num >= 0)
            .collect(Collectors.toList());

        return result;
    }

    /*
     *   Remember, the objective of this lab is to use the features provided in Java 8
     *     
     *   Given a list of Strings
     *   return a new (and different) list with the first and last letter removed
     *          omitting all new Strings with a length shorter than (not equal) the parameter minLength
     *   
     *   postcondition:  words remains unchanged
     *   
    shortenString(["one", "five", "seven", "twenty-one"], 4) returns ["wenty-on"]
     */
    public static List<String> shortenString(List<String> words, int minLength) {
        List<String> result = words.stream()
            .map(word -> word.length() > 2 ? word.substring(1, word.length() - 1) : "")
            .filter(word -> word.length() >= minLength)
            .collect(Collectors.toList());

        return result;
    }

    /*
     *   Remember, the objective of this lab is to use the features provided in Java 8
     *     
     *   Given a list of Strings
     *   omitting all new Strings with a length shorter than OR equal to the parameter minLength
     *   then return a new (and different) list with the first and last letter removed
     *   
     *   postcondition:  words remains unchanged
     *   
    shortenStringAgain(["one", "five", "seven", "twenty-one"], 4) returns ["eve", "wenty-on"]
     */
    public static List<String> shortenStringAgain(List<String> words, int minLength) {
        List<String> result = words.stream()
            .filter(word -> word.length() > minLength)
            .map(word -> word.substring(1, word.length() - 1))
            .collect(Collectors.toList());
        return result;

    }

    /*
     *   Remember, the objective of this lab is to use the features provided in Java 8
     *     
     *   Given a list of non negative Integers
     *   return a new (and different) list with the values in nums times the parameter scalar
     *          omitting all products that end in 5
     *   
    multiplyByScalar([7, 11, 2, 5], 7) returns ["49", "77", "14"]
     *   postcondition:  nums remains unchanged
     */
    public static List<Integer> multiplyByScalar(List<Integer> nums, int scalar) {
        List<Integer> result = nums.stream()
            .map(num -> num * scalar)
            .filter(product -> product % 10 != 5)
            .collect(Collectors.toList());
        return result;
    }

    /*
     *   Remember, the objective of this lab is to use the features provided in Java 8
     *     
     *   Given a List of Integers
     *   return a list of all positive values (> 0) in nums as a string
     *          yes, omit any values in the List that are NOT positive, that is greater than zero
     *   
    convertToString([7, 11, -2, 5]) returns ["7", "11", "5"]
     *   postcondition:  nums remains unchanged
     */
    public static List<String> convertToString(List<Integer> nums) {
        List<String> result = nums.stream()
            .filter(num -> num > 0)
            .map(Object::toString)
            .collect(Collectors.toList());
        return result;
    }

    /*
     *   Remember, the objective of this lab is to use the features provided in Java 8
     *     
     *   return a Integer List of the length of each String in words 
     *  
     *   omitting all number contain the digit evil
     *   
    listOfLengths(["123456", "123", "123456789"], 7) returns [6, 3]
     *   postcondition:  nums remains unchanged
     */
    public static List<Integer> listOfLengths(List<String> words, int evil) {
        List<Integer> result = words.stream()
            .filter(word -> !String.valueOf(evil).contains(word))
            .map(String::length)
            .collect(Collectors.toList());
        return result;
    }

    /*
     *   Remember, the objective of this lab is to use the features provided in Java 8
     *     
     *   returns a List of Robots using the parameter p to determine the street and avenue
     *       the Robot at index n is constructed at:
     *            Street p.get(n).getX()
     *            Avenue p.get(n).getY()
     *            Facing North
     *            with 10 beepers
     *        omit all Robots with a Street <= 0 or Avenue <= 0
     *        
     *        
    listOfLengths([new IntPoint(1, 1), new IntPoint(1, 0), new IntPoint(10, 2)])
    returns [new Robot(1, 1, North, 10). new Robot(10, 2, North, 10)]

     *   postcondition:  p remains unchanged
     */
    public static List<Robot> robotMaker(List<IntPoint> p) {
        return p.stream()
        .filter(point -> point.getX() > 0 && point.getY() > 0)
        .map(point -> new Robot(point.getX(), point.getY(), North, 10))
        .collect(Collectors.toList());
    }

    /*
     *   Remember, the objective of this lab is to use the features provided in Java 8
     *     
     *     Returns an Object[] of all elements in the parameter List<Object> items,
     *             omitting the first skipThese elements (skipThese is a parameter)
     *             
     *     you may assume items.size() > skipThese        
     *             
    getAsArray{ [1, 2, 3, 4, 5, 6, 7, 8, 9], 7) return [8, 9]          
     */
    public static Object[] getAsArray(List<Object> items, int skipThese) {
        if (skipThese >= 0 && skipThese < items.size()) {
            List<Object> sublist = items.subList(skipThese, items.size());
            return sublist.toArray();
        } else {
            return new Object[0];
        }
    }

    /*
     *   Remember, the objective of this lab is to use the features provided in Java 8
     *     
     *     Returns an array of all elements in the parameter List<Object> items,
     *             omitting the first skipThese elements (skipThese is a parameter)
     *             including only items that are an instanceof the Class indicated by the parameter obj
     *
     *   Review the last paragraph of the word file describing the isAssignableFrom method

    Given:    SuperBot extends BetterTurned extends Robot
    List<BetterTurner> rBot,
    Robot r;
    BetterTurned b;
    SuperBot s;

    rBot.get(0).getClass().isAssignableFrom(  r.getClass() ) returns false
    rBot.get(0).getClass().isAssignableFrom(  b.getClass() ) returns true
    rBot.get(0).getClass().isAssignableFrom(  s.getClass() ) returns true

    The following is sample code for the getTheseObjects(...) method

    List<Object> oList = new ArrayList<Object>();
    oList.add(new IntPoint(1, 1));
    oList.add(new PointSum(1, 0));
    oList.add(new PointProd(10, 2));
    oList.add(new PointSum(1, 1));
    oList.add(new PointProd(10, 12));
    oList.add(new IntPoint(21, 112));
    oList.add(new PointSum(17, 90));

    Object[] oResult = Java8StreamMapCollect.getTheseObjects(oList, new PointSum(9, 99), 5);
    assertEquals(1, oResult.length);
    assertEquals(new IntPoint(17, 90), oResult[0]);
     */
    public static Object[] getTheseObjects(List<Object> items, Object obj, int skipThese)
    {
        Object[] result = items.stream()
            .skip(skipThese)
            .filter(item -> item.getClass().isInstance(obj))
            .toArray();

        return result;
    }
}