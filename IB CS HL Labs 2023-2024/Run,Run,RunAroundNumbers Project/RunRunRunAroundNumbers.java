import java.util.*;
import java.lang.Math;
/**
 * RunRunRunAroundNumbers.
 *
 * @author  
 * @version (a version number or a date)
 */
public class RunRunRunAroundNumbers
{
    public static boolean isRunRoundNumber(int num)
    {
        // Convert the number to an array of digits
        char[] digits = Integer.toString(num).toCharArray();
        int length = digits.length;
        // Check for distinct digits
        for (int i = 0; i < length; i++) {
            for (int j = i + 1; j < length; j++) {
                if (digits[i] == digits[j]) {
                    return false; // Digits are not distinct
                }
            }
        }
        // Check for Runaround conditions
        int currentPosition = 0;
        for (int i = 0; i < length; i++) {
            int steps = Character.getNumericValue(digits[currentPosition]);
            currentPosition = (currentPosition + steps) % length;
        }
        // The sequence is a Runaround Number if it returns to the starting position
        return currentPosition == 0;
    }

    public static int getNextRunAroundNumber(int seqNum)
    {
        while (true) {
            if (isRunRoundNumber(seqNum)) {
                return seqNum;
            }
            seqNum++;
        
            
        }
    }
}