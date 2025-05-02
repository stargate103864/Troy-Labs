import java.util.*;
/**
 * Write a description of class MiscCollectionOfFunMethods here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MiscCollectionOfFunMethodsI {  

    public  static  int sumDigits(Integer i) {
        int x = Math.abs(i);
        int ans = 0;
        while (x >0)
        {
            ans += x %10;
            x = x / 10;
        }
        return ans;
    }

    public  static  boolean isDivisibleBy9(Integer i) {
        i = Math.abs(i);
        while (i > 9)
        {
            i = sumDigits(i);
        }
        return (i==9);
    } 

    public String toString() {
        // postcondition:     return a String with YOUR name and class period in it
        return "Ian Havill, 1";
    }

    public  static  double average(int[] numbers) {
        
        int ans = 0;
        for (int i : numbers)
        {
            ans += i;
        }
        return ans/(double)numbers.length;
    }

    public  static  double standardDeviation(int[] numbers) {
        double sum = 0.0;
        double stDev = 0.0;
        for (double num: numbers)
        {
            sum+=num;
        }
        double mean = sum/numbers.length;
        for (double num: numbers)
        {
            stDev += Math.pow(num - mean, 2);
        }
        return Math.sqrt(stDev/numbers.length);
    }
}
