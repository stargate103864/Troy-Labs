import java.awt.Color;
import java.util.*;
/**
 * Write a description of class Steganography here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class SteganographyMessage extends Steganography
{
    public static void main(String[] args)
    {
        Picture beach = new Picture ("images\\beach.jpg");
        beach.explore();
        Picture copy = pictureClearLow(beach);
        copy.explore();
    }

    /**
     *   Takes a string consisting of letters and spaces and
     *   encodes the string into an arraylist of integers.
     *   The integers are 1-26 for A-Z, 27 for space, and 0 for end of
     *   string. The arraylist of integers is returned.
     *   @param s string consisting of letters and spaces
     *   @return ArrayList containing integer encoding of uppercase
     *   version of s
     */
    public static List<Integer> encodeString(String s)
    {
        s = s.toUpperCase();
        String alpha = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        ArrayList<Integer> result = new ArrayList<Integer>();
        for (int i = 0; i < s.length(); i++)
        {
           /*    add code here    */
        }
        result.add(0);
        return result;
    }

    /**
     *   precondition:  codes.size() >= 1
     *                  codes.get(k).intValue() != 0, 0 <= k < codes.size() - 1
     *                  codes.get(codes.size() - 1).intValue() == 0
     *                  that is, codes contains exactly one 0, located at last index
     *   Returns the string represented by the codes arraylist.
     *   1-26 = A-Z, 27 = space
     *   @param codes encoded string
     *   @return decoded string
     */
    public static String decodeString(List<Integer> codes)
    {
        String result="";
        String alpha = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        for (int i=0; i < codes.size()-1; i++)
        {
           /*    add code here    */
        }
        return result;
    }

    /**
     *  Given a number from 0 to 63, creates and returns a 3-element
     *  int array consisting of the integers representing the
     *  pairs of bits in the number from right to left.
     *  
     *  red represents the least significant two bits
     *  and blue represnts the most significant bit 
     *       (note 0 fills the second bit/more significant bit)
     *  
     *  @param num number to be broken up
     *  @return bit pairs in number
     */
    public static int[] getBitPairs(int num)
    {
        return null;
    }

    /**
     *   Hide a string (must be only letters and spaces) in a picture.
     *   The string always starts in the upper left corner.
     *   @param source picture to hide string in
     *   @param s string to hide
     *   @return picture with hidden string
     */
    public static Picture hideText(Picture source, String s)
    {
        return new Picture();
    }

    /**
     *   Returns a string hidden in the picture
     *   @param source picture with hidden string
     *   @return revealed string
     */
    public static String revealText(Picture source)
    {
        return null;
    }
}