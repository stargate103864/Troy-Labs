import java.lang.*;
import java.util.*;
import java.lang.Math;
/**
 * @author  Don Allen
 * @version 2023 Wittry Contest
 */
public class AdjoiningDigits
{
    public static boolean isDivisibleBy(int number, int[] divisors)
    {
        for(int n : divisors){
            if(number%n!=0){
                return false;
            }
        }
        return true;
    }

    public static int getLCM(int[] num)
    {
        int sus = 1;
        while(!isDivisibleBy(sus,num)){
            sus++;
        }
        return sus;
    }

    /*    
    assertEquals(155232, AdjoiningDigits.adjoinDigits(523, 3, new int[] {7, 8, 9} ));
    assertEquals(1050, AdjoiningDigits.adjoinDigits(50, 2, new int[] {2, 5} ));
     */
    public static int adjoinDigits(int num, int numDigits, int[] divisors)
    {
        int sus = num;
        numDigits = numDigits+Integer.toString(num).length();
        String text = Integer.toString(sus);
        while(text.length()<numDigits || !text.contains(Integer.toString(num)) || !isDivisibleBy(sus,divisors)){
            if(text.length()>numDigits){
                return -1;
            }
            sus++;
            text = Integer.toString(sus);
        }
        return sus;
    }
}
